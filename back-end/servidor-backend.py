from config import *
from entities.assistant import Assistant
from entities.celular import Celular
from entities.eletronico import Eletronico
from entities.geladeira import Geladeira
from entities.manutencao import Manutencao
from entities.op_sys import Op_Sys
from entities.roteador import Roteador
from entities.tecnico import Tecnico
from entities.televisao import Televisao

@app.route("/")
def inicio():
    return " "

@app.route("/listar/<string:classe>")
def listar(classe):
    try:
        classe = getattr(sys.modules[__name__], classe)
        lista = db.session.query(classe).all()
        json = [ x.json() for x in lista ]
        dados = jsonify(json)
        dados.headers.add("Access-Control-Allow-Origin", "*")
        return dados
    except:
        return "Bad request", status.HTTP_400_BAD_REQUEST

@app.route("/incluir/<string:classe>", methods=['post'])
def incluir(classe):
    try:
        classe = getattr(sys.modules[__name__], classe)
        resposta = jsonify({"resultado": "ok", "detalhes": "ok"})
        dados = request.get_json()
        try:
            nova = classe(**dados)
            db.session.add(nova)
            db.session.commit()
        except Exception as e:
            resposta = jsonify({"resultado":"erro", "detalhes":str(e)})

        resposta.headers.add("Access-Control-Allow-Origin", "*")
        return resposta 
    except:
        return "Bad request", status.HTTP_400_BAD_REQUEST

app.run(debug=True)
