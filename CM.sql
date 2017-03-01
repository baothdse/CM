drop database cm;
create database if not exists cm;
use cm;
create table accounts (
    userId bigint(20) not null primary key auto_increment,
    username varchar(50),
    password varchar(50),
    nameOfCustomer varchar(128),
    birthdate date,
    role varchar (30),
    isActive boolean
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
    isActive boolean,
    lenght int(3),
    constraint fk_add foreign key (addById) references accounts(userId)
);

create table schedules (
    scheduleId bigint(20) not null primary key auto_increment,
    startDate date,
    startTime time,
    theatre varchar(50),
    room integer(2),
    movieId bigint(20),
    isActive boolean,
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
   price bigint(20),
   userId bigint(20),
   seatId bigint(20),
   constraint fb_seat foreign key (seatId) references seat(seatId),
   constraint fk_buy foreign key (userId) references accounts(userId)
);
/*insert account*/
INSERT INTO `cm`.`accounts` (`username`, `password`, `nameOfCustomer`, `birthdate`, `role`) VALUES ('admin', 'admin', 'bao bao', '1995-08-01', 'admin');

/*insert movie*/
INSERT INTO `movie` (`movieId`,`movieName`,`introduction`,`actor`,`genre`,`startDate`,`endDate`,`addById`,`trailer`,`picture`) VALUES (1,'La La Land','La La Land là câu chuyện tình yêu tuyệt đẹp thời hiện đại giữa chàng nhạc công piano tài hoa chuyên diễn tại các quán bar Sebastian (Ryan Gosling) và cô diễn viên mới nổi xinh đẹp Mia Dolan (Emma Stone). Thế nhưng, ở thiên đường điện ảnh Hollywood, tình yêu và sự thành công dường như không thể song hành. Khi thành công và sự nổi tiếng đến, họ sẽ phải đối mặt ra sao?','Ryan Gosling, Emma Stone, Rosemarie DeWitt','Love','2016-02-23','2017-03-08',1,'https://youtu.be/0pdqf4P9MB8','http://ysolife.com/wp-content/uploads/2016/11/image002.jpg');
INSERT INTO `movie` (`movieId`,`movieName`,`introduction`,`actor`,`genre`,`startDate`,`endDate`,`addById`,`trailer`,`picture`) VALUES (2,'The Vow','The Vow nói về tình yêu của hai nhân vật Paige và Leo. Cả hai quyết định tổ chức đám cưới \"chui\" trong một viện bảo tàng để tiết kiệm chi phí. Tuy nhiên, khi họ đang tận hưởng những ngày hạnh phúc đầu tiên của cuộc sống hôn nhân thì một biến cố xảy ra. Tai nạn xe hơi thảm khốc đã cướp đi trí nhớ của Paige. Khi thức dậy trong bệnh viện, cô không còn nhớ Leo là ai mà chỉ nhớ được quãng thời gian trước khi gặp và yêu anh. Mọi chuyện trở nên phức tạp khi Paige quay về với người yêu cũ trước đây. Leo tự nhủ phải làm mọi cách để giành lại trái tim của vợ mình...','Channing Tatum,...','Love','2017-02-28','2017-03-15',1,'https://youtu.be/tdF01cA7jOE','https://upload.wikimedia.org/wikipedia/en/c/c2/The_Vow_Poster.jpg');
