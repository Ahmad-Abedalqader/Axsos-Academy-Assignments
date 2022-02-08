from django.urls import path     
from . import views
urlpatterns = [
    path('', views.main),
    path('process_money', views.process),
    path('<loc>', views.process_url),
]