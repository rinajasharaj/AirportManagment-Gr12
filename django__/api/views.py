from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from .models import Flight
from .serializers import FlightSerializer
from rest_framework import status
from .filters import FlightFilter
from rest_framework.parsers import JSONParser, MultiPartParser, FileUploadParser

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
			return JsonResponse(serializer.data, status=201)
		return JsonResponse(serializer.errors, status=400)

@csrf_exempt
def flight_detail(request, pk):
    try:
        flight = Flight.objects.get(pk=pk)
    except Flight.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = FlightSerializer(flight)
        return JsonResponse(serializer.data)

    elif request.method=="PATCH":
        data = JSONParser().parse(request)
        serializer = FlightSerializer(flight, data=data)

        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data)
        return JsonResponse(serializer.errors, status=400)

    elif request.method == 'DELETE':
        flight.delete()
        return HttpResponse(status=204)



