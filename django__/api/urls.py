from django.urls import path

from . import views

urlpatterns = [
        path('flights/', views.flight_list, name="flight-list"),
        path('flights/<int:pk>/', views.flight_detail, name="flight_detail"),
]