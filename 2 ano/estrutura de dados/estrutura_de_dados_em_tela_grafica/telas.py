from PyQt5 import uic, QtWidgets
from bd.bd_produtos import BdProdutos
from vo.produto import  Produto
from vo.caminhao import Caminhao
import six
import sys
sys.modules['sklearn.externals.six'] = six
import mlrose

class Telas:
    def rodar():
        bd = BdProdutos()
        c = Caminhao(3)
        app = QtWidgets.QApplication([])
        main = uic.loadUi("telas/inicio.ui")
        cadastro = uic.loadUi("telas/cadastro.ui")
        listagem = uic.loadUi("telas/listagem.ui")
            
        def isNumber(n):
            try:
                float(n)
            except ValueError:
                    return False
            return True

        def mostrar_tela_cadastro():
            cadastro.show()

        def deletar_produto():
            bd.remove()
            print(bd.pesquisa())

        def listar():
            listagem.show()
            listagem.dadostabela.setRowCount(len(bd.produtos))
            listagem.dadostabela.setColumnCount(4)
            for i in range(0, len(bd.produtos)):
                for j in range(0, 4):
                    listagem.dadostabela.setItem(
                        i, j, QtWidgets.QTableWidgetItem(str(bd.produtos[i][j])))

        def cadastrar():
            existe = False
            id = len(bd.produtos)
            nome = cadastro.tnome.text()
            preco = cadastro.tpreco.text()
            volume = cadastro.tvolume.text()
            for i in range(0, len(bd.produtos)):
                if(bd.produtos[i][1] == nome):
                    existe = True
            if (not(existe) and nome!="" and preco!="" and volume!= "" and isNumber(preco) and isNumber(volume)):
                p1 = Produto(id, nome, preco, volume)
                bd.insere(p1)
                print(bd.pesquisa())
                cadastro.tnome.setText("")
                cadastro.tpreco.setText("")
                cadastro.tvolume.setText("")

        def calcular():    
            def imprimir_solucao(solucao):
                for i in range(len(solucao)):
                    if(solucao[i]==1):
                        print('%s - %s' % (bd.produtos[i][1], bd.produtos[i][3]))
            def fitness_function(solucao):
                custo = 0
                soma_espaco = 0
                for i in range(len(solucao)):
                    if(solucao[i]==1):
                        custo+=float(bd.produtos[i][2])
                        soma_espaco+=float(bd.produtos[i][3])
                    if(soma_espaco>float(c.volume)):
                        custo = 1
                    
                return custo
            fitness = mlrose.CustomFitness(fitness_function)
            problema = mlrose.DiscreteOpt(length = 14, fitness_fn = fitness, maximize = True, max_val = 2)
            
            melhor_solucao, melhor_custo = mlrose.genetic_alg(problema, pop_size=500, mutation_prob=0.2)
            print(melhor_solucao, melhor_custo)
            imprimir_solucao(melhor_solucao)


        main.inserirbtn.clicked.connect(mostrar_tela_cadastro)
        main.deletarbtn.clicked.connect(deletar_produto)
        main.listarbtn.clicked.connect(listar)
        cadastro.cadastrobtn.clicked.connect(cadastrar)
        main.calcularbtn.clicked.connect(calcular)

        main.show()
        app.exec()