from dataclasses import fields
from rest_framework import serializers
from api.models import Admin,Airline,Plane,Customer,Schedule,Flight,Booking

class AdminSerializer(serializers.ModelSerializer):
    first_name = serializers.CharField(max_length=255)
    last_name = serializers.CharField(max_length=255)
    password = serializers.CharField(max_length=255)

    class Meta:
      model=Admin
      fields=['admin_id','first_name','last_name','password']

class AirlineSerializer(serializers.ModelSerializer):
    departure_city = serializers.CharField(max_length=255)
    arrival_city = serializers.CharField(max_length=255)

    class Meta:
      model=Airline
      fields=['airline_id','departure_city','arrival_city']

class CustomerSerializer(serializers.ModelSerializer):
    first_name = serializers.CharField(max_length=255)
    last_name = serializers.CharField(max_length=255)
    age = serializers.IntegerField()
    passport_number = serializers.CharField(max_length=255)
    phone_nr = serializers.CharField(max_length=255)

    class Meta:
      model=Customer
      fields=['customer_id','first_name','last_name','age','passport_number','phone_nr']

class PlaneSerializer(serializers.ModelSerializer):
    plane_name = serializers.CharField(max_length=255)
    first_class = serializers.IntegerField()
    coach = serializers.IntegerField()
    economy = serializers.IntegerField()

    class Meta:
      model=Plane
      fields=['plane_id','plane_name','first_class','coach','economy']

class ScheduleSerializer(serializers.ModelSerializer):
    departure_date = serializers.DateField()
    departure_time = serializers.CharField(max_length=255)
    arrival_date = serializers.DateField()
    arrival_time = serializers.CharField(max_length=255)
    class Meta:
      model=Schedule
      fields=['schedule_id','departure_date','departure_time','arrival_date','arrival_time']

class FlightSerializer(serializers.ModelSerializer):
    price = serializers.FloatField()
    class Meta:
      model=Flight
      fields=['flight_id','price','plane_id1','airline_id1','schedule_id1']

class BookingSerializer(serializers.ModelSerializer):
    class_field = serializers.CharField(max_length=255)
    class Meta:
      model=Booking
      fields=['booking_id','customer_id1','flight_id1','class_field']