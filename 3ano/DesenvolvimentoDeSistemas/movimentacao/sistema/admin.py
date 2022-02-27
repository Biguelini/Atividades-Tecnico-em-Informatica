from django.contrib import admin

# Register your models here.
from .models import Transactions, Type, Balances
# Register your models here.
class TransactionsAdmin(admin.ModelAdmin):
    list_display = ('id', 'date', 'description', 'value', 'type')
    list_display_links = ('description',)
    list_per_page = 10
    search_fields = ('description', 'date')

# Register your models here.
admin.site.register(Type)
admin.site.register(Balances)
admin.site.register(Transactions, TransactionsAdmin)