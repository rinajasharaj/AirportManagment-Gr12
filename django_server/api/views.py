from django.shortcuts import render
from rest_framework.decorators import api_view
from rest_framework.response import Response
from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework.decorators import api_view, parser_classes
from rest_framework.parsers import JSONParser
from .models import Admin, Airline,Customer,Plane,Schedule,Flight
from .serializers import AdminSerializer,AirlineSerializer,CustomerSerializer,PlaneSerializer,ScheduleSerializer,FlightSerializer
from rest_framework import status
from .filters import AdminFilter,AirlineFilter,CustomerFilter,PlaneFilter,ScheduleFilter,FlightFilter


@csrf_exempt
def admin_list(request):
	if request.method=="GET":
		admin = Admin.objects.all()
		filter = AdminFilter(request.GET, queryset=admin)
		if filter.is_valid():
			admin = filter.qs
		serializer = AdminSerializer(admin, many=True)
		
		return JsonResponse(serializer.data, safe=False)

	if request.method=='POST':
		data = JSONParser().parse(request)
		serializer = AdminSerializer(data=data)
		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data, status=status.HTTP_201_CREATED)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
	


@csrf_exempt
def admin_detail(request, pk):
	try:
		admin =Admin.objects.get(pk=pk)
	except Admin.DoesNotExist:
		return HttpResponse(status=status.HTTP_400_BAD_REQUEST)

	if request.method == 'GET':
		serializer=AdminSerializer(admin)
		return JsonResponse(serializer.data)

	elif request.method=="PATCH":
		data = JSONParser().parse(request)
		serializer = AdminSerializer(admin, data=data)

		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)	

	elif request.method == 'DELETE':
		admin.delete()
		return HttpResponse(status=status.HTTP_204_NO_CONTENT)

@csrf_exempt
def airline_list(request):
	if request.method=="GET":
		airline = Airline.objects.all()
		filter = AirlineFilter(request.GET, queryset=airline)
		if filter.is_valid():
			airline = filter.qs
		serializer = AirlineSerializer(airline, many=True)
		
		return JsonResponse(serializer.data, safe=False)

	if request.method=='POST':
		data = JSONParser().parse(request)
		serializer = AirlineSerializer(data=data)
		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data, status=status.HTTP_201_CREATED)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
	


@csrf_exempt
def airline_detail(request, pk):
	try:
		airline =Airline.objects.get(pk=pk)
	except Airline.DoesNotExist:
		return HttpResponse(status=status.HTTP_400_BAD_REQUEST)

	if request.method == 'GET':
		serializer=AirlineSerializer(airline)
		return JsonResponse(serializer.data)

	elif request.method=="PATCH":
		data = JSONParser().parse(request)
		serializer = AirlineSerializer(airline, data=data)

		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)	

	elif request.method == 'DELETE':
		airline.delete()
		return HttpResponse(status=status.HTTP_204_NO_CONTENT)

@csrf_exempt
def customer_list(request):
	if request.method=="GET":
		customer = Customer.objects.all()
		filter = CustomerFilter(request.GET, queryset=customer)
		if filter.is_valid():
			customer = filter.qs
		serializer = CustomerSerializer(customer, many=True)
		
		return JsonResponse(serializer.data, safe=False)

	if request.method=='POST':
		data = JSONParser().parse(request)
		serializer = CustomerSerializer(data=data)
		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data, status=status.HTTP_201_CREATED)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
	

@csrf_exempt
def customer_detail(request, pk):
	try:
		customer =Customer.objects.get(pk=pk)
	except Customer.DoesNotExist:
		return HttpResponse(status=status.HTTP_400_BAD_REQUEST)

	if request.method == 'GET':
		serializer=CustomerSerializer(customer)
		return JsonResponse(serializer.data)

	elif request.method=="PATCH":
		data = JSONParser().parse(request)
		serializer = CustomerSerializer(customer, data=data)

		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)	

	elif request.method == 'DELETE':
		customer.delete()
		return HttpResponse(status=status.HTTP_204_NO_CONTENT)

@csrf_exempt
def plane_list(request):
	if request.method=="GET":
		plane = Plane.objects.all()
		filter = PlaneFilter(request.GET, queryset=plane)
		if filter.is_valid():
			plane = filter.qs
		serializer = PlaneSerializer(plane, many=True)
		
		return JsonResponse(serializer.data, safe=False)

	if request.method=='POST':
		data = JSONParser().parse(request)
		serializer = PlaneSerializer(data=data)
		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data, status=status.HTTP_201_CREATED)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
	


@csrf_exempt
def plane_detail(request, pk):
	try:
		plane =Plane.objects.get(pk=pk)
	except Plane.DoesNotExist:
		return HttpResponse(status=status.HTTP_400_BAD_REQUEST)

	if request.method == 'GET':
		serializer=PlaneSerializer(plane)
		return JsonResponse(serializer.data)

	elif request.method=="PATCH":
		data = JSONParser().parse(request)
		serializer = PlaneSerializer(plane, data=data)

		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)	

	elif request.method == 'DELETE':
		plane.delete()
		return HttpResponse(status=status.HTTP_204_NO_CONTENT)

@csrf_exempt
def schedule_list(request):
	if request.method=="GET":
		schedule = Schedule.objects.all()
		filter = ScheduleFilter(request.GET, queryset=schedule)
		if filter.is_valid():
			schedule = filter.qs
		serializer = ScheduleSerializer(schedule, many=True)
		
		return JsonResponse(serializer.data, safe=False)

	if request.method=='POST':
		data = JSONParser().parse(request)
		serializer = ScheduleSerializer(data=data)
		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data, status=status.HTTP_201_CREATED)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
	


@csrf_exempt
def schedule_detail(request, pk):
	try:
		schedule = Schedule.objects.get(pk=pk)
	except Schedule.DoesNotExist:
		return HttpResponse(status=status.HTTP_400_BAD_REQUEST)

	if request.method == 'GET':
		serializer=ScheduleSerializer(schedule)
		return JsonResponse(serializer.data)

	elif request.method=="PATCH":
		data = JSONParser().parse(request)
		serializer = ScheduleSerializer(schedule, data=data)

		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)	

	elif request.method == 'DELETE':
		schedule.delete()
		return HttpResponse(status=status.HTTP_204_NO_CONTENT)

@csrf_exempt
def flight_list(request):
	if request.method=="GET":
		flight = Flight.objects.all()
		filter = FlightFilter(request.GET, queryset=flight)
		if filter.is_valid():
			flight = filter.qs
		serializer = FlightSerializer(flight, many=True)
		
		return JsonResponse(serializer.data, safe=False)

	if request.method=='POST':
		data = JSONParser().parse(request)
		serializer = FlightSerializer(data=data)
		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data, status=status.HTTP_201_CREATED)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
	


@csrf_exempt
def flight_detail(request, pk):
	try:
		flight = Flight.objects.get(pk=pk)
	except Flight.DoesNotExist:
		return HttpResponse(status=status.HTTP_400_BAD_REQUEST)

	if request.method == 'GET':
		serializer=FlightSerializer(flight)
		return JsonResponse(serializer.data)

	elif request.method=="PATCH":
		data = JSONParser().parse(request)
		serializer = FlightSerializer(flight, data=data)

		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data)
		return JsonResponse(serializer.errors, status=status.HTTP_400_BAD_REQUEST)	

	elif request.method == 'DELETE':
		flight.delete()
		return HttpResponse(status=status.HTTP_204_NO_CONTENT)

