from flask import Flask, jsonify
app = Flask(__name__)

@app.route("/")
def arquivo():
    arq = open('D:\AndroidStudioProjects/SmartCampus/app/SmartCampusServidorarquivos/teste1.txt', 'r')
    texto = arq.readlines()
    for linha in texto:
        print(linha)
    arq.close()
    return linha



@app.route('/arcondicionado/ligado=<string:ligado>&tempo=<string:tempo>&auto=<string:auto>', methods=['GET'])
def arCondicionado(ligado, tempo, auto):
        arq = open('D:\AndroidStudioProjects/SmartCampus/app/SmartCampusServidor/arquivos/tempo.txt', 'w')
        arq.write(ligado+"|"+tempo+"|"+auto)
        arq.close()
        return jsonify({'response': 'OK'})

@app.route('/projetorPersiana/projetor=<string:ligadoProjetor>&persiana=<string:ligadoPersiana>', methods=['GET'])
def projetoPersiana(ligadoProjetor, ligadoPersiana):
        arq = open('D:\AndroidStudioProjects/SmartCampus/app/SmartCampusServidor/arquivos/proPer.txt', 'w')
        arq.write(ligadoProjetor+"|"+ligadoPersiana)
        arq.close()
        return jsonify({'response': 'OK'})

@app.route('/lixeira/')
def lixeira():
        arq = open('D:\AndroidStudioProjects/SmartCampus/app/SmartCampusServidor/arquivos/capacidadeDaLixeira.txt', 'r')
        capacidadeDaLixeira = arq.readlines()
        resp = ""
        for porcentagem in capacidadeDaLixeira:

            resp = porcentagem
        arq.close()
        return jsonify({'response':resp})


if __name__ == '__main__':
    app.run(debug=True,  host='192.168.0.103')