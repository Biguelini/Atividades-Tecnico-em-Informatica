menor = 0
c = 1
s = float(input("Digite o 1 salário"))
while(c<=14):
    c+=1
    s = float(input(f"Digite o {c} salário"))
    if(s<menor):
        menor = s
print(f"O menor salário entre os {c} foi R${menor:.2f}")