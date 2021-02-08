print('Ax² + Bx + C')

a = float(input('Digite o valor de A '))
b = float(input('Digite o valor de B '))
c = float(input('Digite o valor de C '))

delta = b**2-4*a*c

if delta > 0:
    print('A equação possui duas raízes diferentes')
elif delta == 0:
    print('A equação possui duas raízes iguais')
else:
    print('A equação não possui raíz real')
