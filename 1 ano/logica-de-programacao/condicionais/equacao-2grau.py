import math
a = float(input('Digite o coeficiente A da equação'))
b = float(input('Digite o coeficiente B da equação'))
c = float(input('Digite o coeficiente C da equação'))
delta=b**2-4*a*c
if delta >= 0:  
    x1=(-b+math.sqrt(delta))/(2*a)
    x2=(-b-math.sqrt(delta))/(2*a)    
    print(f'As raízes da equação são: x¹ = {x1 :.2f} e x² = {x2 :.2f}')
else:
    print('O a equação não possui raízes reais')
