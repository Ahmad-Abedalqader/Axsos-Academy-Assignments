from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)

app.secret_key = '75892163' # set a secret key for security purposes


@app.route('/')
def count():
    if not "counter" in session:
        session['counter'] = 1
    else:
        session['counter'] += 1
    if not "visit" in session:
        session['visit'] = 1
    else:
        session['visit'] += 1
    return render_template("counter.html")

@app.route('/destroy_session')
def destroy():
    session.clear()
    return redirect("/")

@app.route('/add2')
def add2():
    session['counter']+=1
    return redirect("/")

@app.route('/specify', methods = ['POST'])
def specify():
    increment =request.form['inc']
    session['counter'] = session['counter'] + int (increment)-1
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)