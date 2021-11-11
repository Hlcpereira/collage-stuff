from config import *

class Eletronico(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    marca = db.Column(db.String(254))
    voltagen = db.Column(db.String(254))
    type = db.Column(db.String(50))

    def __init__(self, marca, voltagen):
        self.marca = marca
        self.voltagen = voltagen

    __mapper_args__ = { 
        "polymorphic_identity":"eletronico", 
        "polymorphic_on":type
    }

    def __str__(self):
        return str(self.id)+") "+ self.marca + ", " +\
            self.voltagen

    def json(self):
        return {
            "id": self.id,
            "marca": self.marca,
            "voltagen": self.voltagen
        }
