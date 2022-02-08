from django.shortcuts import render,  HttpResponse, redirect
import random
from time import localtime, strftime
def main(request):
    if not "gold" in request.session:
        request.session['gold'] = 0
    if not "activity" in request.session:
        request.session['activity'] = []
    print(request.session['activity'])
    return render(request,"ninja_gold.html")

def process(request):
    if request.POST['which'] == 'farm':
        x = random.randint(10, 20)
        request.session['gold'] += x
        request.session['activity'].append("Earned "+ str(x) + " golds from the farm! ("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
    elif request.POST['which'] == 'cave':
        x = random.randint(5, 10)
        request.session['gold'] += x
        request.session['activity'].append("Earned "+ str(x) + " golds from the cave! ("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
    elif request.POST['which'] == 'house':
        x = random.randint(2, 5)
        request.session['gold'] += x
        request.session['activity'].append("Earned "+ str(x) + " golds from the house! ("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
    elif request.POST['which'] == 'casino':
        x = random.randint(-50, 50)
        request.session['gold'] += x
        if x >= 0:
            request.session['activity'].append("Entered a casino and earned "+ str(abs(x)) + " golds ...yeah!...("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
        else:
            request.session['activity'].append("Entered a casino and lost "+ str(abs(x)) + " golds ...Ouch...("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
    return redirect("/")

# passing the location throught the URL
def process_url(request, loc):
    if loc == 'farm':
        x = random.randint(10, 20)
        request.session['gold'] += x
        request.session['activity'].append("Earned "+ str(x) + " golds from the farm! ("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
    elif loc == 'cave':
        x = random.randint(5, 10)
        request.session['gold'] += x
        request.session['activity'].append("Earned "+ str(x) + " golds from the cave! ("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
    elif loc == 'house':
        x = random.randint(2, 5)
        request.session['gold'] += x
        request.session['activity'].append("Earned "+ str(x) + " golds from the house! ("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
    elif loc == 'casino':
        x = random.randint(-50, 50)
        request.session['gold'] += x
        if x >= 0:
            request.session['activity'].append("Entered a casino and earned "+ str(abs(x)) + " golds ...yeah!...("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
        else:
            request.session['activity'].append("Entered a casino and lost "+ str(abs(x)) + " golds ...Ouch...("+ strftime("%b %d, %Y,  %H:%M", localtime())+")")
    return redirect("/")
