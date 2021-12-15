from config import *
from entities.cpu import Cpu

class Hdd(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    ssd = db.Column(db.Boolean)
    capac = db.Column(db.String(50))
    velocidade = db.Column(db.String(50))
    cpu_id = db.Column(db.Integer, db.ForeignKey('cpu.id'))
    cpu = db.relationship("Cpu")

    def __init__(self, ssd, capac, velocidade, cpu_id):
        self.ssd = ssd
        self.capac = capac
        self.velocidade = velocidade
        self.cpu_id = cpu_id

    __table_args__ = {'extend_existing': True}

    def __str__(self):
        return str(self.id)+") "+ self.ssd + ", " +\
            self.capac + ", " + self.velocidade  +\
            ", " + self.cpu_id

    def json(self):
        return {
            "id": self.id,
            "ssd": self.ssd,
            "capac": self.capac,
            "velocidade": self.velocidade,
            "cpu_id": self.cpu_id,
            "cpu": self.cpu.json()
        }
