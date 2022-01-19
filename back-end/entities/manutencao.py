from config import *

class Manutencao:
    id = db.Column(db.Integer, primary_key=True)
    op_sys_id = db.Column(db.Integer, db.ForeignKey('op_sys.id'))
    op_sys = db.relationship("Op_Sys")
    eletronico_id = db.Column(db.Integer, db.ForeignKey('eletronico.id'))
    eletronico = db.relationship("Eletronico")
    tecnico_id = db.Column(db.Integer, db.ForeignKey('tecnico.id'))
    tecnico = db.relationship("Tecnico")

    def __init__(self, op_sys_id, eletronico_id, tecnico_id):
        self.op_sys_id = op_sys_id
        self.eletronico_id = eletronico_id
        self.tecnico_id = tecnico_id

    __table_args__ = {'extend_existing': True}

    def __str__(self):
        return str(self.id)+") "+ self.op_sys_id + ", " +\
            self.eletronico_id + ", " + self.tecnico_id

    def json(self):
        return {
            "id": self.id,
            "op_sys_id": self.op_sys_id,
            "op_sys": self.op_sys.json(),
            "eletronico_id": self.eletronico_id,
            "eletronico": self.eletronico.json(),
            "tecnico_id": self.tecnico_id,
            "tecnico": self.tecnico.json()
        }
