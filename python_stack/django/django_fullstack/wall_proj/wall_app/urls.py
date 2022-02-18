from django.urls import path     
from . import views
urlpatterns = [
    path('', views.show_wall),
    path('logout/', views.logout),
    path('post/', views.post),
    path('comment/', views.comment),
    path('del_comment/', views.del_comment),
    path('del_post/', views.del_post)
]