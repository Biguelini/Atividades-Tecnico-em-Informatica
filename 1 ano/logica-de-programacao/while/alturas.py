c=0
mais=0
menos=0
while(c<20):
    c+=1
    a=float(input(f"Digite a altura {c}... "))
    if(a>1.8):
        mais+=1
    elif(a<1.6):
        menos+=1
print(f"Das {c} alturas, {mais} são maiores que 1,80m e {menos} são menores que 1,60m!")