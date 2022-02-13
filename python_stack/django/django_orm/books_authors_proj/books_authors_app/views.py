from django.shortcuts import render, redirect
from books_authors_app.models import *

def show_books(request):
    context={
            "books": Book.objects.all()
            }
    return render (request, "books.html", context)

def show_authors(request):
    context={
            "authors": Author.objects.all()
            }
    return render (request, "authors.html",context)

def view_book(request,id_from_anchor):
    context={
            "book": Book.objects.get(id=id_from_anchor),
            "all_authors": Author.objects.exclude(books__in = id_from_anchor)
            }
    return render(request, "book_details.html", context)

def view_author(request,id_from_anchor):
    context={
            "author": Author.objects.get(id=id_from_anchor),
            "all_books": Book.objects.exclude(authors__in = id_from_anchor)
            }
    return render(request, "author_details.html", context)

def add_book(request):
    Book.objects.create(title = request.POST['title'], desc = request.POST['desc'])
    return redirect('/')

def add_author(request):
    Author.objects.create(first_name = request.POST['first_name'], last_name = request.POST['last_name'], notes = request.POST['notes'])
    return redirect('/authors')

def sel_book(request, author_id):
    b = Book.objects.get(id = request.POST['book_select'])
    a = Author.objects.get(id = author_id)
    b.authors.add(a)
    return redirect('/authors')
    

def sel_author(request, book_id):
    b = Book.objects.get(id = book_id)
    a = Author.objects.get(id = request.POST['author_select'])
    b.authors.add(a)
    return redirect('/')
