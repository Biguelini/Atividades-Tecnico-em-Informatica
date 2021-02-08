#recenbendo notas
med = (float(input('Digite a primeira nota (De 0.0 até 10.0)... ')) + float(input('Digite a segunda nota... ')))/2

#mostrando situação do aluno
if med > 7:
    print('Aprovado!')
else:
    print('Reprovado!')
