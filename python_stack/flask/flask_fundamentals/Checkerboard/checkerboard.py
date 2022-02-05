from turtle import color
from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')          
def checker():
    return render_template('checkerboard.html', rows = 8, columns=8, color1 = "white", color2="black")

@app.route('/<int:x>')    
def row(x):
    return render_template('checkerboard.html', rows = x, columns=8, color1 = "white", color2="black")

@app.route('/<int:x>/<int:y>')    
def row_column(x,y):
    return render_template('checkerboard.html', rows = x, columns=y, color1 = "white", color2="black")

@app.route('/<int:x>/<int:y>/<color1>/<color2>')    
def color(x,y,color1,color2):
    return render_template('checkerboard.html', rows = x, columns=y, color1 = color1, color2=color2)

if __name__=="__main__":
    app.run(debug=True) 