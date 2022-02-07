from django.urls import path     
from . import views
urlpatterns = [
    path('blogs/json', views.json), #we have to add this before the path of root: blogs/<number> to avoid considering json as value of the number variable
    path('', views.root),
    path('blogs', views.index),
    path('blogs/new', views.new),
    path('blogs/create', views.create),
    path('blogs/<number>', views.show),
    path('blogs/<number>/edit', views.edit),
    path('blogs/<number>/delete', views.delete),
    
]