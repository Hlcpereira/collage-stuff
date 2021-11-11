from config import *
from eletronico import Eletronico

class Televisao(Eletronico):

    def __init__(self, marca, voltagen):
        super().__init__(marca, voltagen)
