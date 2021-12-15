from config import *
#from entities.ram import Ram
#from entities.hdd import Hdd

class Cpu(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    mobo = db.Column(db.String(50))
    proc = db.Column(db.String(50))

    def __init__(self, mobo, proc):
        self.mobo = mobo
        self.proc = proc

    def __str__(self):
        return str(self.id) + ") " + self.mobo + ", " + self.proc

    def json(self):
        return {
            "id": self.id,
            "mobo": self.mobo,
            "proc": self.proc
        }
