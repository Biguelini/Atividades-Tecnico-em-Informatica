class Caminhao():
    def __init__(self, volume):
        self.volume = volume
         
    @property
    def volume(self):
         return self._volume
    @volume.setter
    def volume(self, value):
         self._volume = value