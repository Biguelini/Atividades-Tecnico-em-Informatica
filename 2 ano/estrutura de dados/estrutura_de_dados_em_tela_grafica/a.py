produtos = [(0,'Refrigerador A', 999.90, 0.751),
            (1,'Celular', 2911.12, 0.0000899),
            (2,'TV 55', 4346.99, 0.400),
            (3,'TV 50', 3999.90, 0.290),
            (4,'TV 42', 2999.00, 0.200),
            (5,'Notebook A', 2499.90, 0.00350),
            (6,'Ventilador', 199.90, 0.496),
            (7,'Microondas A', 308.66, 0.0424),
            (8,'Microondas B', 429.90, 0.0544),
            (9,'Microondas C', 299.29, 0.0319),
            (10,'Refrigerador B', 849.00, 0.635),
            (11,'Refrigerador C', 1199.89, 0.870),
            (12,'Notebook B', 1999.90, 0.498),
            (13,'Notebook C', 3999.00, 0.527)]
espaco_disponivel = 3
def imprimir_solucao(solucao):
    for i in range(len(solucao)):
        if(solucao[i]==1):
            print('%s - %s' % (produtos[i][1], produtos[i][3]))
def fitness_function(solucao):
    custo = 0
    soma_espaco = 0
    for i in range(len(solucao)):
        if(solucao[i]==1):
            custo+=produtos[i][2]
            soma_espaco+=produtos[i][3]
        if(soma_espaco>espaco_disponivel):
            custo = 1
        
    return custo
import six
import sys
sys.modules['sklearn.externals.six'] = six
import mlrose
fitness = mlrose.CustomFitness(fitness_function)
problema = mlrose.DiscreteOpt(length = 14, fitness_fn = fitness, maximize = True, max_val = 2)

melhor_solucao, melhor_custo = mlrose.genetic_alg(problema, pop_size=500, mutation_prob=0.2)
print(melhor_solucao, melhor_custo)