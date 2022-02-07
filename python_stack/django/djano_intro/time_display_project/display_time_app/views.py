from django.shortcuts import render, HttpResponse
from time import localtime, strftime
from django.utils import timezone
    
def display_time(request):
    context = {
        "time": strftime("%b %d, %Y,  %H:%M", localtime()),
        "now":timezone.now()
    }
    
    return render(request,'time.html', context)

