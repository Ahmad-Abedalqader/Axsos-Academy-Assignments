from flask import Flask
app = Flask(__name__)
#1-----------------
@app.route('/')          
def hello_world():
    return 'Hello World!!'
#2-----------------
@app.route('/dojo')
def dojo():
    return 'Dojo!'
#3------------------
@app.route('/say/<name>')
def say(name):
    return "hi " + name
#4-------------------
@app.route('/repeat/<int:num>/<word>')
def repeat(num, word):
    return f'{word} ' * num

#5 sensei bounus ----------
@app.errorhandler(404)
def sorry (e):
    return "Sorry! No response. Try again"


if __name__=="__main__":
    app.run(debug=True) 
