# importações
from flask import Flask, jsonify, request
from flask_api import status
from flask_sqlalchemy import SQLAlchemy
import os
from flask_cors import CORS # permitir back receber json do front

import sys
import names
import random

# flask
app = Flask(__name__)
CORS(app) # aplicar o cross domain
# sqlalchemy com sqlite
path = os.path.dirname(os.path.abspath(__file__)) # sugestao do Kaue

arquivobd = os.path.join(path, 'aplicacao.db')
app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///"+arquivobd
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False # remover warnings
db = SQLAlchemy(app)