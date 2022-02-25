from django.db import models

from django.utils import timezone
from django import forms

# Create your models here.


class Tipo(models.Model):
    nome = models.CharField(max_length=255)
    
    def __str__(self):
        return self.nome


class Transacao(models.Model):
    data = models.DateTimeField(default=timezone.now)
    descricao = models.CharField(max_length=255, blank=False)
    valor = models.DecimalField(max_digits= 20, decimal_places=2)
    tipo = models.ForeignKey(Tipo, on_delete=models.DO_NOTHING)
    # tipo = models.CharField(max_length=1, blank=False)
    
    def __str__(self):
        return self.descricao

class Saldo(models.Model):
    valor = models.DecimalField(max_digits= 50, decimal_places=2)
    data = models.DateTimeField(default=timezone.now)
    def __str__(self):
        return str(self.valor)

class FormRegistrar(forms.ModelForm):
    class Meta:
        model = Transacao
        exclude = ('data',)