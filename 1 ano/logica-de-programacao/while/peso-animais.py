contagem = 1
peso = 0
total = 0
menor = 0
maior = 0

peso = float(input(f"Digite o peso do animal {contagem}... "))
contagem += 1
total += peso
menor = peso
maior = peso
while(contagem <= 20):
    peso = float(input(f"Digite o peso do animal {contagem}... "))
    total += peso
    contagem += 1
    if(peso > maior):
        maior = peso
    elif(peso < menor):
        menor = peso
media = total/20
print(f"A média de peso entre os 20 animais foi {media:.2f}Kg, sendo o maior peso {maior:.2f}Kg e o menor {menor:.2f}Kg")