from unicodedata import name
from django.urls import path     
from . import views
urlpatterns = [
    path('', views.root),
    path('shows', views.all_shows, name="all_shows"),
    path('shows/new', views.new_show, name='new_show'),
    path('shows/create', views.create_show),
    path('shows/<int:show_id>', views.show_info, name="show_info"),
    path('shows/<int:show_id>/edit', views.edit_form, name="edit"),
    path('shows/<int:show_id>/update', views.update_show),
    path('shows/<int:show_id>/destroy', views.delete_show, name="delete")
]