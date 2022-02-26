from datetime import datetime
from django.shortcuts import render, get_object_or_404, redirect
from django.http import Http404
from .models import FormRegistrar, Transacao, Saldo
from django.core.paginator import Paginator
from django.contrib import messages, auth
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required

# Create your views here.


def index(request):
    existe = True
    data_atual = datetime.today().strftime("%Y-%m-%d")
    data_formatada = datetime.today().strftime("%d/%m/%Y")
    saldos = Saldo.objects.order_by('-data')
    meu_saldo = 0
    for saldo in saldos:
        if data_atual == saldo.data.strftime("%Y-%m-%d"):
            existe = True
            print(data_atual, saldo.data.strftime("%Y-%m-%d"))
        else:
            existe = False
        meu_saldo += saldo.valor
    if not existe:
        saldo = Saldo(valor=0)
        saldo.save()
    print(meu_saldo)
    transacoes = Transacao.objects.order_by('-data')
    paginator = Paginator(transacoes, 5)
    page = request.GET.get('p')
    transacoes = paginator.get_page(page)
    num_transacoes = len(transacoes)
    meu_saldo = round(meu_saldo, 2)
    return render(request, 'movimentacao/index.html', {
        'transacoes': transacoes,
        'saldo': meu_saldo,
        'data': data_formatada,
        'num_transacoes': num_transacoes,
    })


def login(request):
    if request.method != 'POST':
        return render(request, 'movimentacao/login.html')

    usuario = request.POST.get('usuario')
    senha = request.POST.get('senha')

    user = auth.authenticate(request, username=usuario, password=senha)

    if not user:
        messages.error(request, 'Usuário ou senha inválidos')
        return render(request, 'movimentacao/login.html')
    else:
        auth.login(request, user)
        return redirect('index')


def logout(request):
    auth.logout(request)
    return redirect('index')


def registrar(request):
    existe = True
    if request.method != 'POST':
        form = FormRegistrar()
        return render(request, 'movimentacao/registrar.html', {'form': form})
    form = FormRegistrar(request.POST, request.FILES)

    if not form.is_valid():
        messages.error(request, 'Erro ao enviar o formulário')
        form = FormRegistrar(request.POST)
        return render(request, 'movimentacao/registrar.html', {'form': form})
    
    data_atual = datetime.today().strftime("%Y-%m-%d")
    saldos = Saldo.objects.order_by('-data')
    meu_saldo = 0
    for saldo in saldos:
        if data_atual == saldo.data.strftime("%Y-%m-%d"):
            existe = True
        else:
            existe = False
        meu_saldo += saldo.valor
    if not existe:
        saldo = Saldo(valor=0)
        saldo.save()
    tipo = request.POST.get('tipo')
    for saldo in saldos:
        if data_atual == saldo.data.strftime("%Y-%m-%d"):
            if(tipo == '1'):
                saldo.valor -= int(request.POST.get('valor'))
            else:
                saldo.valor += int(request.POST.get('valor'))
        saldo.save()
    form.save()
    messages.success(
        request, f"{request.POST.get('descricao')} registrado com sucesso")
    return redirect('registrar')


def busca(request):
    datamin = request.GET.get('datamin')
    datamax = request.GET.get('datamax')
    if datamin != "" and datamax != "":
        if(datamin<datamax):
        
            transacoes = Transacao.objects.order_by('-data').filter(data__gt=datamin, data__lt=datamax)
            num_transacoes = len(transacoes)
            return render(request, 'movimentacao/busca.html', {
                'transacoes': transacoes,
                'num_transacoes': num_transacoes,
            })
    messages.error(request, 'Preencha as datas')
    return redirect('index')