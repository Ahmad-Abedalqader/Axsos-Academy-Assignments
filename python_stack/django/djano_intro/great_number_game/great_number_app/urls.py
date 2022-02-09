from django.urls import path     
from . import views
urlpatterns = [
    path('', views.rand),
    path('guessed', views.guess),
    path('result', views.result),
    path('winners', views.win),
    path('reset', views.reset),
    # path('leaderboard', views.lead),
]