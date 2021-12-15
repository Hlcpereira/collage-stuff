from config import *

class Ram(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    marca = db.Column(db.String(50))
    capac = db.Column(db.String(50))
    gen = db.Column(db.String(50))
    cpu_id = db.Column(db.Integer, db.ForeignKey('cpu.id'))
    cpu = db.relationship("Cpu")

    def __init__(self, marca, capac, gen, cpu_id):
        self.marca = marca
        self.capac = capac
        self.gen = gen
        self.cpu_id = cpu_id

    __table_args__ = {'extend_existing': True}

    def __str__(self):
        return str(self.id)+") "+ self.marca + ", " +\
            self.capac + ", " + self.gen  + ", " +\
            self.cpu_id

    def json(self):
        return {
            "id": self.id,
            "marca": self.marca,
            "capac": self.capac,
            "gen": self.gen,
            "cpu_id": self.cpu_id,
            "cpu": self.cpu.json()
        }
