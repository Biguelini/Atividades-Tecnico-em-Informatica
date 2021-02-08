nomes = [0,0,0,0,0,0,0,0,0,0]
i = 0
while(i < 10):
    nomes[i]=input("Digite um nome... ")
    i+=1
i=0
while(i != -1):
    print("Qual nome você gostaria de consultar?")
    print("Digite um número de 0 a 9")
    i = int(input("Para cancelar, basta digitar -1... "))
    if(i < 10 and i > -1):
        print(f"O nome da posição {i} é {nomes[i]}")