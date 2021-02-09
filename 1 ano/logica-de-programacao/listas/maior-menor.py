l = [0,0,0,0,0,0,0,0,0,0]
c = 0
maior=0
menor=0
while(c<10):
    i=float(input("Digite um valor... "))
    l[c]=i
    if(l[c]>l[maior]):
        maior=c
    if(l[c]<l[menor]):
        menor=c
    c+=1
print(f"maior número é {l[maior]} que está na posição {maior}")
print(f"O menor número é {l[menor]} que está na posição {menor}")