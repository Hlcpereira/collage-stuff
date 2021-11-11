from config import *
from eletronico import Eletronico

class Geladeira(Eletronico):
    id = db.Column(db.Integer, db.ForeignKey("eletronico.id"), primary_key=True) 

    def __init__(self, marca, voltagen):
        super().__init__(marca, voltagen)

    __mapper_args__ = { 
        "polymorphic_identity":"geladeira", 
    } 
