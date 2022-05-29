create database hermes_airline;
use hermes_airline;

CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`)
);
insert into admin (first_name, last_name,password) values
('admin','admin','admin');

CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `passport_number` varchar(255) NOT NULL,
  `phone_nr` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`)
);

CREATE TABLE `plane` (
  `plane_id` int NOT NULL AUTO_INCREMENT,
  `plane_name` varchar(255) NOT NULL,
  `first_class` int NOT NULL,
  `coach` int NOT NULL,
  `economy` int NOT NULL,
  PRIMARY KEY (`plane_id`)
);

CREATE TABLE `airline` (
  `airline_id` int NOT NULL AUTO_INCREMENT,
  `departure_city` varchar(255) NOT NULL,
  `arrival_city` varchar(255) NOT NULL,
  PRIMARY KEY (`airline_id`)
);

insert into airline (departure_city, arrival_city) values
('Prishtine','New York');

CREATE TABLE `schedule` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `departure_date` date NOT NULL,
  `departure_time` varchar(255) NOT NULL,
  `arrival_date` date NOT NULL,
  `arrival_time` varchar(255) NOT NULL,
  PRIMARY KEY (`schedule_id`)
);

CREATE TABLE flight (
  flight_id int NOT NULL AUTO_INCREMENT,
  plane_id1 int NOT NULL,
  airline_id1 int NOT NULL,
  schedule_id1 int NOT NULL,
  price double NOT NULL,
  PRIMARY KEY (flight_id),
  foreign key(plane_id1) references plane(plane_id),
  foreign key(airline_id1) references airline(airline_id),
  foreign key(schedule_id1) references schedule(schedule_id)
);

CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `customer_id1` int NOT NULL,
  `flight_id1` int NOT NULL,
  `class` varchar(255) NOT NULL,
  PRIMARY KEY (`booking_id`),
  foreign key(customer_id1) references customer(customer_id),
  foreign key(flight_id1) references flight(flight_id)
);
