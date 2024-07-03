from flask import Flask, request, jsonify, make_response
from db import Store

store = Store()

app = Flask(__name__)


def cors_response(data):    
    response = make_response(jsonify(data))
    response.headers['Access-Control-Allow-Origin'] = "*"
    return response


@app.route('/api/insert', methods=['POST'])
def insert():
    data = request.json
    store.insert(data['user'], data['data'])
    return cors_response({
        'code': 200,
        'msg': 'success'
    })

@app.route('/api/get', methods=['POST'])
def get():
    data = request.json
    if 'page' not in data or 'perPage' not in data:
        return cors_response({
            'code': 400,
            'msg': 'page and perPage are required'
        }), 400
    
    page = data['page']
    perPage = data['perPage']
    res = store.get(page, perPage)

    return cors_response({
        'code': 200,
        'msg': 'success',
        'data': res
    })

app.run(host='0.0.0.0', port=3835)
