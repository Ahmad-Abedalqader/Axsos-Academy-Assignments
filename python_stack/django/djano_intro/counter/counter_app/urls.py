from django.urls import path     
from . import views
urlpatterns = [
    path('', views.count),
    path('destroy_session', views.destroy),
    path('add2', views.add2),
    path('specify', views.specify),
]