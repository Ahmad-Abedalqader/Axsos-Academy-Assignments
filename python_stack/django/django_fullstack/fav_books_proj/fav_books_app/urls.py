from turtle import update
from django.urls import path     
from . import views

urlpatterns = [
    path('', views.show_books),
    path('logout/', views.logout),
    path('add_book', views.add_book),
    path('like', views.like),
    path('<int:book_id>', views.show_info),
    path('update', views.update),
    path('unlike', views.unlike),
    path('delete', views.delete),
    path('fav_books', views.show_fav_books),
]
