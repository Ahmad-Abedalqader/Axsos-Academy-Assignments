from django.db import models
import re

class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
    #First name and last name validations
        if len(postData['first_name']) < 2:
            errors["first_name"] = "First name should be at least 2 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "Last name should be at least 2 characters"
    #Email validations
        user = User.objects.filter(email = postData['email'])
        if user:
            errors['email'] = "Email already exists"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):            
            errors['email'] = "Invalid email address!"
    # Password validations
        if len(postData['password']) == 0:
            errors["password"] = "Password is required!"
        elif len(postData['password']) < 8:
            errors["password"] = "Password should be at least 8 characters"
        if postData['confirm_pw'] != postData['password']:
            errors['confirm_pw'] = "password doesn't match the confirmed PW"
        
        return errors
        
    def login_val(self,postData):
        errors = {}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):            
            errors['email'] = "Invalid email address!"
        
        if len(postData['password']) == 0:
            errors["password"] = "Password is required!"
        
        
        
        return errors


class User(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()
    
    # liked_books = a list of books a given user likes
    # books_uploaded = a list of books uploaded by a given user

