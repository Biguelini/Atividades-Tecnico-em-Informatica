peso1 = float(input('Digite o peso do primeiro animal... '))
peso2 = float(input('Digite o peso do segundo animal... '))

if peso1 > peso2:
    print('O primeiro animal é mais pesado')
elif peso1 < peso2:
    print('O segundo animal é mais pesado')
else:
    print('Os dois animais têm o mesmo peso')
