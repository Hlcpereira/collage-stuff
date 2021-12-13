from config import *
from ram import Ram
from hdd import Hdd

class Cpu(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    ram = relationship("Ram")
    hdd = relationship("Hdd")
    mobo = db.Column(db.String(50))
    proc = db.Column(db.String(50))

    def __init__(self, ram, hdd, mobo, proc):
        self.ram = ram
        self.hdd = hdd
        self.mobo = mobo
        self.proc = proc

    __tablename__ == "cpu"

    def __str__(self):
        return str(self.id)+") "+ self.hdd.marca + ", " +\
            self.ram.marca + ", " self.mobo  + ", " self.proc

    def json(self):
        return {
            "id": self.id,
            "hdd": self.hdd,
            "ram": self.ram,
            "mobo": self.mobo,
            "proc": self.proc
        }
