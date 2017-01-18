create database if not exists cm;
use cm;
create table seat (
	seat_id integer not null primary key,
    room integer(2),
    theater varchar(50),
    seat varchar(3)    
);

create table accounts (
    user_id integer(10) not null primary key,
    username varchar(50),
    password varchar(50),
    role varchar (30)
);

create table movie (
    movie_id integer(5) not null primary key auto_increment,
    movie_name varchar(50),
	introduction varchar(2000),
    actor varchar(300),
    genre varchar(50),
    start_date date,
    end_date date,
    add_by_id integer(10),
    trailer varchar(300),
    picture varchar (300),
    constraint fk_add foreign key (add_by_id) references accounts(user_id)
);

create table schedules (
    schedule_id integer not null primary key auto_increment,
    start_date date,
    start_time time,
    theatre varchar(50),
    room integer(2),
    movie_id integer(5),    
    constraint fk_movie foreign key (movie_id) references movie(movie_id)
);

create table ticket (
	ticket_id integer NOT NULL primary key AUTO_INCREMENT,
    schedule_id integer,
    price double,
    phone varchar(15),
    email varchar(50),
    name_of_customer varchar(50),
    seat_id integer,
    constraint fk_seat foreign key (seat_id) references seat(seat_id),
    constraint fk_schedule foreign key (schedule_id) references schedules(schedule_id)
);
create database if not exists cm;
use cm;
create table seat (
	seat_id integer not null primary key,
    room integer(2),
    theater varchar(50),
    seat varchar(3)    
);

create table accounts (
    user_id integer(10) not null primary key,
    username varchar(50),
    password varchar(50),
    role varchar (30)
);

create table movie (
    movie_id integer(5) not null primary key auto_increment,
    movie_name varchar(50),
	introduction varchar(2000),
    actor varchar(300),
    genre varchar(50),
    start_date date,
    end_date date,
    add_by_id integer(10),
    trailer varchar(300),
    picture varchar (300),
    constraint fk_add foreign key (add_by_id) references accounts(user_id)
);

create table schedules (
    schedule_id integer not null primary key auto_increment,
    start_date date,
    start_time time,
    theatre varchar(50),
    room integer(2),
    movie_id integer(5),    
    constraint fk_movie foreign key (movie_id) references movie(movie_id)
);

create table ticket (
	ticket_id integer NOT NULL primary key AUTO_INCREMENT,
    schedule_id integer,
    price double,
    phone varchar(15),
    email varchar(50),
    name_of_customer varchar(50),
    seat_id integer,
    constraint fk_seat foreign key (seat_id) references seat(seat_id),
    constraint fk_schedule foreign key (schedule_id) references schedules(schedule_id)
);


 