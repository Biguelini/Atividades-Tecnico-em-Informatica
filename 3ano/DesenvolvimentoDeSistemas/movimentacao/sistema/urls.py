from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('login/', views.login, name='login'),
    path('logout/', views.logout, name='logout'),
    path('registrar_movimento/', views.register_movement, name='register_movement'),
    path('recibo/', views.receipt, name='receipt'),
]