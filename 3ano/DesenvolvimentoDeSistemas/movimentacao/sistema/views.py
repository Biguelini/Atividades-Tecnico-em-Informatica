from django.shortcuts import render, redirect
from django.contrib import messages, auth
from sistema.models import RegisterForm, Balances, Transactions
from django.core.paginator import Paginator
from datetime import datetime, timedelta
from django.contrib.auth.decorators import login_required
# Create your views here.


def index(request):
    balance_yesterday = 0
    my_balance = 0

    current_balance_exists = False
    for balance in Balances.objects.order_by('date'):
        balance_date = balance.date.strftime("%Y-%m-%d")
        if datetime.today().strftime("%Y-%m-%d") == balance_date:
            current_balance_exists = True
        else:
            if(int(datetime.today().strftime('%H')) >= 21 and balance_date == (datetime.today()+timedelta(days=1)).strftime("%Y-%m-%d")):
                current_balance_exists = True
                my_balance = balance.value
            else:
                if not current_balance_exists:
                    current_balance_exists = False
        if (datetime.today()-timedelta(days=1)).strftime("%Y-%m-%d") == balance_date:
            balance_yesterday = balance.value

        my_balance = balance.value
    if not current_balance_exists:
        balance = Balances(date=datetime.today(), value=balance_yesterday)
        balance.save()
        current_balance_exists = True

    # transacoes e paginacao
    transactions = Transactions.objects.order_by('-date')
    paginator = Paginator(transactions, 5)
    page = request.GET.get('p')
    transactions = paginator.get_page(page)
    num_transactions = len(transactions)
    return render(request, 'sistema/index.html', {
        'transactions': transactions,
        'balance': my_balance,
        'num_transactions': num_transactions,
    })


def login(request):
    if request.method != 'POST':
        return render(request, 'sistema/login.html')

    user_request = auth.authenticate(request, username=request.POST.get(
        'username'), password=request.POST.get('password'))
    if not user_request:
        messages.error(request, 'Usuário ou senha inválidos')
        return render(request, 'sistema/login.html')
    else:
        auth.login(request, user_request)
        return redirect('index')


def logout(request):
    auth.logout(request)
    return redirect('index')


@login_required(login_url='/', redirect_field_name='')
def register_movement(request):
    balance_yesterday = 0
    is_the_last = False
    current_balance_exists = False
    if request.method != 'POST':
        form = RegisterForm()
        return render(request, 'sistema/register_movement.html', {'form': form})
    form = RegisterForm(request.POST, request.FILES)
    if not form.is_valid():
        messages.error(request, 'Erro ao enviar o formulário')
        form = RegisterForm(request.POST)
        return render(request, 'sistema/register_movement.html', {'form': form})
    date = datetime.strptime(request.POST.get('date'), '%Y-%m-%d')
    type = request.POST.get('type')
    value = request.POST.get('value')
    for balance in Balances.objects.order_by('date'):
        balance_date = datetime.strptime(balance.date.strftime("%Y-%m-%d"), '%Y-%m-%d')
        if date == balance_date or balance_date > date:
            if type == '1':
                modified_balance = float(balance.value) - float(value)
            else:
                modified_balance = float(balance.value) + float(value)
            balance.value = modified_balance
            balance.save()
            
            
        if date == balance_date:
            current_balance_exists = True
        else:
            if not current_balance_exists:
                current_balance_exists = False
        if (date > balance_date):
            if type == '1':
                balance_yesterday = float(balance.value) - float(request.POST.get('value'))
            else:
                balance_yesterday = float(balance.value) + float(request.POST.get('value'))
    
    for balance in Balances.objects.order_by('-date'):  
        if (date<balance_date):
            if type == '1':
                balance_yesterday = 0 - float(request.POST.get('value'))
            else:
                balance_yesterday = float(request.POST.get('value'))
            
    if not current_balance_exists:
        balance = Balances(date=date, value=balance_yesterday)
        balance.save()
        current_balance_exists = True
    form.save()
            

    messages.success(
        request, f"{request.POST.get('description')} registrado com sucesso")
    return redirect('register_movement')


def receipt(request):

    mindate = request.GET.get('mindate')
    maxdate = request.GET.get('maxdate')
    inicial_balance = 0
    final_balance=0

    if mindate != "" and maxdate != "":
        maxdate = datetime.strptime(maxdate, '%Y-%m-%d')
        maxdate = (maxdate+timedelta(days=1)).strftime("%Y-%m-%d")
        mindate = datetime.strptime(mindate, '%Y-%m-%d')
        mindate = (mindate-timedelta(days=1)).strftime("%Y-%m-%d")
        if(mindate < maxdate or mindate == maxdate):
            for balance in Balances.objects.order_by('date'):
                if balance.date.strftime("%Y-%m-%d") <= mindate:
                    inicial_balance = balance.value
                if mindate <= balance.date.strftime("%Y-%m-%d") and maxdate > balance.date.strftime("%Y-%m-%d"):
                    final_balance = balance.value

            # transacoes e paginacao
            transactions = Transactions.objects.order_by(
                '-date').filter(date__gt=mindate, date__lt=maxdate)
            return render(request, 'sistema/receipt.html', {
                'transactions': transactions,
                'final_balance': final_balance,
                'inicial_balance': inicial_balance,
                'num_transactions': len(transactions),
            })
    messages.error(request, 'Preencha as datas corretamente')
    return redirect('index')
