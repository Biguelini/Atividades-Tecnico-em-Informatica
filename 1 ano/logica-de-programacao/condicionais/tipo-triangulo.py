#recebendo os inputs com valores 
v1 = float(input('Digite o 1º valor... '))
v2 = float(input('Digite o 2º valor... '))
v3 = float(input('Digite o 3º valor... '))

#tipos de triângulo:
#0-não é triângulo;
#1-equilátero;
#2-isóceles;
#3-escaleno
tipo = 0

#verificando se é realmente triângulo
if v1+v2 > v3 and v1+v3 > v2 and v2+v3 > v1:
    #verificando o tipo
    if v1 == v2 == v3:
        tipo = 1
    elif v1 == v2 and v2 != v3 or v1 == v3 and v3 != v2 or v3 == v2 and v2 != v1:
        tipo = 2
    elif v1 != v2 != v3:
       tipo = 3
#se não for triângulo
else:
    tipo = 0

#mostrando o tipo
if tipo == 0:
    print(f'Os valores {v1} - {v2} - {v3} não formam um triângulo!')
elif tipo == 1:
    print(f'Os valores {v1} - {v2} - {v3} formam um triângulo equilátero!')
elif tipo == 2:
    print(f'Os valores {v1} - {v2} - {v3} formam um triângulo isóceles!')
elif tipo == 3:
    print(f'Os valores {v1} - {v2} - {v3} formam um triângulo escaleno!')
