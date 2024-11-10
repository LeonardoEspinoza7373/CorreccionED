from flask import Flask, request, render_template, jsonify

app = Flask(__name__)

# Lista de palabras 
palabras_validas = {"html", "head", "body", "input", "select"}

# Validacion
def validar_palabra(palabra):
   
    if palabra.lower() in palabras_validas:
        return True
    return False

# Ruta principal con formulario para ingresar la palabra
@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        palabra = request.form.get('palabra')
        if validar_palabra(palabra):
            mensaje = f"La palabra '{palabra}' es válida."
        else:
            mensaje = f"La palabra '{palabra}' no es válida. Debe ser una de las siguientes: {', '.join(palabras_validas)}."
        return render_template('index.html', mensaje=mensaje)
    return render_template('index.html')

# Ruta con peticiones AJAX)
@app.route('/validar', methods=['POST'])
def validar():
    data = request.get_json()
    palabra = data.get('palabra')
    es_valida = validar_palabra(palabra)
    return jsonify({'valida': es_valida})

if __name__ == '__main__':
    app.run(debug=True)
