from multiprocessing import context
from django.shortcuts import HttpResponse, render, redirect
from .models import *
def show(request):
    users=User.objects.all()
    return render(request, "users.html", {"users": users})

def add(request):
    User.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],email_address=request.POST['Email'],age=request.POST['age'])
    return redirect('/')

def remove(request):
    d = User.objects.get(id=request.POST['user_id'])
    d.delete()
    return redirect('/')

