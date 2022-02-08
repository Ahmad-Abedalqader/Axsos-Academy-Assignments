from django.shortcuts import render, redirect

def count(request):
    if not "counter" in request.session:
        request.session['counter'] = 1
    else:
        request.session['counter'] += 1
    if not "visit" in request.session:
        request.session['visit'] = 1
    else:
        request.session['visit'] += 1
    return render(request, "counter.html")

def destroy(request):
    del request.session['counter']
    del request.session['visit']
    return redirect("/")

def add2(request):
    request.session['counter']+=2
    return render(request, "counter.html")

def specify(request):
    increment =request.POST['inc']
    request.session['counter'] = request.session['counter'] + int (increment)
    return render(request, "counter.html")


