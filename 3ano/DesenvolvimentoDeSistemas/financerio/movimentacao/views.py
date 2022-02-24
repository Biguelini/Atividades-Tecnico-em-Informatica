from django.shortcuts import render, get_object_or_404, redirect
from django.http import Http404
from .models import FormRegistrar, Transacao, Tipo
from django.core.paginator import Paginator
from django.db.models import Q, Value
from django.db.models.functions import Concat
from django.contrib import messages, auth
from django.core.validators import validate_email
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required

# Create your views here.

def index(request):
    saldo = 0
    transacoes = Transacao.objects.order_by('data')
    saidas = Transacao.objects.order_by('id').filter(tipo=1)
    entrada = Transacao.objects.order_by('id').filter(tipo=2)
    paginator = Paginator(transacoes, 5)
    page = request.GET.get('p')
    transacoes = paginator.get_page(page)

    for s in saidas:
        saldo -= float(s.valor)
    for e in entrada:
        saldo += float(e.valor)

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
        return render(request, 'movimentacao/registrar.html', {'form':form})
    form = FormRegistrar(request.POST, request.FILES)
    
    if not form.is_valid():
        messages.error(request, 'Erro ao enviar o formulário')
        form = FormRegistrar(request.POST)
        return render(request, 'movimentacao/registrar.html', {'form':form})
    form.save()
    messages.success(request, f"{request.POST.get('descricao')} cadastrado com sucesso")
    return redirect('registrar')