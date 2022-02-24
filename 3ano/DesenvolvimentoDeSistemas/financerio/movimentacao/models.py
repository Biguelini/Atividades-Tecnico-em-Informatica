from django.db import models
from django.utils import timezone

# Create your models here.


class Tipo(models.Model):
    nome = models.CharField(max_length=255)
    
    def __str__(self):
        return self.nome


class Transacao(models.Model):
    data = models.DateTimeField(default=timezone.now)
    descricao = models.CharField(max_length=255, blank=True)
    valor = models.DecimalField(max_digits= 20, decimal_places=2)
    tipo = models.ForeignKey(Tipo, on_delete=models.DO_NOTHING)
    
    def __str__(self):
        return self.descricao