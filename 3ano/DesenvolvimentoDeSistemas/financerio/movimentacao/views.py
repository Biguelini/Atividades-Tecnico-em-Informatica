from django.shortcuts import render, get_object_or_404, redirect
from django.http import Http404
from .models import Transacao
from django.core.paginator import Paginator
from django.db.models import Q, Value
from django.db.models.functions import Concat
from django.contrib import messages

# Create your views here.


def index(request):

    transacoes = Transacao.objects.order_by('data')
    paginator = Paginator(transacoes, 5)

    page = request.GET.get('p')
    transacoes = paginator.get_page(page)

    return render(request, 'movimentacao/index.html', {
        'transacoes': transacoes
    })


def registrar(request):
    pass
