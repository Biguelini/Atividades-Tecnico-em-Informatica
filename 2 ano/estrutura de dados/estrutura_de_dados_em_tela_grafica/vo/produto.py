class Produto:
    def __init__(self, nome, preco, volume):
        self.nome = nome
        self.preco = preco
        self.volume = volume

    @property
    def nome(self):
         return self._nome
    @nome.setter
    def nome(self, value):
         self._nome = value

    @property
    def preco(self):
         return self._preco
    @preco.setter
    def preco(self, value):
         self._preco = value

    @property
    def volume(self):
         return self._volume
    @volume.setter
    def volume(self, value):
         self._volume = value