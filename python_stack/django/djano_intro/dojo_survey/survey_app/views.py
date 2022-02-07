from multiprocessing import context
from django.shortcuts import render, HttpResponse,redirect

def survey(request):
    return render(request, "survey.html")
def result(request):
    context = {
        "namehtml" : request.POST['name'],
        "agehtml" : request.POST['age'],
        "locationhtml" : request.POST['location'],
        "favlanghtml" : request.POST.getlist('fav_lang'),
        "commenthtml" : request.POST['comment']
    }
    return render(request, "result.html", context)