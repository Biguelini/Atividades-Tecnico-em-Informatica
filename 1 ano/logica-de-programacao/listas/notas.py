# iniciando variáveis 
nomes = []
notas = []
s = 0 
c = 0
i=''
# coletando os nomes e as notas
while(i != 'fim'):
    i=input('Digite o nome do aluno ')
    if(i!='fim'):
        nomes.append(i)
        notas.append(float(input('Digite a nota do aluno ')))
        s += notas[c]
        c+=1
# calculando a média e reiniciando variáveis
m = s/c
c = ''
s = 0
# loop para consulta de nomes
while(c!='fim'):
    c = input('Digite o nome do aluno que deseja consultar, ou digite fim para sair! ')
    if(c != 'fim'):
        while(c != nomes[s]):
            s+=1
        print(f'O aluno {nomes[s]} tirou {notas[s]:.1f}')
        # condições de notas, abaixo, acima ou na média
        if(notas[s] < m):
            print(f'E ficou abaixo da média, que foi {m:.1f}')
        elif(notas[s] > m):
            print(f'E ficou acima da média, que foi {m:.1f}')
        elif(notas[s] == m):
            print(f'E ficou na média, que foi {m:.1f}')
        # erro 
        else:
            print('[ERRO]')
    s = 0
print('Saindo... ')