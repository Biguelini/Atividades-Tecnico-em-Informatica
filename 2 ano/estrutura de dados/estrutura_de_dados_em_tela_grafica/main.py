from bd.bd_produtos import insere, pesquisa
from vo.caminhao import Caminhao
from vo.produto import Produto

import six
import sys
sys.modules['sklearn.externals.six'] = six
import mlrose


c = Caminhao(3)
p = Produto('tv', 0.5, 50)
insere(p)
p = Produto('celular', 0.1, 100)
insere(p)
p = Produto('refrigerador', 0.7, 700)
insere(p)
p = Produto('caneca', 0.2, 10)
insere(p)
p = Produto('bola', 0.245, 20)
insere(p)
p = Produto('luva', 0.05, 5)
insere(p)

produtos = pesquisa()

def fitness_function(solucao):
    custo = 0
    soma_espaco = 0
    for i in range(len(solucao)):
        if(solucao[i]==1):
            custo+=produtos[i][2]
            soma_espaco+=produtos[i][1]
        if(soma_espaco>c.volume):
            custo = 1
        
    return custo
fitness = mlrose.CustomFitness(fitness_function)
problema = mlrose.DiscreteOpt(length = len(produtos), fitness_fn = fitness, maximize = True, max_val = 2)

melhor_solucao, melhor_custo = mlrose.genetic_alg(problema, pop_size=500, mutation_prob=0.2)
print(melhor_solucao)
print(melhor_custo)