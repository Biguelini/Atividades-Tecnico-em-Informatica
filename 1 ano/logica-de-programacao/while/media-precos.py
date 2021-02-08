empresas=10
contagem=1
soma=0
media=0
while(contagem<=empresas):
    soma+=float(input(f"Qual o preço do produto na empresa {contagem}?"))
    contagem+=1
media=soma/empresas
print(f"A média de preço entre as {empresas} empresas é R${media:.2f}")