from django.urls import path

from . import views

urlpatterns = [
    path('admins/', views.admin_list, name="admin-list"),
    path('admins/<int:pk>/', views.admin_detail, name="admin-detail"),
    path('airline/', views.airline_list, name="airline-list"),
    path('airline/<int:pk>/', views.airline_detail, name="airline-detail"),
    path('plane/', views.plane_list, name="plane-list"),
    path('plane/<int:pk>/', views.plane_detail, name="plane-detail"),
    path('customer/', views.customer_list, name="customer-list"),
    path('customer/<int:pk>/', views.customer_detail, name="customer-detail"),
    path('schedule/', views.schedule_list, name="schedule-list"),
    path('schedule/<int:pk>/', views.schedule_detail, name="schedule-detail"),
    ]