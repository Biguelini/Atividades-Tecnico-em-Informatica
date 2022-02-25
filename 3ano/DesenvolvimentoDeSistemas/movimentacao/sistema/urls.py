from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('login/', views.login, name='login'),
    path('logout/', views.logout, name='logout'),
    path('registrar/', views.registrar, name='registrar'),
    path('busca/', views.busca, name='busca'),
]