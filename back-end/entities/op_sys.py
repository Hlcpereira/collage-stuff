from config import *

class Op_Sys:
    id = db.Column(db.Integer, primary_key=True)
    type = db.Column(db.String(254))
    versao = db.Column(db.String(254))
    fornecedora = db.Column(db.String(254))

    def __init__(self, type, versao, fornecedora):
        self.type = type
        self.versao = versao
        self.fornecedora = fornecedora

    def __str__(self):
        return str(self.id)+") "+ self.type + ", " +\
            self.versao + ", " + self.fornecedora

    def json(self):
        return {
            "id": self.id,
            "type": self.type,
            "versao": self.versao,
            "fornecedora": self.fornecedora
        }
