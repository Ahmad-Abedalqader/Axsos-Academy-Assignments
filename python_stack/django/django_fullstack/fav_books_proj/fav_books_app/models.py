from django.db import models
from login_app.models import *


class BookManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
    # Title Validation
        if len(postData['title']) == 0:
            errors["title"] = "Title is required!"
    # Description validation
        if len(postData['desc']) < 5:
            errors["desc"] = "description should be at least 5 characters"
        return errors


class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField(null = True)
    uploaded_by = models.ForeignKey(User, related_name="books_uploaded", on_delete = models.CASCADE)
    liked_by = models.ManyToManyField(User, related_name="liked_books")
    objects = BookManager()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

