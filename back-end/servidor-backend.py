from config import *
from modelo import Pessoa

@app.route("/")
def inicio():
    return " "

@app.route("/listar/<string:classe>")
def listar(classe):
    try:
        classe = getattr(sys.modules[__name__], classe)
        lista = db.session.query(classe).all()
        json = [ x.json() for x in lista ]
        pessoas = jsonify(json)
        pessoas.headers.add("Access-Control-Allow-Origin", "*")
        return pessoas
    except:
        return "Something bad happened"

@app.route("/incluir/Pessoa", methods=['post'])
def incluir_pessoa():
    try:
        resposta = jsonify({"resultado": "ok", "detalhes": "ok"})
        dados = request.get_json()
        try:
            nova = Pessoa(**dados)
            db.session.add(nova)
            db.session.commit()
        except Exception as e:
            resposta = jsonify({"resultado":"erro", "detalhes":str(e)})

        resposta.headers.add("Access-Control-Allow-Origin", "*")
        return resposta 
    except:
        return "Something bad happened"

app.run(debug=True)
