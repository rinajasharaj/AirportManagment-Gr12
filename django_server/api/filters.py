from django_filters import rest_framework as filters
from .models import Admin,Airline,Customer,Plane,Schedule,Flight

class  AdminFilter(filters.FilterSet): 
    class Meta:
        model = Admin
        fields = ['admin_id','first_name','last_name', 'password']

class  AirlineFilter(filters.FilterSet): 
    class Meta:
        model = Airline
        fields=['airline_id','departure_city','arrival_city']

class  CustomerFilter(filters.FilterSet): 
    class Meta:
        model = Customer
        fields=['customer_id','first_name','last_name','age','passport_number','phone_nr']

class  PlaneFilter(filters.FilterSet): 
    class Meta:
        model = Plane
        fields=['plane_id','plane_name','first_class','coach','economy']

class  ScheduleFilter(filters.FilterSet): 
    class Meta:
        model = Schedule
        fields=['schedule_id','departure_date','departure_time','arrival_date','arrival_time']

class  FlightFilter(filters.FilterSet): 
    class Meta:
        model = Flight
        fields=['flight_id','price','plane_id1','airline_id1','schedule_id1']