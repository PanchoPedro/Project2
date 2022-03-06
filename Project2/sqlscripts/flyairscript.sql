select * from airlines
Order by airline ASC;

select airport from airports
Order by airport ASC;

select * from flights
Order by date_time ASC;

select * from orders;
select * from users;

update users set password=123 where email='figo@flyair.com';

select * from users where users.email='pedro@flyair.com' and users.password='123';

select flights.*, SUM(orders.seats) 'takenseats' from flights
left join orders
ON flights.id=orders.flightid
where flights.source='Rome Fiumicino Airport (FCO)' and
flights.destination='Madrid Barajas Airport (MAD)' and
CAST(flights.date_time as date)='2022-03-09' 
GROUP BY orders.flightid
Order by date_time ASC;

select flightid,SUM(seats) from orders
GROUP BY flightid;

#view used seats by flight
select flights.id, orders.seats from flights
left join orders
ON flights.id=orders.id;


#view current orders
SELECT users.firstname,users.surname,users.email,flights.id,flights.source,flights.destination,flights.date_time,orders.seats
FROM users,flights,orders
where users.id=orders.userid
and flights.id=orders.flightid;
#and users.id=2; # user id we want to view

#view available seats
select (flights.seats-sum(orders.seats)) from flights , orders
	where flights.id=2 and
    orders.flightid=2; #flight that we want to check



insert into users (firstname,surname,email,dateofbirth,password) 
values ("Pedro","Pancho","pedro@flyair.com","1990-01-01","123");

Insert into airlines (airline)
values ("Iberia");

Insert into airports (airport)
values ("London Gatwick Airport (LGW)");

insert into flights (source,destination,airline,price,date_time,seats)
values ("Rome Fiumicino Airport (FCO)","Madrid Barajas Airport (MAD)","TAP","400","2022-03-09 08:00:00","100");

insert into orders (userid,flightid,seats)
values ("1","1","1"),("1","2","2"),("2","2","1"),("2","3","1");

drop table orders;