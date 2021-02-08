v = []
c = 0
while(c<5):
    c+=1
    i = int(input(f"Digite o {c}º valor... "))
    v.append(i)
c = len(v)
m = (v[0]+ v[1]+ v[2]+ v[3]+ v[4])/c
v1 = v[0]
v2 = v[1]
v3 = v[2]
v4 = v[3]
v5 = v[4]
a1 = v1-m
a2 = v2-m
a3 = v3-m
a4 = v4-m
a5 = v5-m
print(f"A média é {m}, e as anomalias para os valores {v1}; {v2}; {v3}; {v4}; {v5} são respectivamente: {a1}; {a2}; {a3}; {a4}; {a5}")