from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/')
def submit_form():
    return render_template("dojo_survey.html")

@app.route('/result', methods=['POST'])
def result():
    print(request.form)
    name = request.form['name']
    age = request.form ['age']
    location= request.form['location']
    favlang = request.form.getlist('fav_lang')
    comment = request.form ['comment']
    return render_template("result.html", namehtml=name, agehtml=age, locationhtml=location, favlanghtml=favlang, commenthtml=comment)


if __name__ == "__main__":
    app.run(debug=True)