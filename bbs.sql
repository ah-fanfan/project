/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - bbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bbs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bbs`;

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_type` varchar(20) DEFAULT NULL,
  `c_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `car` */

insert  into `car`(`id`,`c_type`,`c_number`) values (1,'大众',56),(2,'别克',33),(3,'日产',60),(4,'本田',120),(5,'雪佛兰',25),(6,'红旗',90);

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `p_id` int(11) DEFAULT NULL,
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`p_id`,`c_id`,`c_name`) values (1,1,'成都市'),(1,2,'南充市'),(1,3,'眉山市'),(1,4,'乐山市'),(1,5,'攀枝花市'),(2,6,'昆明市'),(2,7,'大理市'),(2,8,'丽江市'),(3,9,'贵阳市'),(3,10,'毕节市'),(3,11,'六盘水市');

/*Table structure for table `managerlist` */

DROP TABLE IF EXISTS `managerlist`;

CREATE TABLE `managerlist` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_code` varchar(255) DEFAULT NULL,
  `m_psw` varchar(255) DEFAULT NULL,
  `m_sex` char(2) DEFAULT NULL,
  `m_age` int(11) DEFAULT NULL,
  `m_address` varchar(255) DEFAULT NULL,
  `m_image` varchar(255) DEFAULT NULL,
  `m_staus` int(11) DEFAULT '1',
  `m_name` varchar(255) DEFAULT NULL,
  `m_set` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `managerlist` */

insert  into `managerlist`(`m_id`,`m_code`,`m_psw`,`m_sex`,`m_age`,`m_address`,`m_image`,`m_staus`,`m_name`,`m_set`) values (1,'17393144625','123456','男',20,'福建省宁波市余杭区','图片暂无',1,'龚凡','张三'),(4,'17393144613','123456','男',18,'浙江省宁波市西湖区','图片暂无',1,'丁亮','张三'),(5,'17393144614','123456','女',21,'浙江省宁波市西湖区','图片暂无',1,'章程','张三'),(6,'17393144615','123456','男',22,'浙江省宁波市西湖区','图片暂无',1,'赵云','张三'),(7,'17393144616','123456','男',19,'浙江省宁波市西湖区','图片暂无',1,'李牧','张三'),(8,'17393144617','123456','男',18,'浙江省宁波市西湖区','图片暂无',1,'陈鑫','张三'),(9,'17393144618','123456','男',30,'浙江省宁波市西湖区','图片暂无',1,'赵志伟','张三'),(10,'17393144619','123456','女',25,'浙江省宁波市西湖区','图片暂无',1,'张新','张三'),(11,'17393144620','123456','男',24,'浙江省宁波市西湖区','图片暂无',1,'刘承','张三'),(12,'17393144622','123456','女',26,'浙江省宁波市西湖区','图片暂无',1,'李四','张三'),(13,'17393144623','123456','男',27,'浙江省宁波市西湖区','图片暂无',1,'曾子宁','张三'),(14,'17393144624','123456','男',22,'浙江省宁波市西湖区','图片暂无',1,'廖静','张三'),(15,'17393144625','123456','男',23,'浙江省宁波市西湖区','图片暂无',1,'罗京','张三'),(16,'17393144633','123456','男',20,'浙江省宁波市西湖区','图片暂无',1,'陈伟','张三'),(17,'17393144627','123456','女',21,'浙江省宁波市西湖区','图片暂无',1,'刘安','张三'),(18,'17393144609','123456','男',19,'浙江省宁波市西湖区','图片暂无',1,'刘欣','张三'),(19,'17393144603','123456','男',18,'浙江+\"省\"宁波+\"市\"西湖+\"区\"','图片暂无',1,'赵飞','张三'),(20,'17393144601','123456','女',26,'浙江省宁波市西湖区','图片暂无',1,'张子益','张三'),(21,'15626536498','123456','女',18,'浙江省宁波市西湖区','图片暂无',1,'张欣欣','张三'),(22,'15246959862','123456','男',20,'浙江省杭州市西湖区','图片暂无',1,'王海涛','张三'),(47,'17393144312','1234','男',20,'浙江省','/upload/1572436384317.png',1,'龚凡','张三');

/*Table structure for table `managerpluslist` */

DROP TABLE IF EXISTS `managerpluslist`;

CREATE TABLE `managerpluslist` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_code` varchar(4) DEFAULT NULL,
  `m_psw` varchar(6) DEFAULT NULL,
  `m_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `managerpluslist` */

insert  into `managerpluslist`(`m_id`,`m_code`,`m_psw`,`m_name`) values (1,'1111','111111','李正');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_type` varchar(20) DEFAULT NULL,
  `n_head` varchar(40) DEFAULT NULL,
  `n_body` varchar(200) DEFAULT NULL,
  `n_date` date DEFAULT NULL,
  `n_time` time DEFAULT NULL,
  `n_set` varchar(20) DEFAULT NULL,
  `n_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`n_id`,`n_type`,`n_head`,`n_body`,`n_date`,`n_time`,`n_set`,`n_staus`) values (1,'政治','中美贸易','*****************************************','2019-07-02','18:10:37','章程',1),(2,'经济','****','********************','2019-07-06','13:53:21','章程',1),(3,'生活','四川暴雨','*******','2019-07-06','15:34:28','张新',1),(4,'文化','r仁寿暴雨','@#￥%……&*（）——+','2019-08-06','15:08:49','龚凡',1),(5,'经济','汪洋受灾','**********','2019-08-06','15:08:58','章程',1);

/*Table structure for table `provice` */

DROP TABLE IF EXISTS `provice`;

CREATE TABLE `provice` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `provice` */

insert  into `provice`(`p_id`,`p_name`) values (1,'四川省'),(2,'云南省'),(3,'贵州省');

/*Table structure for table `street` */

DROP TABLE IF EXISTS `street`;

CREATE TABLE `street` (
  `c_id` int(11) DEFAULT NULL,
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `street` */

insert  into `street`(`c_id`,`s_id`,`s_name`) values (1,1,'武侯区'),(1,2,'青羊区'),(1,3,'高新区'),(1,4,'天府新区'),(2,5,'高坪区'),(2,6,'嘉陵区'),(3,7,'彭山区'),(3,8,'东坡区'),(3,9,'仁寿县'),(4,10,'沙湾区'),(4,11,'五通桥区'),(5,12,'仁和区'),(5,13,'东区'),(5,14,'西区'),(6,15,'呈贡区'),(6,16,'官渡区'),(6,17,'盘龙区'),(7,18,'下关镇'),(7,19,'大理镇'),(7,20,'凤仪镇'),(8,21,'古城区'),(8,22,'永胜县'),(9,23,'南明区'),(9,24,'云岩区'),(9,25,'花溪区'),(10,26,'七星关区'),(10,27,'大方县'),(10,28,'金沙县'),(11,29,'钟山区'),(11,30,'六枝特区'),(11,31,'水城县');

/*Table structure for table `text` */

DROP TABLE IF EXISTS `text`;

CREATE TABLE `text` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_type` varchar(20) DEFAULT NULL,
  `t_head` varchar(40) DEFAULT NULL,
  `t_body` varchar(200) DEFAULT NULL,
  `t_date` date DEFAULT NULL,
  `t_time` time DEFAULT NULL,
  `t_set` varchar(20) DEFAULT NULL,
  `t_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `text` */

insert  into `text`(`t_id`,`t_type`,`t_head`,`t_body`,`t_date`,`t_time`,`t_set`,`t_staus`) values (1,'生活','新年快乐','********','2019-08-06','16:00:16','程毅阳',1),(2,'生活','元旦快乐','###########','2019-08-06','16:00:16','程毅阳',1),(3,'政治','国庆阅兵','###########','2019-08-06','16:00:16','程毅阳',1),(4,'军事','我国第一艘航母下海','@@@@@@@@@@@','2019-08-06','16:00:16','程毅阳',1),(5,'文化','仁寿竹编艺术','@@@@@@@@@@@','2019-08-06','16:00:16','程毅阳',1),(6,'科技','人工智能大会展开幕','@@@@@@@@@@@','2019-08-06','16:00:16','程毅阳',1),(7,'军事','王者荣耀','234567890','2019-08-06','16:17:38','程毅阳',1),(8,'山东省','','','2019-08-07','10:53:11','程毅阳',0);

/*Table structure for table `userlist` */

DROP TABLE IF EXISTS `userlist`;

CREATE TABLE `userlist` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_code` varchar(4) DEFAULT NULL,
  `u_psw` varchar(6) DEFAULT NULL,
  `u_name` varchar(20) DEFAULT NULL,
  `u_sex` char(2) DEFAULT NULL,
  `u_date` date DEFAULT NULL,
  `u_image` varchar(50) DEFAULT NULL,
  `u_num` varchar(11) DEFAULT NULL,
  `u_address` varchar(20) DEFAULT NULL,
  `u_chicek` varchar(20) DEFAULT NULL,
  `u_set` varchar(20) DEFAULT NULL,
  `u_settime` varchar(20) DEFAULT NULL,
  `u_staus` int(11) DEFAULT '1',
  `u_remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `userlist` */

insert  into `userlist`(`u_id`,`u_code`,`u_psw`,`u_name`,`u_sex`,`u_date`,`u_image`,`u_num`,`u_address`,`u_chicek`,`u_set`,`u_settime`,`u_staus`,`u_remarks`) values (1,'9413','tt2P6f','程毅阳','女','1999-08-06','15650794517038572.jpg','15283746902','四川省成都市武侯区','3级','李正','2019-8-6  16:17:17',1,NULL),(2,'0815','I63lDr','赵睿','女','2001-07-06','15650767429489938.jpg','15698656425','云南省昆明市呈贡区','1级','张新','2019-8-6',1,NULL),(3,'0456','KLPSyy','刘商','女','2019-07-06','15650768229073140.jpg','15198092451','四川省眉山市彭山区','1级','张新','2019-8-6',1,NULL),(4,'5295','Lu8ClI','李欣欣','女','2000-07-06','1565076857738297.jpg','15283746902','云南省昆明市呈贡区','1级','张新','2019-8-6',1,NULL),(5,'0405','8pE1Hx','张阳','女','1996-07-06','15650769746148626.gif','15626354895','云南省昆明市官渡区','5级','李正','2019-8-6  16:7:25',1,NULL),(6,'8721','wVShL3','程玮','女','1998-07-06','15650770143346346.jpg','15689456132','四川省南充市高坪区','3级','李正','2019-8-6  16:13:9',1,'1'),(7,'9898','4S01p3','郑月','女','1990-07-30','15650770867762526.jpg','13265498765','四川省乐山市五通桥区','2级','李正','2019-8-6  16:5:25',1,NULL),(8,'7581','diwSyM','蒋鑫','女','2003-08-06','156507783001164.jpg','13156495623','四川省南充市高坪区','1级','龚凡','2019-8-6',1,NULL),(9,'3471','wv5VLu','陈艺','女','1999-08-06','1565078215083632.jpg','19146598456','四川省南充市嘉陵区','4级','李正','2019-8-6  16:6:4',1,NULL),(10,'3295','wRGBGP','张跃','女','2000-08-06','15650782487811490.jpg','13265498711','云南省丽江市古城区','1级','章程','2019-8-6',1,NULL),(11,'7618','as0Xpq','张成','女','1999-08-06','15650782885244967.jpg','15246956325','贵州省六盘水市六枝特区','2级','李正','2019-8-6  16:6:33',1,NULL),(12,'0256','bPygoE','陈志龙','女','2002-08-06','15650783298094838.gif','15489652364','贵州省毕节市大方县','5级','李正','2019-8-6  16:6:4',1,NULL),(13,'8210','Dc17Jl','刘瑜','女','2002-08-03','15650793404729394.jpg','15198092451','云南省大理市大理镇','1级','章程','2019-8-6',1,NULL),(14,'8432','rTKfkO','百度',NULL,NULL,NULL,'13265246321',NULL,'1级',NULL,NULL,1,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
