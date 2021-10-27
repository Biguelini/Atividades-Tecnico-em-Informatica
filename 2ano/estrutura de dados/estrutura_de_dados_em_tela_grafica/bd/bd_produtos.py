class BdProdutos:
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
    def insere(self, object):
        self.produtos.append((object.id, object.nome, object.preco, object.volume))
        
    def remove(self):
        if len(self.produtos) != 0:
            self.produtos = self.produtos[1:]

    def pesquisa(self):
        return self.produtos