from rest_framework import serializers
from api.models import Flight
from datetime import datetime

class FlightSerializer(serializers.ModelSerializer):
    name = serializers.CharField(max_length=80)
    source_dest=serializers.CharField(max_length=200)
    destination=serializers.CharField(max_length=200)
    arrival_time=serializers.TimeField()
    depart_time=serializers.TimeField()
    no_passengers=serializers.IntegerField()

    class Meta:
           model=Flight
           fields=['id','name','source_dest','destination','date','arrival_time','depart_time','no_passengers']
