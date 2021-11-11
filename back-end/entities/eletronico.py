from config import *

class Eletronico(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    marca = db.Column(db.String(254))
    voltagen = db.Column(db.String(254))

    def __init__(self, marca, voltagen):
        self.marca = marca
        self.voltagen = voltagen

    def __str__(self):
        return str(self.id)+") "+ self.marca + ", " +\
            self.voltagen

    def json(self):
        return {
            "id": self.id,
            "marca": self.marca,
            "voltagen": self.voltagen
        }
