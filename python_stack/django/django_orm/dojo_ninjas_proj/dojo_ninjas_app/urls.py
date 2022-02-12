from django.urls import path     
from . import views
urlpatterns = [
    path('', views.get_result),
    path('dojo', views.create_dojo),
    path('ninja', views.create_ninja),
    path('delete', views.remove),
]