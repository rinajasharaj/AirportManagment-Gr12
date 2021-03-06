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

class Flight(models.Model):
    flight_id = models.AutoField(primary_key=True)
    plane_id1 = models.ForeignKey('Plane', models.DO_NOTHING, db_column='plane_id1')
    airline_id1 = models.ForeignKey(Airline, models.DO_NOTHING, db_column='airline_id1')
    schedule_id1 = models.ForeignKey('Schedule', models.DO_NOTHING, db_column='schedule_id1')
    price = models.FloatField()

    class Meta:
        managed = False
        db_table = 'flight'

class Booking(models.Model):
    booking_id = models.AutoField(primary_key=True)
    customer_id1 = models.ForeignKey('Customer', models.DO_NOTHING, db_column='customer_id1')
    flight_id1 = models.ForeignKey('Flight', models.DO_NOTHING, db_column='flight_id1')
    class_field = models.CharField(db_column='class', max_length=255)  # Field renamed because it was a Python reserved word.

    class Meta:
        managed = False
        db_table = 'booking'
