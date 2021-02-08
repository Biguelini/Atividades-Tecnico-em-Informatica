# declarando minhas listas e variáveis 
x=[0,0,0,0] #coluna x
y=[0,0,0,0] #coluna y
xy=[0,0,0,0] #coluna xy
x2=[0,0,0,0] #coluna x²
a=0 #utilizo para contador neste primeiro momento
b=0
while(a<3): #loop para receber os valores de x e y
    x[a]=float(input("Digite um valora para x... ")) #recebe um valor de x e armazena na lista da coluna x
    y[a]=float(input("Digite um valora para Y... ")) #recebe um valor de y e armazena na lista da coluna y
    xy[a]=x[a]*y[a] #faz a multiplicação do xy
    x2[a]=x[a]*x[a] #eleva o x ao quadrado e guarda em x2
    a+=1 #pula para a próxima linha até dar 3 linhas na "tabela"
#preenchendo a última linha
x[3]=x[0]+x[1]+x[2]
y[3]=y[0]+y[1]+y[2]
xy[3]=xy[0]+xy[1]+xy[2]
x2[3]=x2[0]+x2[1]+x2[2]
a=(3*xy[3]-x[3]*y[3])/(3*x2[3]-(x[3]**2)) #reseto a e acho seu valor
b=(y[3]/3)-((a*x[3])/3)
print(f"y={a}x+{b}")