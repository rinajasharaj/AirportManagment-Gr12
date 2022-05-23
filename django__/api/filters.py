from django_filters import rest_framework as filters
from .models import Flight

class FlightFilter(filters.FilterSet):
    class Meta:
        model = Flight
        fields = ['id','name','destination','date','arrival_time','depart_time','no_passengers']