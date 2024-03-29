from django.db import models

from django.utils import timezone
from django import forms

# Create your models here.


class Type(models.Model):
    name = models.CharField(max_length=255)

    def __str__(self):
        return self.name


class Transactions(models.Model):
    date = models.DateTimeField(default=timezone.now, verbose_name='Data')
    description = models.CharField(max_length=255, blank=False, verbose_name='Descrição')
    value = models.DecimalField(max_digits=20, decimal_places=2, verbose_name='Valor')
    type = models.ForeignKey(Type, on_delete=models.DO_NOTHING, verbose_name='Tipo')
    # tipo = models.CharField(max_length=1, blank=False)

    def __str__(self):
        return self.description


class Balances(models.Model):
    value = models.DecimalField(max_digits=50, decimal_places=2)
    date = models.DateTimeField(default=timezone.now)

    def __str__(self):
        return str(self.value)


class RegisterForm(forms.ModelForm):
    class Meta:
        model = Transactions
        fields = '__all__'
        widgets = {
            'date': forms.TextInput(attrs={'type': 'date'}),

        }
