CREATE TABLE `airports` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `airport` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `airlines` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `airline` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `flights` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `source` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `airline` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `date_time` datetime NOT NULL,
  `seats` int NOT NULL
);

CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `phone` varchar(255) UNIQUE,
  `dateofbirth` date NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(255)
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `userid` int NOT NULL,
  `flightid` int NOT NULL,
  `seats` int NOT NULL
);

ALTER TABLE `flights` ADD FOREIGN KEY (`source`) REFERENCES `airports` (`airport`);

ALTER TABLE `flights` ADD FOREIGN KEY (`destination`) REFERENCES `airports` (`airport`);

ALTER TABLE `flights` ADD FOREIGN KEY (`airline`) REFERENCES `airlines` (`airline`);

ALTER TABLE `orders` ADD FOREIGN KEY (`userid`) REFERENCES `users` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`flightid`) REFERENCES `flights` (`id`);

insert into users (firstname,surname,email,dateofbirth,password,type) 
values ("admin","admin","admin@flyair.com","1970-01-01","admin","admin");

Insert into airlines (airline)
values ("TAP"),("Emirates"),("Lufthansa"),("Air France"),("Ryan Air");

Insert into airports (airport)
values ("London Heathrow Airport (LHR)"),
("Paris Charles de Gaulle Airport (CDG)"),
("Frankfurt International Airport (FRA)"),
("Amsterdam Airport (AMS)"),
("Rome Fiumicino Airport (FCO)"),
("Madrid Barajas Airport (MAD)"),
("Munich International Airport (MUC)"),
("Barcelona Airport (BCN)");

insert into flights (source,destination,airline,price,date_time,seats)
values ("London Heathrow Airport (LHR)","Paris Charles de Gaulle Airport (CDG)","TAP","500","2022-03-08 08:00:00","100"),
("Frankfurt International Airport (FRA)","Amsterdam Airport (AMS)","TAP","400","2022-03-09 08:00:00","100"),
("Rome Fiumicino Airport (FCO)","Madrid Barajas Airport (MAD)","TAP","400","2022-03-09 08:00:00","100");




