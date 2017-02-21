-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: cm
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `movieId` bigint(20) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(200) DEFAULT NULL,
  `introduction` varchar(2000) DEFAULT NULL,
  `actor` varchar(200) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `addById` bigint(20) DEFAULT NULL,
  `trailer` varchar(300) DEFAULT NULL,
  `picture` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`movieId`),
  KEY `fk_add` (`addById`),
  CONSTRAINT `fk_add` FOREIGN KEY (`addById`) REFERENCES `accounts` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Split','Ba cô gái trẻ bị một kẻ lạ mặt bắt cóc và đem nhốt lại trong phòng kín. Điên cuồng tìm đường thoát, họ phát hiện ra rằng kẻ bắt cóc Kevin là một người đàn ông có 23 nhân cách khác nhau. Trong đó có một kẻ bạo lực, có phụ nữ và có cả một đứa trẻ.',' James McAvoy, Anya Taylor-Joy',' Kinh dị, Hình sự','2017-02-17','2017-04-17',1,'https://www.youtube.com/embed/84TouqfIsiI','https://www.galaxycine.vn/media/s/p/split.jpg'),(2,'POIGNANT ','Quyết định mua một căn nhà mới, Amy và những người bạn cùng đến tham quan và chọn một căn nhà ưng ý. Tuy nhiên, cô bạn Melissa của Amy lại cảm thấy không ổn. Linh cảm xấu của Melissa nhanh chóng thành sự thật khi rất nhiều sự việc kinh hoàng xảy ra với nhóm bạn. Amy quyết định tìm hiểu và phát hiện bí mật bị chôn vùi về một oan hồn đầy thù hận.',' Laura Mitchell, Steve Baran',' Kinh dị, Hình sự','2017-02-23','2017-04-23',1,'https://www.youtube.com/embed/hRl1_xNSCTc','https://www.galaxycine.vn/media/o/a/oanhon.gif'),(3,'FIFTY SHADES DARKER','Sau phần 1 - Fifty Shades of Grey thu gần 600 triệu $ trên toàn thế giới,  Jamie Dornan và Dakota Johnson trở lại trong câu chuyện ngôn tình kiểu Mỹ đầy màu sắc nhục dục. Trong phần này, chàng tỷ phú Christian sẽ phải vật lộn với nhân cách ma quỷ tồn tại trong anh. Còn cô gái đáng yêu Anastasia cũng gặp rất nhiều khó khăn khi đối mặt với cơn giận và sự ghen tuông của những phụ nữ từng quan hệ với Christian trước cô.',' Dakota Johnson',' Tâm lý, Tình cảm','2017-02-28','2017-04-30',1,'https://www.youtube.com/embed/OItKvc13gws','https://www.galaxycine.vn/media/5/0/50shade.jpg'),(4,'THE LEGO BATMAN MOVIE','Tỷ phú kiêm Người Dơi Bruce Wayne thật bận rộn. Một mặt phải giải quyết đám tội phạm ở thành phố Gotham, một mặt anh phải gánh trách nhiệm với đứa trẻ mình nhận nuôi.Sau Suicide Squad và trong lúc chờ đến phim riêng dành cho Batman của Ben Affleck, hãy cùng gặp gỡ Batman ở phiên bản Lego vô cùng hài hước. Dĩ nhiên, The Lego Batman Movie không thể vắng mặt kẻ thù truyền kiếp của Người Dơi – Joker.',' Will Arnett, Zach Galifianakis, Jenny Slate',' Hành động, Hoạt hình, Giả Tưởng','2017-02-07','2017-04-07',2,'https://www.youtube.com/embed/h6DOpfJzmo0','https://www.galaxycine.vn/media/b/a/batman_2.jpg'),(5,'GUARDIANS ','Khi cuộc chiến tranh lạnh giữa Nga và Mỹ không ngừng leo thang căng thẳng, một tổ chức tên Patriot được lập ra nhằm đào tạo một biệt đội siêu anh hùng bao gồm các thành viên của những nước Xô Viết. Họ được cải tạo gen và biến thành những chiến binh bất khả chiến bại. Suốt nhiều năm, những siêu anh hùng này cố gắng che giấu danh tính của mình. ',' Valeriya Shkirando, Anton Pampushnyy, Alina Lanina, Sanzhar Madiyev',' Phiêu lưu, Hành động, Giả Tưởng','2017-03-13','2017-04-13',2,'https://www.youtube.com/embed/3ht87vj4ZEI','https://www.galaxycine.vn/media/s/i/sieu.jpg'),(6,'THE BYE BYE MAN','Ba người bạn vướng vào sự kiện kinh hoàng của Bye Bye Man, một biểu tượng bí ẩn là căn nguyên ác quỷ đằng sau những hành vi ghê tởm nhất của con người. The Bye Bye Man là phim kinh dị ly kỳ chuyển thể từ truyện ngắn của Robert Damon Schneck, do Jonathan Penner làm biên kịch và Stacy Title làm đạo diễn. Phim có sự tham gia của dàn diễn viên thực lực  Douglas Smith, Lucien Laviscount, Cressida Bonas…',' Douglas Smith',' Kinh dị, Ly kì','2017-04-13','2017-05-13',2,'https://www.youtube.com/embed/S2DwrJ9S3f4','https://www.galaxycine.vn/media/2/./2_192.jpg'),(7,'WOLVERINE 3- LOGAN','Đặt bối cảnh ở tương lai năm 2024, khi nhóm X-Men đã tan rã. Năng lực hồi phục của Wolverine - Logan dần dần mất đi còn giáo sư X lại mắc bệnh Alzheimer suy giảm trí nhớ. Lúc này, một tập đoàn do Nathaniel Essex lãnh đạo tìm cách phá hoại thế giới, Logan phải chiến đấu chống lại hắn cùng với sự giúp đỡ của cô bé Laura Kinney – một người đột biến được nhân bản từ chính ông. Được dán nhãn R, Logan là bộ phim bạo lực nhất, đúng chất comic nhất từ trước tới nay của “Người Sói”. Đây có lẽ là lần cuối cùng Hugh Jackman xuất hiện trong vai trò Wolverine. Phần này, giáo sư X sẽ xuất hiện dưới “phiên bản già” của diễn viên kỳ cựu Patrick Stewart. Logan được dự đoán sẽ gây shock cho toàn thế giới không kém những gì Deadpool cùng hãng làm được vào đầu năm 2016.',' Hugh Jackman, Patrick Stewart',' Hành động, Giả Tưởng','2017-04-20','2017-05-30',2,'https://www.youtube.com/embed/22iu8byk5C8','https://www.galaxycine.vn/media/l/o/lo_1.jpg'),(8,'THE BOSS BABY','Chuyện gì sẽ xảy ra khi một em bé tuổi đang mang tã lại mặc bộ quần áo công sở và hợp tác cùng “anh trai hờ” 7 tuổi của nhóc trong việc chống lại những âm mưu bẩn thỉu của giám đốc điều hành tập đoàn thú cưng? The Boss Baby là bộ phim hài hước dành cho gia đình với cốt truyện chưa-từng-có sẽ ra mắt tại các rạp chiếu phim toàn cầu vào 31.03.2017. Phim quy tụ nhiều ngôi sao nổi tiếng Hollywood cho công đoạn lồng tiếng, bạn sẽ được nghe chất giọng truyền cảm của những diễn viên hàng đầu như Alec Baldwin, Tobey Maguire…',' Alec Baldwin, Lisa Kudrow, Steve Buscemi, Tobey Maguire, Jimmy Kimmel',' Hài, Hoạt hình, Gia đình','2017-03-28','2017-04-28',3,'https://www.youtube.com/embed/r8kE7rSzfQs','https://www.galaxycine.vn/media/n/h/nhoc.jpg'),(9,'BEAUTY AND THE BEAST','Chuyển thể từ truyện cổ Grimm nổi tiếng, Beauty And The Beast là câu chuyện tình lãng mạn giữa một cô gái vùng quê và vị hoàng tử bị dính lời nguyền trở thành quái vật. Vì quá ích kỷ, chàng hoàng tử bị biến thành quái vật, sống trong tòa lâu đài cùng những đồ vật biết nói. Chỉ đến khi nào một cô gái thật lòng yêu, chàng mới trở lại thành người. Nhiều năm đã trôi qua, khi Quái vật gần như tuyệt vọng thì cô gái thông minh Belle xuất hiện. Làm lại từ bộ phim hoạt hình nổi tiếng đã đoạt hai giải Oscar và vinh dự là phim hoạt hình đầu tiên được đề cử giải Phim hay nhất, Beauty And The Beast quy một dàn diễn viên tài năng, trẻ trung và nổi tiếng hàng đầu Hollywood. Đặc biệt, vai nữ chính Belle được giao cho nữ diễn viên thành danh từ loạt phim Harry Potter - Emma Watson. ','Emma Watson',' Tình cảm, Thần thoại','2017-03-20','2017-04-25',3,'https://www.youtube.com/embed/OvW_L8sTu5E','https://www.galaxycine.vn/media/b/e/beauty_3.jpg'),(10,'A CURE FOR WELLNESS','A Cure For Wellness là tác phẩm ly kỳ bí ẩn kể lấy bối cảnh thế giới tương lai. Được cử tới đón CEO một công ty trở về từ trung tâm điều trị ở núi Alps, chàng trai trẻ tham vọng Lockhart những tưởng đây là cơ hội cho mình. Thế nhưng, chuyến đi tưởng như đơn giản này lại ẩn chứa những nguy hiểm khủng khiếp mà không ai muốn đối mặt trong đời. Những bí mật chết người lần lượt được hé lộ, Lockhart bị ép buộc ở lại nơi này! Vai nam chính Lockhart được tin tưởng giao cho nam diễn viên Dane DeHaan, từng quen thuộc với khán giả qua vai diễn Harry Osborn trong siêu phẩm The Amazing Spider-Man. Với khuôn mặt trẻ trung nai tơ cùng lối diễn chắc tay, Dane chắc chắn sẽ không làm người xem thất vọng. Hợp diễn cùng anh là Mia Goth, cô gái 24 tuổi có vẻ đẹp ấn tượng.',' Dane DeHaan',' Ly kì','2017-04-01','2017-05-01',3,'https://www.youtube.com/embed/YVwQNDS-Zes','https://www.galaxycine.vn/media/4/./4_149.jpg');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-17 15:19:47
