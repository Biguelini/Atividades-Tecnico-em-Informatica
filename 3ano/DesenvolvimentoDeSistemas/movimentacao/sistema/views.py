from django.shortcuts import render, redirect
from django.contrib import messages, auth
from sistema.models import Saldo, Transacao
from django.core.paginator import Paginator
from datetime import datetime
# Create your views here.


def index(request):
    existe = False
    # pegando a data atual
    data_formatada = datetime.today().strftime("%d/%m/%Y")
    data_atual = datetime.today().strftime("%Y-%m-%d")
    # saldo
    meu_saldo = 0
    saldos = Saldo.objects.order_by('data')
    for saldo in saldos:
        if not existe:
            if data_atual == saldo.data.strftime("%Y-%m-%d"):
                existe = True
                # meu_saldo += saldo.valor
            else:
                existe = False
        meu_saldo += saldo.valor

    if not existe:
        saldo = Saldo(valor=0)
        saldo.save()
        existe = True
        # meu_saldo = 0

    # transacoes e paginacao
    transacoes = Transacao.objects.order_by('-data')
    paginator = Paginator(transacoes, 5)
    page = request.GET.get('p')
    transacoes = paginator.get_page(page)
    num_transacoes = len(transacoes)
    return render(request, 'sistema/index.html', {
        'transacoes': transacoes,
        'saldo': meu_saldo,
        'data': data_formatada,
        'num_transacoes': num_transacoes,
    })


def login(request):
    if request.method != 'POST':
        return render(request, 'sistema/login.html')

    usuario = request.POST.get('usuario')
    senha = request.POST.get('senha')

    user = auth.authenticate(request, username=usuario, password=senha)

    if not user:
        messages.error(request, 'Usuário ou senha inválidos')
        return render(request, 'sistema/login.html')
    else:
        auth.login(request, user)
        return redirect('index')


def logout(request):
    auth.logout(request)
    return redirect('index')


def registrar(request):
    pass


def busca(request):

    datamin = request.GET.get('datamin')
    datamax = request.GET.get('datamax')
    if datamin != "" and datamax != "":
        if(datamin < datamax):
            existe = False
            # pegando a data atual
            data_formatada = datetime.today().strftime("%d/%m/%Y")
            data_atual = datetime.today().strftime("%Y-%m-%d")
            # saldo
            meu_saldo_total = 0
            meu_saldo_hoje = 0
            saldos = Saldo.objects.order_by('data')
            for saldo in saldos:
                if not existe:
                    if data_atual == saldo.data.strftime("%Y-%m-%d"):
                        existe = True
                        meu_saldo_hoje += saldo.valor
                    else:
                        existe = False
                meu_saldo_total+=saldo.valor
            if not existe:
                saldo = Saldo(valor=0)
                saldo.save()
                existe = True
                
            # transacoes e paginacao
            transacoes = Transacao.objects.order_by('-data').filter(data__gt=datamin, data__lt=datamax)
            num_transacoes = len(transacoes)
            return render(request, 'sistema/busca.html', {
                'transacoes': transacoes,
                'saldo_total': meu_saldo_total,
                'saldo_hoje': meu_saldo_hoje,
                'data': data_formatada,
                'num_transacoes': num_transacoes,
            })
    messages.error(request, 'Preencha as datas')
    return redirect('index')
