# Generated by Django 4.0.2 on 2022-05-27 20:08

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0002_flight'),
    ]

    operations = [
        migrations.CreateModel(
            name='Booking',
            fields=[
                ('booking_id', models.AutoField(primary_key=True, serialize=False)),
                ('class_field', models.CharField(db_column='class', max_length=255)),
            ],
            options={
                'db_table': 'booking',
                'managed': False,
            },
        ),
    ]
