c=0
b = 0
m = 0
a = 0
aa = 0
cont=0
while(c==0): 
    print("Olá! Qual o seu nível de stress na quarentena? ")
    print("""    1 - baixo
    2 - moderado
    3 - alto
    4 - altíssimo
    0 - cancelar""")
    x = int(input("Digite o número correspondente ao nível... "))
    if(x==1):
        b += 1
        cont+=1
    elif(x==2):
        m += 1
        cont+=1
    elif(x==3):
        a += 1
        cont+=1
    elif(x==4):
        aa += 1
        cont+=1
    else:
        c+=1
if(cont==0):
    cont=1
frb=(b/cont)*100
frm=(m/cont)*100
fra=(a/cont)*100
fraa=(aa/cont)*100
gb=frb*3.6
gm=frm*3.6
ga=fra*3.6
gaa=fraa*3.6
print(f"              Frequência     Frequência relativa     Graus")
print(f"baixo             {b}                {frb:.2f}%             {gb:.0f}º")
print(f"moderado          {m}                {frm:.2f}%             {gm:.0f}º")
print(f"alto              {a}                {fra:.2f}%             {ga:.0f}º")
print(f"altíssimo         {aa}                {fraa:.2f}%             {gaa:.0f}º")



