from multiprocessing import context
from django.shortcuts import redirect, render
from login_app.models import *
from fav_books_app.models import *
from django.contrib import messages

def show_books(request):
    user_id = request.session['userid']
    context = {
        "user": User.objects.get(id = user_id),
        "books": Book.objects.all()
        }
    return render(request, "books.html", context)

# method should redirect to the root page and delete the session
# (so that the user can't access to the wall page anymore, unless he/she login again)
def logout(request):
    request.session.clear()
    return redirect("/")

def add_book(request):
    errors = Book.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/books')
    
    user_id = request.session['userid']
    this_user = User.objects.get(id = user_id)
    this_book = Book.objects.create(
                                    title = request.POST['title'],
                                    desc = request.POST['desc'],
                                    uploaded_by = this_user
                                    )
    this_user.liked_books.add(this_book)
    return redirect("/books")

def like(request):
    user_id = request.session['userid']
    book_id = request.POST.get('book_id', False)
    this_user = User.objects.get(id = user_id)
    this_book = Book.objects.get(id = book_id)
    this_user.liked_books.add(this_book)
    return redirect(f"/books/{book_id}")

def show_info(request, book_id):
    user_id = request.session['userid']
    this_user = User.objects.get(id = user_id)
    this_book = Book.objects.get(id = book_id)
    context={
            "user": this_user,
            "book": this_book
            }
    return render(request, "book_info.html", context)

def update(request):
    book_id = request.POST['book_id']
    errors = Book.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f"/books/{book_id}")

    this_book = Book.objects.get(id = book_id)
    this_book.title = request.POST['title']
    this_book.desc = request.POST['desc']
    this_book.save()
    return redirect(f"/books/{book_id}")

def delete(request):
    book_id = request.POST['book_id']
    this_book = Book.objects.get(id = book_id)
    this_book.delete()
    return redirect ("/books")

def unlike (request):
    book_id = request.POST['book_id']
    user_id = request.session['userid']
    this_user = User.objects.get(id = user_id)
    this_book = Book.objects.get(id = book_id)
    this_user.liked_books.remove(this_book)
    return redirect(f"/books/{book_id}")

def show_fav_books(request):
    user_id = request.session['userid']
    this_user = User.objects.get(id = user_id)
    fav_books = this_user.liked_books.all()
    context={
            "user": this_user,
            "fav_books": fav_books
            }
    return render(request, "fav_books.html", context)








