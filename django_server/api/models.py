from django.db import models

class Admin(models.Model):
    admin_id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    password = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'admin'


class Airline(models.Model):
    airline_id = models.AutoField(primary_key=True)
    departure_city = models.CharField(max_length=255)
    arrival_city = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'airline'

class Customer(models.Model):
    customer_id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    age = models.IntegerField()
    passport_number = models.CharField(max_length=255)
    phone_nr = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'customer'

class Plane(models.Model):
    plane_id = models.AutoField(primary_key=True)
    plane_name = models.CharField(max_length=255)
    first_class = models.IntegerField()
    coach = models.IntegerField()
    economy = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'plane'


class Schedule(models.Model):
    schedule_id = models.AutoField(primary_key=True)
    departure_date = models.DateField()
    departure_time = models.CharField(max_length=255)
    arrival_date = models.DateField()
    arrival_time = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'schedule'
