from config import *
from eletronico import Eletronico

class Assistant(Eletronico):

    def __init__(self, marca, voltagen):
        super().__init__(marca, voltagen)
