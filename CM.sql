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
    lenght int(3),
    isActive boolean,
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
INSERT INTO `cm`.`accounts` (`username`, `password`, `nameOfCustomer`, `birthdate`, `role`,`isActive`) VALUES ('admin', 'admin', 'bao bao', '1995-08-01', 'admin','1');

/*insert movie*/
INSERT INTO `movie` (`movieName`,`introduction`,`actor`,`genre`,`startDate`,`endDate`,`addById`,`trailer`,`picture`,`lenght`,`isActive`) VALUES ('LA LA LAND','La La Land là câu chuyện tình yêu tuyệt đẹp thời hiện đại giữa chàng nhạc công piano tài hoa chuyên diễn tại các quán bar Sebastian (Ryan Gosling) và cô diễn viên mới nổi xinh đẹp Mia Dolan (Emma Stone). Thế nhưng, ở thiên đường điện ảnh Hollywood, tình yêu và sự thành công dường như không thể song hành. Khi thành công và sự nổi tiếng đến, họ sẽ phải đối mặt ra sao?','Ryan Gosling, Emma Stone, Rosemarie DeWitt','Love','2016-02-23','2017-03-16',1,'https://youtu.be/0pdqf4P9MB8','http://ysolife.com/wp-content/uploads/2016/11/image002.jpg', 90, 1);
INSERT INTO `movie` (`movieName`,`introduction`,`actor`,`genre`,`startDate`,`endDate`,`addById`,`trailer`,`picture`,`lenght`,`isActive`) VALUES ('THE VOW','The Vow nói về tình yêu của hai nhân vật Paige và Leo. Cả hai quyết định tổ chức đám cưới \"chui\" trong một viện bảo tàng để tiết kiệm chi phí. Tuy nhiên, khi họ đang tận hưởng những ngày hạnh phúc đầu tiên của cuộc sống hôn nhân thì một biến cố xảy ra. Tai nạn xe hơi thảm khốc đã cướp đi trí nhớ của Paige. Khi thức dậy trong bệnh viện, cô không còn nhớ Leo là ai mà chỉ nhớ được quãng thời gian trước khi gặp và yêu anh. Mọi chuyện trở nên phức tạp khi Paige quay về với người yêu cũ trước đây. Leo tự nhủ phải làm mọi cách để giành lại trái tim của vợ mình...','Channing Tatum,...','Love','2017-02-28','2017-03-15',1,'https://youtu.be/tdF01cA7jOE','https://upload.wikimedia.org/wikipedia/en/c/c2/The_Vow_Poster.jpg', 97, 1);
INSERT INTO `movie` (`movieName`, `introduction`, `actor`, `genre`, `startDate`, `endDate`, `addById`, `trailer`, `picture`, `lenght`, `isActive`) VALUES ('LOGAN/ NGƯỜI SÓI', 'Đặt bối cảnh ở tương lai năm 2029, khi nhóm X-Men đã tan rã. Năng lực hồi phục của Wolverine - Logan dần dần mất đi còn giáo sư X lại mắc bệnh Alzheimer suy giảm trí nhớ. Lúc này, một tập đoàn do Nathaniel Essex lãnh đạo tìm cách phá hoại thế giới, Logan phải chiến đấu chống lại hắn cùng với sự giúp đỡ của cô bé Laura Kinney – một người đột biến được nhân bản từ chính ông. Được dán nhãn R, Logan là bộ phim bạo lực nhất, đúng chất comic nhất từ trước tới nay của “Người Sói”. Đây có lẽ là lần cuối cùng Hugh Jackman xuất hiện trong vai trò Wolverine. Phần này, giáo sư X sẽ xuất hiện dưới “phiên bản già” của diễn viên kỳ cựu Patrick Stewart. Logan được dự đoán sẽ gây shock cho toàn thế giới không kém những gì Deadpool cùng hãng làm được vào đầu năm 2016.  ', 'Hugh Jackman, Patrick Stewart.', 'Action, ', '2017-03-01', '2017-03-24', '1', 'https://youtu.be/Div0iP65aZo', 'http://i.marvelousnews.com/g/generated/Logan/logan_ver3__scaled_600.jpg', '135', '1');
INSERT INTO `movie` (`movieName`, `introduction`, `actor`,`genre`, `startDate`, `endDate`, `addById`, `trailer`, `picture`, `lenght`, `isActive`) VALUES ('RESIDENT EVIL : FINAL CHAPTER / VÙNG ĐẤT QUỶ DỮ HỒI CUỐI', 'Được kỳ vọng là đoạn kết bi tráng và xứng đáng cho serie phim hành động rùng rợn kinh điển của thế giới trong vòng 15 năm qua, Resident Evil: The final chapter hiện đang là bộ phim được mong chờ nhất trong mùa phim đầu 2017. Vẫn bám sát cốt truyện về cuộc chiến giằng co của thế giới loài người trước sự chết chóc tàn bạo của zombie cùng quái vật đột biến, phần phim mới này sẽ là cuộc khai hỏa cuối cùng của những kẻ không còn gì để mất.', 'Milla Jovovich, Ruby Rose, Ali Larter', 'Action','2017-02-15', '2017-03-10', '1', 'https://youtu.be/YMMUK2rdsEY', 'https://www.galaxycine.vn/media/r/e/resi.jpg', '109', '1');
INSERT INTO `movie` (`movieName`, `introduction`, `actor`, `genre`, `startDate`, `endDate`, `addById`, `trailer`, `picture`, `isActive`) VALUES ('KONG: SKULL ISLAND / KONG: ĐẢO ĐẦU LÂU', 'Kong: Skull Island là bộ phim hành động, phiêu lưu, giả tưởng kể về nguồn gốc thật sự của King Kong, mở đầu bằng chuyến hành trình của một đoàn thám hiểm tới hòn đảo này. Không may, họ gặp phải sự cố. Những nhà thám hiểm sẽ phải sống mái với cư dân bản địa và cả cơn ác mộng tồi tệ nhất – King Kong.Với ngoại cảnh quay ở Việt Nam, Kong: Skull Island tự hào giới thiệu những thắng cảnh tuyệt đẹp của Ninh Bình, Quảng Bình… tới bạn bè thế giới. Phim có sự tham gia của ngôi sao người Anh Tom Hiddleston và nữ diễn viên vừa đoạt giải Oscar năm 2016 Brie Larson. ', 'Tom Hiddleston, Samuel L. Jackson, Toby Kebbell', 'Action, Adventure', '2017-03-12', '2017-03-30', '1', 'https://youtu.be/WfjvbkdQ2zQ', 'https://www.galaxycine.vn/media/k/o/kong_1.jpg', '1');
INSERT INTO `movie` (`movieName`, `introduction`, `actor`, `genre`, `startDate`, `endDate`, `addById`, `trailer`, `picture`,`isActive`) VALUES ('FAST AND FURIOUS 8', 'Chia tay Brian O\'Conner – Paul Walker nhưng cuộc phiêu lưu tốc độ của Dominic Toretto vẫn còn tiếp diễn. Lần đầu tiên, Dominic Toretto phản bội gia đình và những người bạn của mình. Đặc vụ Hobbs vì thế bị tống vào tù. Mọi người đều hoang mang trước sự thay đổi của người anh cả vẫn luôn bảo vệ cho cả nhóm. Liệu có bí mật nào đằng sau việc Toretto phản bội? Nhân vật bí ẩn Cipher đóng vai trò gì trong sự việc này? Việc kết hợp của nhóm với \"kẻ thù cũ\" Shaw sẽ đem lại kết quả thế nào? Tất cả đều đang chờ bạn trong Fast & Furious 8 - The Fate Of The Furious.', 'Vin Diesel, Dwayne Johnson, Jason Statham', 'Action', '2017-04-12', '2017-04-27', '1', 'https://youtu.be/_7tF-Uf7IZY', 'https://www.galaxycine.vn/media/f/a/fast.jpg','1');
INSERT INTO `movie` (`movieName`, `introduction`, `actor`, `genre`, `startDate`, `endDate`, `addById`, `trailer`, `picture`,`isActive`) VALUES ('BEAUTY AND THE BEAST / NGƯỜI ĐẸP VÀ QUÁI VẬT', 'Chuyển thể từ truyện cổ Grimm nổi tiếng, Beauty And The Beast là câu chuyện tình lãng mạn giữa một cô gái vùng quê và vị hoàng tử bị dính lời nguyền trở thành quái vật. Vì quá ích kỷ, chàng hoàng tử bị biến thành quái vật, sống trong tòa lâu đài cùng những đồ vật biết nói. Chỉ đến khi nào một cô gái thật lòng yêu, chàng mới trở lại thành người. Nhiều năm đã trôi qua, khi Quái vật gần như tuyệt vọng thì cô gái thông minh Belle xuất hiện.', 'Emma Watson', 'Love', '2017-03-17', '2017-04-14', '1', 'https://youtu.be/1Ixcb4vJIKM', 'https://www.galaxycine.vn/media/b/e/beauty_3.jpg','1');
INSERT INTO `movie` (`movieName`, `introduction`, `actor`, `genre`, `startDate`, `endDate`, `addById`, `trailer`, `picture`, `isActive`) VALUES ('THE BOSS BABY / NHÓC TRÙM', 'Chuyện gì sẽ xảy ra khi một em bé tuổi đang mang tã lại mặc bộ quần áo công sở và hợp tác cùng “anh trai hờ” 7 tuổi của nhóc trong việc chống lại những âm mưu bẩn thỉu của giám đốc điều hành tập đoàn thú cưng? The Boss Baby là bộ phim hài hước dành cho gia đình với cốt truyện chưa-từng-có sẽ ra mắt tại các rạp chiếu phim toàn cầu vào 31.03.2017.', 'Alec Baldwin, Lisa Kudrow, Steve Buscemi, Tobey Maguire, Jimmy Kimmel', 'Comedy, Cartoon', '2017-03-31', '2017-04-13', '1', 'https://youtu.be/3L1zVw5fefU', 'https://www.galaxycine.vn/media/n/h/nhoc.jpg', '1');

