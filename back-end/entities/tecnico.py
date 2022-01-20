from config import *

class Tecnico(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(254))
    email = db.Column(db.String(254))
    telefone = db.Column(db.String(254))

    def __str__(self):
        return str(self.id)+") "+ self.nome + ", " +\
            self.email + ", " + self.telefone

    def json(self):
        return {
            "id": self.id,
            "nome": self.nome,
            "email": self.email,
            "telefone": self.telefone
        }
   
if __name__ == "__main__":
    if os.path.exists(arquivobd):
        os.remove(arquivobd)

    db.create_all()

    p1 = Tecnico(nome = "João da Silva", email = "josilva@gmail.com", 
        telefone = "47 99012 3232")
    p2 = Tecnico(nome = "Maria Oliveira", email = "molive@gmail.com", 
        telefone = "47 98822 2531")        

    db.session.add(p1)
    db.session.add(p2)
    db.session.commit()

    print(p2)
    print(p2.json())
