import datetime
from django.db import models

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        print("*"*40)
        print (postData)
        errors = {}
        if len(postData['title']) < 2:
            errors["title"] = "Show title should be at least 2 characters"

        if len(postData['network']) < 3:
            errors["network"] = "Show title should be at least 3 characters"

        if len(postData['desc']) < 10:
            errors["desc"] = "Show description should be at least 10 characters"

        if datetime.datetime.strptime(postData['rel_date'], "%Y-%m-%d").date() > datetime.date.today():
            errors["date"] = "The date must be in the past!"

        return errors

class Show(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=100)
    release_date = models.DateField()
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()