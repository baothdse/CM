drop database cm;
create database if not exists cm;
use cm;
create table accounts (
    userId bigint(20) not null primary key auto_increment,
    username varchar(50),
    password varchar(50),
    nameOfCustomer varchar(128),
    birthdate date,
    role varchar (30)
);
create table movie (
    movieId bigint(20) not null primary key auto_increment,
    movieName varchar(200),
	introduction varchar(2000),
    actor varchar(200),
    genre varchar(50),
    startDate date,
    endDate date,
    addById bigint(20),
    trailer varchar(300),
    picture varchar (300),
    constraint fk_add foreign key (addById) references accounts(userId)
);

create table schedules (
    scheduleId bigint(20) not null primary key auto_increment,
    startDate date,
    startTime time,
    theatre varchar(50),
    room integer(2),
    movieId bigint(20),    
    constraint fk_movie foreign key (movieId) references movie(movieId)
);

create table seat (
	seatId bigint(20) not null primary key auto_increment,
    seatName varchar(4),
    seatStatus boolean,
    scheduleId bigint(20),
    constraint fk_schedule foreign key (scheduleId) references schedules(scheduleId)
);

create table ticket (
   ticketId bigint(20) not null primary key auto_increment,
   username varchar(50),
   phone varchar(50),
   room integer(2),
   startDate date,
   startTime time,
   theatre varchar(50),
   movieName varchar(200),
   amount integer(2),
   totalPrice varchar(50),
   userId bigint(20),
   constraint fk_buy foreign key (userId) references accounts(userId)
);