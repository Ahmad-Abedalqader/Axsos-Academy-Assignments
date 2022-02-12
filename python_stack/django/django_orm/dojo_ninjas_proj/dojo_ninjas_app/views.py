from unicodedata import name
from django.shortcuts import render, redirect, HttpResponse
from dojo_ninjas_app.models import *

def get_result(request):
    context = {
        "dojos": Dojo.objects.all(),
        "count": 0
    }
    return render(request, "dojo_ninjas.html", context)

def create_dojo(request):
    Dojo.objects.create(name=request.POST['name'],city=request.POST['city'],state=request.POST['state'])
    return redirect('/')

def create_ninja(request):
    Ninja.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'], dojo = Dojo.objects.get(id = request.POST['dojo_from_selsct']))
    return redirect('/')

def remove(request):
    dojo_to_delete = Dojo.objects.get(id=request.POST['del_dojo'])
    dojo_to_delete.delete()
    return redirect('/')
