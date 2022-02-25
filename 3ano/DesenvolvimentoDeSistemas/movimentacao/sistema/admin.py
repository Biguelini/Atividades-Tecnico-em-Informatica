from django.contrib import admin

# Register your models here.
from .models import Transacao, Tipo, Saldo
# Register your models here.
class TransacaoAdmin(admin.ModelAdmin):
    list_display = ('id', 'data', 'descricao', 'valor', 'tipo')
    list_display_links = ('descricao',)
    list_per_page = 10
    search_fields = ('descricao', 'data')

# Register your models here.
admin.site.register(Tipo)
admin.site.register(Saldo)
admin.site.register(Transacao, TransacaoAdmin)