from django.shortcuts import HttpResponse, render, redirect
import random
def rand(request):
    if not 'random_number' in request.session:
        request.session['random_number'] = random.randint(1, 100)
    print(request.session['winner'])
    print(request.session['random_number'])
    return render (request, "game.html")

def guess(request):
    request.session['guessed_number'] = int(request.POST['number'])
    if not "counter" in request.session:
        request.session['counter'] = 1
    else:
        request.session['counter'] += 1
    print(request.session['random_number'])
    print (request.session['guessed_number'])
    print(request.session['counter'])
    return redirect ('/result')

def result(request):
    print(request.session['random_number'])
    print (request.session['guessed_number'])
    print(request.session['counter'])
    print(request.session['winner'])
    return redirect('/')

def reset(request):
    del request.session['random_number']
    del request.session['counter']
    del request.session['guessed_number']
    return redirect("/")

def win(request):
    x = request.POST['win']
    request.session['winner'].append(x)
    print(request.session['winner'])
    return render(request, "leaderboard.html")
    # return redirect("/leaderboard")

# def lead(request):
#     return render(request, "leaderboard.html")



