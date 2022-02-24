from django.shortcuts import render, get_object_or_404, redirect
from django.http import Http404
from .models import FormRegistrar, Transacao, Saldo
from django.core.paginator import Paginator
from django.contrib import messages, auth
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required

# Create your views here.


def index(request):
    saldo = 0
    transacoes = Transacao.objects.order_by('-data')
    paginator = Paginator(transacoes, 5)
    page = request.GET.get('p')
    transacoes = paginator.get_page(page)

    for t in transacoes:
        if t.tipo_id == 1:
            saldo -= t.valor
        else:
            saldo += t.valor

    saldo = round(saldo, 2)
    return render(request, 'movimentacao/index.html', {
        'transacoes': transacoes,
        'saldo': saldo
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
    if request.method != 'POST':
        form = FormRegistrar()
        return render(request, 'movimentacao/registrar.html', {'form': form})
    form = FormRegistrar(request.POST, request.FILES)

    if not form.is_valid():
        messages.error(request, 'Erro ao enviar o formulário')
        form = FormRegistrar(request.POST)
        return render(request, 'movimentacao/registrar.html', {'form': form})
    if not Saldo.objects.filter(id=1):
        saldo = Saldo(id=1, valor=0)
        saldo.save()

    tipo = request.POST.get('tipo')
    saldo = get_object_or_404(Saldo, pk=1)
    print(tipo)
    if(tipo == '1'):
        saldo.valor -= int(request.POST.get('valor'))
    else:
        saldo.valor += int(request.POST.get('valor'))
    print(saldo.valor)
    form.save()
    saldo.save()
    messages.success(
        request, f"{request.POST.get('descricao')} registrado com sucesso")
    return redirect('registrar')
