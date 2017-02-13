create database if not exists cm;
use cm;
create table accounts (
    user_id bigint(20) not null primary key auto_increment,
    username varchar(50),
    password varchar(50),
    name_of_customer varchar(128),
    birthdate date,
    role varchar (30)
);
create table movie (
    movie_id bigint(20) not null primary key auto_increment,
    movie_name varchar(200),
	introduction varchar(2000),
    actor varchar(200),
    genre varchar(50),
    start_date date,
    end_date date,
    add_by_id bigint(20),
    trailer varchar(300),
    picture varchar (300),
    constraint fk_add foreign key (add_by_id) references accounts(user_id)
);

create table schedules (
    schedule_id bigint(20) not null primary key auto_increment,
    start_date date,
    start_time time,
    theatre varchar(50),
    room integer(2),
    movie_id bigint(20),    
    constraint fk_movie foreign key (movie_id) references movie(movie_id)
);

create table seat (
	seat_id bigint(20) not null primary key auto_increment,
    seat_name varchar(4),
    seat_status boolean,
    schedule_id bigint(20),
    constraint fk_schedule foreign key (schedule_id) references schedules(schedule_id)
);

create table ticket (
   ticket_id bigint(20) not null primary key auto_increment,
   username varchar(50),
   phone varchar(50),
   room integer(2),
   start_date date,
   start_time time,
   theatre varchar(50),
   movie_name varchar(200),
   amount integer(2),
   total_price varchar(50)
);