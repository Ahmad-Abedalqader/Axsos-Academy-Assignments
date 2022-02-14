from django.shortcuts import render, redirect
from TV_shows_app.models import *

# method should make the root route redirect to /shows
def root(request):
    return redirect('/shows')

# This method return a template containing the form for adding a new TV show
def new_show(request):
    return render(request, "show_form.html")

# method return a template that displays a form for editing the TV show with the id specified in the url
def all_shows(request):
    context={
            "shows": Show.objects.all()
            }
    return render(request, "all_shows.html", context)

# method should add the show to the database, then redirect to /shows/<id>
def create_show(request):
    show = Show.objects.create(
                                title = request.POST['title'],
                                network = request.POST['network'],
                                release_date = request.POST['rel_date'],
                                description = request.POST['desc']
                                )
    return redirect(f"/shows/{show.id}")

# method should return a template that displays the specific show's information
def show_info(request, show_id):
    context={
            "show": Show.objects.get(id = show_id)
    }
    return render(request, "show_info.html",context)

# method should render the form of a specific Tv show to edit
def edit_form(request, show_id):
    context={
            "show": Show.objects.get(id = show_id)
            }
    return render(request, "edit.html", context)


#  method should update the specific show in the database, then redirect to /shows/<id>
def update_show(request, show_id):
    this_show= Show.objects.get(id = show_id)
    this_show.title = request.POST['title']
    this_show.network = request.POST['network']
    this_show.release_date = request.POST['rel_date']
    this_show.description = request.POST['desc']
    this_show.save()
    return redirect (f"/shows/{this_show.id}")

# method should delete the show with the specified id from the database, then redirect to /shows
def delete_show(request, show_id):
    this_show = Show.objects.get(id = show_id)
    this_show.delete()
    return redirect('/shows')

