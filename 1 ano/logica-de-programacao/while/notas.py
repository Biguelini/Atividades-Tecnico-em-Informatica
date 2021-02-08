c=0
maior = 0
menor = 11
abaixo = 0
s = 0
while(c<10):
    nota = float(input("Digite a nota de 0 a 10 "))
    s += nota
    if(nota>maior):
        maior=nota
    elif(nota<menor):
        menor=nota
    if(nota<6):
        abaixo += 1
    c+=1
media=s/10
print(f"A média das 10 notas é {media}, sendo que {abaixo} alunos ficaram abaixo de 6. A maior nota foi {maior} e a menor foi {menor}!")