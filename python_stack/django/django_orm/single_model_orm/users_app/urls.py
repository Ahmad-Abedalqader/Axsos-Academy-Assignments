from django.urls import path     
from . import views
urlpatterns = [
    path('', views.show),
    path('add', views.add),
    path('delete', views.remove)
]