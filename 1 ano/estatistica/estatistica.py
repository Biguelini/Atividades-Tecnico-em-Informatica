import math
v = []
c = 0
while(c<5):
    c+=1
    i = float(input(f"Digite o {c}º valor... "))
    v.append(i)
c = len(v)
m = (v[0]+ v[1]+ v[2]+ v[3]+ v[4])/c
a = [v[0]-m, v[1]-m, v[2]-m, v[3]-m, v[4] -m]
print(f"A média é {m}, e as anomalias para os valores {v} são respectivamente: {a}")