from django.urls import path     
from . import views

urlpatterns = [
    path('', views.show_books),
    path('authors', views.show_authors),
    path('books/<id_from_anchor>', views.view_book, name='books_view'),
    path('authors/<id_from_anchor>', views.view_author, name='authors_view'),
    path('add_book', views.add_book),
    path('add_author', views.add_author),
    path('sel_book/<author_id>', views.sel_book),
    path('sel_author/<book_id>', views.sel_author),
]
