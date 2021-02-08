nomes = [0,0,0,0,0,0,0,0,0,0]
telefone = [0,0,0,0,0,0,0,0,0,0]
i = 0
while(i < 2):
    nomes[i]=input("Digite um nome... ")
    telefone[i]=input("Digite o telefone respectivo ")
    i+=1
i=nomes.index(input("Qual nome referente ao número desejado? "))
print(f"O número de {nomes[i]} é {telefone[i]}")