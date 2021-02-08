#recebendo os inputs com valores 
v1 = float(input('Digite o 1º valor... '))
v2 = float(input('Digite o 2º valor... '))
v3 = float(input('Digite o 3º valor... '))

t = False

#verificando se é mesmo um triângulo
if v1+v2 > v3 and v1+v3 > v2 and v2+v3 > v1:
    t=True
else:
    t=False

#mostrando na tela se é ou não triângulo
if t==True:
    print(f'As medidas {v1 :.2f} - {v2 :.2f} - {v3 :.2f} formam um triângulo')
else:
    print(f'As medidas {v1 :.2f} - {v2 :.2f} - {v3 :.2f} não formam um triângulo')
