from config import *
from eletronico import Eletronico

class Roteador(Eletronico):

    def __init__(self, marca, voltagen):
        super().__init__(marca, voltagen)