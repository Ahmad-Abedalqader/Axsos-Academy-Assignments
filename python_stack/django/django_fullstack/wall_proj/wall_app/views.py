from django.shortcuts import render, redirect
from login_app.models import *
from datetime import datetime, date
from time import strftime, localtime

# Method to render the wall page after success register or login 
def show_wall(request):
    if "userid" in request.session:
        user_id = request.session['userid']
        context = {
            "user": User.objects.get(id = user_id),
            "messages" : Message.objects.all().order_by("-created_at")
            
        }
        return render(request, "wall.html", context)
    return redirect("/")

# method should redirect to the root page and delete the session
# (so that the user can't access to the wall page anymore, unless he/she login again)
def logout(request):
    request.session.clear()
    return redirect("/")

# Method to create a message object by a specific user object in the database then,
# redirect to the wall page where all messages are shown up
def post(request):
    user_id = request.session['userid']
    Message.objects.create( message = request.POST["message"],
                            user = User.objects.get(id = user_id)
                        )
    return redirect ("/wall")

# Method to create a comment object for a specific message object by a 
# specific user object in the database then,
# redirect to the wall page where all messages and comments are shown up
def comment(request):
    message_id = request.POST['message_id']
    user_id = request.session["userid"]
    Comment.objects.create( comment = request.POST["comment"],
                            user = User.objects.get(id = user_id),
                            message = Message.objects.get(id = message_id)
                        )
    return redirect ("/wall")

def del_comment(request):
    comment_id = request.POST['comment_id']
    this_comment = Comment.objects.get(id = comment_id)
    this_comment.delete()
    return redirect ("/wall")

def del_post(request):
    message_id = request.POST['message_id']
    this_message = Message.objects.get(id = message_id)
    message_time = this_message.created_at.time()
    now = datetime.utcnow().time()
    diff = datetime.combine(date.min, now) - datetime.combine(date.min, message_time)
    diff_min = diff.seconds/60
    print(diff_min)
    if diff_min <= 30:
        this_message.delete()
    return redirect ("/wall")



