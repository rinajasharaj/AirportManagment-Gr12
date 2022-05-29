# AirportManagment-Gr12

Sistemi i shpërndarë të cilin kemi zhvilluar ka për qëllim menaxhimin e fluturimeve në aeroportin e Prishtinës “Adem Jashari”.
Ngërthen në vete një HTTP server (i krijuar me Python dhe Django), një TCP/UDP server (i krijuar me Java) dhe një chat që mundëson komunikimin me tekst, zë dhe video.
GUI i sistemit është punuar me JavaFX.
Në këtë projekt kemi punuar gjithsej 5 persona, për disa ditë me radhë.

The distributed system we have developed aims to manage flights at Prishtina Airport "Adem Jashari".
It includes an HTTP server (created with Python and Django), a TCP/UDP server (created with Java) and a chat that enables text, voice and video communication.
The GUI is done with JavaFX.
In this project we have worked a total of 5 people, for several days in a row.

Për të startuar projektin sigurohuni që keni të instaluar Python dhe Django, gjithashtu që i keni të përfshira në projekt libraritë e nevojshme për JavaFX dhe MySQL DB Connectors.  
Duhet krijuar .env file lokalisht dhe të jepen të dhënat për lidhje me server
Kaloni në terminal dhe jepni komandat si në vazhdim:  
1. python -m venv venv  
2. venv\Scripts\activate  
3. pip install -r requirements.txt  
4. cd django_server  
5. python manage.pyt makemigrations  
6. python manage.py migrate  
7. python manage.py runserver  

Të dhënat që duhet të përfshijë .env file:
<br />SECRET_KEY=django-insecure-yp%8^jus_*-6x#-+%48&sk_b197y!4-lz=h%tktmdd_231h5wl
<br />DEBUG=TRUE
<br />NAME=hermes_airline
<br />User=Your database username
<br />Pass=Your database password

Libraritë e nevojshme që duhen të përfshihen për të startuar klientin:
1. JavaFx SDK
2. MySQL connector
3. JSON jar që suporton org.json

To start the project make sure you have Python and Django installed, as well as the libraries required for JavaFX and MySQL DB Connectors.
The .env file must be created locally and the server connection data provided.  
Go to the terminal and give the following commands:  
1. python -m venv venv  
2. venv\Scripts\activate  
3. pip install -r requirements.txt  
4. cd django_server  
5. python manage.py makemigrations  
6. python manage.py migrate  
7. python manage.py runserver

The data that should be included in .env file:
<br />SECRET_KEY=django-insecure-yp%8^jus_*-6x#-+%48&sk_b197y!4-lz=h%tktmdd_231h5wl
<br />DEBUG=TRUE
<br />NAME=hermes_airline
<br />User=Your database username
<br />Pass=Your database password

Required libraries that should be included to start the client side:
1. JavaFx SDK
2. MySQL connector
3. JSON jar that supports org.json


