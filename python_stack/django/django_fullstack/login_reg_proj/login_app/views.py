from multiprocessing import context
from django.shortcuts import render, redirect, HttpResponse
from login_app.models import *
from django.contrib import messages
import bcrypt


# Method should return and render both login and registration form (the root page)
def show_forms(request):
    return render (request, "forms.html")

# Method to check all validators, then rigister the user by creating an object to in the
# database and then redirect to the success page or to the root page if there is errors
def register(request):
    errors = User.objects.basic_validator(request.POST)
    request.session["error_from"] = "register"
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    
    if request.POST['confirm_pw'] == request.POST['password']:
        password = request.POST['password']
        pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()

        user = User.objects.create(
            first_name = request.POST['first_name'],
            last_name = request.POST['last_name'],
            email = request.POST['email'],
            password = pw_hash,
        )
        request.session['userid'] = user.id
        return redirect("/success")
    else:
        return redirect("/")

# Method to check the login validators, then redirect to the success page if the is no errors,
# or to the root if there is some errors
def login(request):
    errors = User.objects.login_val(request.POST)
    request.session["error_from"] = "login"
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
        
    user = User.objects.filter(email = request.POST['email'])
    if user:
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['password'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            return redirect("/success")
        else:
            messages.error(request, "invalid email or password")
    else:
        messages.error(request, "invalid email or password")

    return redirect("/")

# Method to render the success page after success register or login 
def success(request):
    if "userid" in request.session:
        user_id = request.session['userid']
        context={
                "user": User.objects.get(id = user_id)
                }
        return render(request, "success.html", context)
    return redirect("/")

# method should redirect to the root page and delete the session
# (so that the user can't access to the success page anymore, unless he/she login again)
def logout(request):
    request.session.clear()
    return redirect("/")

