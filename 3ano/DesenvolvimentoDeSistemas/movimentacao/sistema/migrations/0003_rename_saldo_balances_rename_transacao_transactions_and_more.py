# Generated by Django 4.0.2 on 2022-02-27 16:28

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('sistema', '0002_rename_valor_saldo_value'),
    ]

    operations = [
        migrations.RenameModel(
            old_name='Saldo',
            new_name='Balances',
        ),
        migrations.RenameModel(
            old_name='Transacao',
            new_name='Transactions',
        ),
        migrations.RenameModel(
            old_name='Tipo',
            new_name='Type',
        ),
        migrations.RenameField(
            model_name='balances',
            old_name='data',
            new_name='date',
        ),
        migrations.RenameField(
            model_name='transactions',
            old_name='data',
            new_name='date',
        ),
        migrations.RenameField(
            model_name='transactions',
            old_name='descricao',
            new_name='description',
        ),
        migrations.RenameField(
            model_name='transactions',
            old_name='tipo',
            new_name='type',
        ),
        migrations.RenameField(
            model_name='transactions',
            old_name='valor',
            new_name='value',
        ),
        migrations.RenameField(
            model_name='type',
            old_name='nome',
            new_name='name',
        ),
    ]
