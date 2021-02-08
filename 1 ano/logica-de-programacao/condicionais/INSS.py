print("-------------------------------- CALCULAR DESCONTO INSS --------------------------------")
s=float(input("Digite o valor do salário... "))
p=0
d=0
n=0
if s<=1500:
    p=8
    d=(s*p)/100
    n=s-d
elif s<=2500:
    p=9
    d=(s*p)/100
    n=s-d
elif s<=3500:
    p=10
    d=(s*p)/100
    n=s-d
else:
    p=14
    d=(s*p)/100
    n=s-d
print(f"""Salário: R${s:.2f}
Percentual de desconto: {p}%
Valor descontado: R${d:.2f}
Salário final: R${n:.2f}""")
