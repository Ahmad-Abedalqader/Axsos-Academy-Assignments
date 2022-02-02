from os import times
from flask import Flask, render_template
app = Flask(__name__)
# level 1 ---------------------------------------
@app.route('/play')          
def play1():
    return render_template('playground1.html')
# level 2 ---------------------------------------
@app.route('/play/<int:times>')          
def play2(times):
    return render_template('playground2.html', num_times = times)
# level 3-----------------------------------------
@app.route('/play/<int:times>/<color>')          
def play3(times,color):
    return render_template('playground3.html', num_times = times, some_color = color)

if __name__=="__main__":
    app.run(debug=True) 
