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
5. python -m makemigrations  
6. python -m migrate  
7. python -m runserver  

To start the project make sure you have Python and Django installed, as well as the libraries required for JavaFX and MySQL DB Connectors.
The .env file must be created locally and the server connection data provided.  
Go to the terminal and give the following commands:  
1. python -m venv venv  
2. venv\Scripts\activate  
3. pip install -r requirements.txt  
4. cd django_server  
5. python -m makemigrations  
6. python -m migrate  
7. python -m runserver  

