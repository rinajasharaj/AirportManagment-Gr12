from django.db import models
from datetime import datetime

class Flight(models.Model):
    name = models.CharField(max_length=80)
    source_dest=models.CharField(max_length=200)
    destination=models.CharField(max_length=200)
    date=models.DateTimeField(default=datetime.now, blank=True)
    arrival_time=models.TimeField()
    depart_time=models.TimeField()
    no_passengers=models.IntegerField()

    def __str__(self):
        return self.name
