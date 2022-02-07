from django.shortcuts import HttpResponse, redirect
from django.http import JsonResponse

def root(request):
    return redirect('/blogs')

def index(request):
    return HttpResponse("placeholder to later display a list of all blogs")

def new(request):
    return HttpResponse("placeholder to display a new form to create a new blog")

def create(request):
    return redirect('/')

def show(rquest, number):
    return HttpResponse("placeholder to display blog number:"+ number)

def edit(request, number):
    return HttpResponse("placeholder to edit blog: " + number)

def delete(request, number):
    return redirect('/blogs')

def json(request):
    return JsonResponse({"Title": "JSON response", "contents": "Here we go"})
