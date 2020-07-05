/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - drivingschoolmanagementsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`drivingschoolmanagementsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `drivingschoolmanagementsystem`;

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `carnumber` varchar(8) DEFAULT NULL,
  `c_type` varchar(20) DEFAULT NULL,
  `c_name` varchar(20) DEFAULT NULL,
  `c_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `car` */

insert  into `car`(`c_id`,`carnumber`,`c_type`,`c_name`,`c_staus`) values (1,'甘A58462','C1','张欣欣',0),(2,'甘A58463','C1','赵梓阳',0),(3,'甘A58464','C1','陈强',0),(4,'甘A58465','C1','张欣',0),(5,'甘A58466','C2','李正',0),(6,'甘A58467','C1','李洋',0),(7,'甘A58468','B1','刘一举',0),(8,'甘A58469','B1','陈正阳',0),(9,'甘A58470','C1','张鑫',0),(10,'甘A58471','A1','刘强',0),(11,'甘A58472','A2','郑和',0),(12,'甘A58473','B1','李冰',0),(13,'甘A58474','C1','程心',0),(14,'川A58783','C2','曾欣雨',0),(15,'甘A33480','B2','程龙',0),(16,'甘A33481','B1','赵五',0),(17,'甘A33482','B2','刘鑫',0),(18,'甘A33483','B1','左强',0),(19,'甘A33484','A2','刘艳',0),(20,'甘A33485','A1','秦伟',0),(21,'甘A33486','B1','薛梓亿',0),(22,'甘A33487','C2','李毅',0),(23,'甘A33488','B1','李勇',0),(24,'甘A33489','0',NULL,0),(25,'甘A33490','B2','李强',0),(26,'甘A33491','C1','教练',0),(27,'甘A33492','0',NULL,1),(28,'甘A33493','0',NULL,1),(29,'甘A33494','0',NULL,1),(30,'甘A33495','0',NULL,1),(31,'甘A33496','0',NULL,1),(32,'甘A33497','0',NULL,1),(33,'甘A33498','0',NULL,1),(34,'甘A33499','0',NULL,1),(35,'川A58564','0','',1);

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  `cityName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`id`,`pro_id`,`cityName`) values (1,1,'成都市'),(2,1,'南充市'),(3,1,'眉山市'),(4,2,'兰州市'),(5,2,'平凉市'),(6,2,'天水市');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(4) DEFAULT NULL,
  `s_name` varchar(20) DEFAULT NULL,
  `c_stage` varchar(20) DEFAULT NULL,
  `t_name` varchar(20) DEFAULT NULL,
  `car_number` varchar(20) DEFAULT NULL,
  `c_date` varchar(20) DEFAULT NULL,
  `c_time` varchar(20) DEFAULT NULL,
  `setname` varchar(20) DEFAULT NULL,
  `c_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`c_id`,`s_code`,`s_name`,`c_stage`,`t_name`,`car_number`,`c_date`,`c_time`,`setname`,`c_staus`) values (1,'3254','张三','科目二','赵梓阳','甘A58463','2019-7-8','9:00——12:00','张三',1),(2,'9997','陈艺','科目二','赵梓阳','甘A58463','2019-7-8','9:00——12:00','张无极',1),(3,'4446','金龙','科目二','赵梓阳','甘A58463','2019-7-8','9:00——12:00','张无极',1),(4,'8789','张益阳','科目二','赵梓阳','甘A58463','2019-7-8','14:00——17:00','张无极',1),(6,'6026','程欣','科目二','李正','甘A58466','2019-7-15','9:00——12:00','张三',1),(7,'6026','程欣','科目二','李正','甘A58466','2019-7-16','9:00——12:00','张无极',1),(8,'7407','李四','科目二','刘强','甘A58471','2019-7-14','9:00——12:00','王瑾',1),(9,'7407','李四','科目二','刘强','甘A58471','2019-7-17','14:00——17:00','张无极',1),(10,'3150','赵武','科目二','刘鑫','甘A33482','2019-7-15','9:00——12:00','王瑾',1),(11,'3150','赵武','科目二','刘鑫','甘A33482','2019-7-16','9:00——12:00','张无极',1),(12,'4734','刘强','科目二','郑和','甘A58472','2019-7-12','9:00——12:00','张无极',1),(13,'9565','刘成','科目二','陈正阳','甘A58469','2019-7-14','9:00——12:00','张无极',1),(14,'4734','刘强','科目二','郑和','甘A58472','2019-7-13','9:00——12:00','张无极',1),(15,'3254','张三','科目三','李洋','甘A58467','2019-7-10','9:00——12:00','张无极',1),(16,'1658','张速度','科目一','***','***','2019-7-16','8:00——11:00','张无极',1),(17,'1658','张速度','科目一','***','***','2019-7-15','8:00——11:00','张无极',1),(18,'1658','张速度','科目一','***','***','2019-7-15','8:00——11:00','王瑾',1),(19,'3254','张三','科目三','李洋','甘A58467','2019-7-18','9:00——12:00','张无极',1);

/*Table structure for table `dep` */

DROP TABLE IF EXISTS `dep`;

CREATE TABLE `dep` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(20) DEFAULT NULL,
  `d_function` varchar(20) DEFAULT NULL,
  `d_remarks` varchar(20) DEFAULT NULL,
  `d_leader` varchar(20) DEFAULT NULL,
  `d_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `dep` */

insert  into `dep`(`d_id`,`d_name`,`d_function`,`d_remarks`,`d_leader`,`d_staus`) values (1,'财务部','收入、支出','张三,李四,王五','张三',1),(2,'客户服务部','学员注册与注销','刘一,赵四','刘一',1),(3,'组织部','考试预约、学车预约、教练调动','张无极,王瑾','张无极',1),(4,'车辆管理部门','管理车辆','程城,刘瑜,赵高','程城',1);

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(4) DEFAULT NULL,
  `s_name` varchar(20) DEFAULT NULL,
  `s_stage1` int(11) DEFAULT '0',
  `s_stage2` int(11) DEFAULT '0',
  `s_stage3` int(11) DEFAULT '0',
  `s_stage4` int(11) DEFAULT '0',
  `t_name` varchar(20) DEFAULT NULL,
  `g_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `grade` */

insert  into `grade`(`g_id`,`s_code`,`s_name`,`s_stage1`,`s_stage2`,`s_stage3`,`s_stage4`,`t_name`,`g_staus`) values (1,'3254','张三',90,100,0,0,'赵梓阳',1),(2,'9997','陈益',90,90,0,0,'赵梓阳',1),(3,'4446','金龙',98,80,0,0,'赵梓阳',1),(4,'8789','张益阳',91,92,0,0,'赵梓阳',1),(5,'6026','程欣',90,0,0,0,'李正',1),(7,'7407','李四',92,90,0,0,'刘强',1),(10,'3150','赵武',95,0,0,0,'刘鑫',1),(11,'4734','刘强',98,0,0,0,'郑和',1),(12,'9565','刘成',96,0,0,0,'陈正阳',1),(13,'1658','张速度',85,0,0,0,'***',1);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `l_code` varchar(20) DEFAULT NULL,
  `l_psw` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `login` */

insert  into `login`(`id`,`l_code`,`l_psw`) values (1,'gdfhsd','684902'),(2,'158855855','684902'),(3,'123455555','684902555');

/*Table structure for table `loginlist` */

DROP TABLE IF EXISTS `loginlist`;

CREATE TABLE `loginlist` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT,
  `l_code` varchar(4) DEFAULT NULL,
  `l_name` varchar(20) DEFAULT NULL,
  `l_psw` varchar(6) DEFAULT NULL,
  `l_power` varchar(11) DEFAULT NULL,
  `l_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `loginlist` */

insert  into `loginlist`(`l_id`,`l_code`,`l_name`,`l_psw`,`l_power`,`l_staus`) values (1,'1234','龚凡','684902','超级管理员',1),(2,'8379','张三','9icZOe','管理员',1),(3,'3388','李四','Q1cPwi','管理员',1),(4,'9873','王五','0LfFtx','管理员',1),(5,'5421','刘一','UqeMbP','管理员',1),(6,'7562','赵高','UtlVoq','管理员',1),(7,'7311','赵四','aPJOld','管理员',1),(8,'2213','张无忌','5uZMg5','管理员',1),(9,'7096','王瑾','8DxnUS','管理员',1),(10,'6729','程城','RAPZ6c','管理员',1),(11,'6352','刘瑜','Ah1gWf','管理员',1),(12,'8395','管理员','jlzI75','管理员',0);

/*Table structure for table `pay` */

DROP TABLE IF EXISTS `pay`;

CREATE TABLE `pay` (
  `p_code` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) DEFAULT NULL,
  `p_type` varchar(20) DEFAULT NULL,
  `p_amount` int(11) DEFAULT NULL,
  `p_remarks` varchar(100) DEFAULT NULL,
  `p_staus` int(11) DEFAULT '1',
  `p_name` varchar(20) DEFAULT NULL,
  `s_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`p_code`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `pay` */

insert  into `pay`(`p_code`,`s_name`,`p_type`,`p_amount`,`p_remarks`,`p_staus`,`p_name`,`s_code`) values (1,'张三','C1',5000,'2019-07-07',1,'张三',3254),(2,'李四','A1',15000,'2019-07-07',1,'李四',7407),(3,'赵武','B2',10000,'2019-07-07',1,'张三',3150),(4,'刘强','A2',12000,'2019-07-07',1,'张三',4734),(6,'张馨','B2',10000,'2019-07-08',1,'李四',3078),(7,'李言','A2',12000,'2019-07-08',1,'王五',844),(8,'程欣','C2',3000,'2019-07-08',1,'李四',6026),(9,'曾城','B2',10000,'2019-07-08',1,'王五',6340),(10,'刘成','B1',8000,'2019-07-08',1,'张三',9565),(11,'刘志伟','A2',12000,'2019-07-08',1,'李四',3270),(12,'赵紫阳','A1',15000,'2019-07-08',1,'李四',4905),(13,'成龙','C1',5000,'2019-07-08',1,'李四',6656),(14,'刘燕','B1',8000,'2019-07-08',1,'张三',5951),(15,'陈艺','C1',5000,'2019-07-08',1,'张三',9997),(16,'金龙','C1',5000,'2019-07-08',1,'王五',4446),(17,'张志伟','B1',8000,'2019-07-08',1,'李四',648),(18,'李阳','C1',5000,'2019-07-08',1,'李四',9219),(19,'郑勇','B1',8000,'2019-07-08',1,'李四',7076),(20,'张益阳','C1',5000,'2019-07-08',1,'李四',8789),(21,'陈奇','C1',5000,'2019-07-08',1,'张三',9765),(22,'张速度','C1',5000,'2019-7-10',1,'张三',1658),(23,'龚凡','A1',15000,'VIP     2019-07-14',1,'张三',9825),(25,'龚运','C1',5000,'2019-8-8',1,'张三',2300);

/*Table structure for table `provice` */

DROP TABLE IF EXISTS `provice`;

CREATE TABLE `provice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `provice` */

insert  into `provice`(`id`,`proName`) values (1,'四川省'),(2,'甘肃省');

/*Table structure for table `stage` */

DROP TABLE IF EXISTS `stage`;

CREATE TABLE `stage` (
  `s_code` int(11) NOT NULL AUTO_INCREMENT,
  `stage` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`s_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `stage` */

insert  into `stage`(`s_code`,`stage`) values (1,'科目二'),(2,'科目三');

/*Table structure for table `street` */

DROP TABLE IF EXISTS `street`;

CREATE TABLE `street` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) DEFAULT NULL,
  `streetName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `street` */

insert  into `street`(`id`,`city_id`,`streetName`) values (1,1,'武侯区'),(2,1,'青羊区'),(3,1,'高新区'),(4,1,'成华区'),(5,4,'安宁区'),(6,4,'西固区'),(7,4,'城关区'),(8,3,'东坡区'),(9,3,'彭山区'),(10,2,'高坪区'),(11,2,'嘉陵区'),(12,5,'崆峒区'),(13,6,'麦积区'),(14,6,'秦州区');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(4) DEFAULT NULL,
  `s_psw` varchar(6) DEFAULT NULL,
  `s_name` varchar(20) DEFAULT NULL,
  `s_sex` varchar(2) DEFAULT NULL,
  `s_date` varchar(12) DEFAULT NULL,
  `s_pnum` varchar(11) DEFAULT NULL,
  `s_address` varchar(20) DEFAULT NULL,
  `s_stage1` int(11) DEFAULT '0',
  `s_stage2` int(11) DEFAULT '0',
  `s_stage3` int(11) DEFAULT '0',
  `s_stage4` int(11) DEFAULT '0',
  `s_type` varchar(20) DEFAULT NULL,
  `s_imag` varchar(100) DEFAULT NULL,
  `setname` varchar(20) DEFAULT NULL,
  `s_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`s_id`,`s_code`,`s_psw`,`s_name`,`s_sex`,`s_date`,`s_pnum`,`s_address`,`s_stage1`,`s_stage2`,`s_stage3`,`s_stage4`,`s_type`,`s_imag`,`setname`,`s_staus`) values (1,'3254','123456','张三','男','2000-5-7','15198082451','成都市青羊区',90,100,0,0,'C1','15624816457061174.jpg','赵四',1),(2,'7407','mF0vyv','李四','男','1996-5-7','18228921405','南充市嘉陵区',92,90,0,0,'A1','15624816887715253.jpg','赵四',1),(3,'3150','VojATw','赵武','男','1998-9-7','15888959624','南充市嘉陵区',95,0,0,0,'B2','15624817921113802.jpg','刘一',1),(4,'4734','yPVO2x','刘强','男','2019-7-10','15283746902','成都市高新区',98,0,0,0,'A2','15627399902819782.gif','刘一',1),(5,'3078','ZLQQvT','张馨','女','1999-7-20','13889656241','兰州市安宁区',0,0,0,0,'B2','15624818897694151.jpg','刘一',1),(6,'0844','V0jFrJ','李言','女','2001-7-10','13285692654','南充市高坪区',0,0,0,0,'A2','15624909071028992.jpg','赵四',1),(7,'6026','yUNZxe','程欣','女','1999-7-10','13558264512','成都市青羊区',90,0,0,0,'C2','15624819890013831.jpg','赵四',1),(8,'6340','Jy7I4U','曾城','男','1999-7-28','17393144312','南充市高坪区',0,0,0,0,'B2','15624821125019716.jpg','赵四',1),(9,'9565','kmY4ch','刘成','男','1988-7-21','17393144562','兰州市西固区',96,0,0,0,'B1','1562482159039257.jpg','刘一',1),(10,'3270','fhdyNR','刘志伟','男','1999-7-7','13688369758','眉山市彭山区',0,0,0,0,'A2','15624821969661683.gif','刘一',1),(11,'4905','DFBxhV','赵紫阳','男','1989-5-7','14745685925','成都市高新区',0,0,0,0,'A1','15624822312523845.jpg','刘一',1),(12,'6656','XphBS5','成龙','男','2000-3-7','13896563625','兰州市城关区',0,0,0,0,'C1','15624822724109410.gif','赵四',1),(13,'5951','6m7XpQ','刘燕','女','2001-5-10','15146953628','平凉市崆峒区',0,0,0,0,'B1','15624823198282857.jpg','刘一',1),(14,'9997','8pBF5x','陈艺','女','1988-12-25','18409499045','兰州市西固区',90,90,0,0,'C1','15624823927043352.jpg','赵四',1),(15,'4446','Rs6Cvw','金龙','男','1996-6-7','14795288555','天水市秦州区',98,80,0,0,'C1','15624824601123393.gif','赵四',1),(16,'0648','dydexE','张志伟','男','1994-4-27','13284956958','兰州市城关区',0,0,0,0,'B1','15624825024182902.jpg','刘一',1),(17,'9219','rmUJhk','李阳','男','1992-5-17','18749652653','南充市嘉陵区',0,0,0,0,'C1','15624825564706763.jpg','赵四',1),(18,'7076','hvvkIH','郑勇','男','1991-8-6','18396596482','眉山市彭山区',0,0,0,0,'B1','15624825960743084.jpg','赵四',1),(19,'8789','jyyiyB','张益阳','男','1998-9-9','17393475624','兰州市西固区',91,92,0,0,'C1','1562482642833198.jpg','刘一',1),(20,'9765','odCI21','陈奇','男','1997-4-23','13688596452','兰州市安宁区',0,0,0,0,'C1','15624827040288016.gif','刘一',1),(21,'9744','fIbTbS','刘仪伟','男','2000-7-9','18965324592','眉山市彭山区',0,0,0,0,'B2','15625718003788749.gif','刘一',1),(22,'5194','MHYrrk','刘成','男','1997-7-12','13265498732','兰州市西固区',0,0,0,0,'C1','15626376117719986.jpg','赵四',1),(23,'0523','5BpcoF','刘承','男','1998-6-18','15214636362','天水市秦州区',0,0,0,0,'A1','15626382340606611.gif','刘一',1),(24,'7846','ZEUKGZ','陈洁','女','1999-7-10','15145645645','成都市武侯区',0,0,0,0,'A1','1562739070327837.gif','刘一',1),(25,'9805','rE41Jj','丁亮','男','2000-7-10','18659263565','兰州市安宁区',0,0,0,0,'B1','15627401575124640.jpg','刘一',1),(26,'4914','QbH80d','刘庆','男','2001-7-10','15245669584','成都市武侯区',0,0,0,0,'A1','15627419855204004.gif','刘一',1),(27,'1658','rLYpIy','张速度','男','2000-7-11','18409493532','兰州市安宁区',85,0,0,0,'C1','15627534710241659.gif','',0),(28,'9825','l2g3tl','龚凡','男','2000-7-14','15283746902','兰州市安宁区',0,0,0,0,'A1','15630811814412386.jpg','赵四',1),(29,'2300','123456','龚运','男','2000-8-8','15283746902','眉山市彭山区',0,0,0,0,'C1','15652523119328396.jpg','刘一',1),(30,'8628','YGWHMV','程心','女','2001-5-28','17393144562','成都市武侯区',0,0,0,0,'B1','15775117529159789.jpg','刘一',1);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_code` int(11) DEFAULT NULL,
  `t_psw` varchar(6) DEFAULT NULL,
  `t_name` varchar(20) DEFAULT NULL,
  `t_sex` char(2) DEFAULT NULL,
  `t_age` int(11) DEFAULT NULL,
  `t_type` varchar(20) DEFAULT NULL,
  `t_pnum` varchar(11) DEFAULT NULL,
  `t_address` varchar(20) DEFAULT NULL,
  `t_image` varchar(100) DEFAULT NULL,
  `t_stage` varchar(10) DEFAULT NULL,
  `car_number` varchar(20) DEFAULT NULL,
  `setname` varchar(20) DEFAULT NULL,
  `t_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`t_id`,`t_code`,`t_psw`,`t_name`,`t_sex`,`t_age`,`t_type`,`t_pnum`,`t_address`,`t_image`,`t_stage`,`car_number`,`setname`,`t_staus`) values (1,8044,'ia70Do','赵梓阳','男',11,'C1','15283746902','四川省成都市青羊区','15624888801335599.jpg','科目二','甘A58463','张无极',1),(2,3061,'mJyXcz','陈强','男',12,'C1','13688369785','甘肃省兰州市安宁区','15624890776309433.gif','科目二','甘A58464','张无极',1),(3,1423,'4EWNoj','李艳','女',13,'C1','13259862654','甘肃省天水市麦积区','15624893124125778.gif','科目二','甘A58462','王瑾',1),(4,5599,'nkzFAf','张欣','女',12,'C1','18229565465','甘肃省天水市麦积区','15624894925711938.gif','科目二','甘A58465','张无极',1),(5,3036,'pGNhPa','李正','男',10,'C2','13256485264','甘肃省兰州市西固区','15624896511653081.gif','科目二','甘A58466','张无极',1),(6,3433,'XQg4XU','李洋','女',8,'C1','17393475968','甘肃省兰州市城关区','15624897060722466.jpg','科目三','甘A58467','王瑾',1),(7,6703,'01FUAc','刘一举','男',10,'B1','15198092451','四川省成都市青羊区','15624897844908941.jpg','科目二','甘A58468','王瑾',1),(8,8216,'VGZaYS','陈正阳','男',15,'B1','17393144312','甘肃省平凉市崆峒区','15624898440761641.jpg','科目二','甘A58469','张无极',1),(9,7985,'2Wvzcs','张鑫','男',12,'C1','15378648017','四川省眉山市彭山区','15624899048511401.gif','科目二','甘A58470','王瑾',1),(10,8589,'ZTBVvG','刘强','男',16,'A1','18759648635','四川省成都市武侯区','15624899757456205.gif','科目二','甘A58471','张无极',1),(11,8612,'dW4txd','郑和','男',18,'A2','14758269345','四川省南充市高坪区','15624900219024266.gif','科目二','甘A58472','张无极',1),(12,3339,'Yc1ldP','李冰','女',12,'B1','15198486589','甘肃省平凉市崆峒区','15624900747523104.gif','科目三','甘A58473','王瑾',1),(13,7229,'9YWAPr','程心','女',6,'C1','15283746906','四川省成都市青羊区','15624901532346681.jpg','科目三','甘A58474','王瑾',1),(14,9507,'sMYkfK','曾欣雨','女',8,'C2','18325694864','四川省眉山市东坡区','15624902049955593.gif','科目三','川A58783','王瑾',1),(15,3734,'s8bquf','程龙','男',12,'B2','15246986325','四川省成都市高新区','1562490265161537.gif','科目三','甘A33480','张无极',1),(16,3999,'Rc2vw1','赵五','男',10,'B1','18659469558','甘肃省平凉市崆峒区','15624903592203664.gif','科目三','甘A33481','张无极',1),(17,9347,'YHUn2L','刘鑫','男',15,'B2','15254556565','四川省南充市高坪区','15624904310517017.gif','科目二','甘A33482','张无极',1),(18,3372,'9sDBdk','左强','男',15,'B1','13688369597','甘肃省兰州市城关区','15624904832405035.gif','科目三','甘A33483','王瑾',1),(19,8362,'2KJL7E','刘艳','女',16,'A2','15269865978','甘肃省兰州市西固区','15624905390711322.gif','科目三','甘A33484','张无极',1),(20,1701,'NQFKE7','秦伟','男',15,'A1','13689956556','甘肃省兰州市城关区','15624906040756850.gif','科目三','甘A33485','王瑾',1),(21,9807,'0wK2Q5','薛梓亿','男',12,'B1','13256489658','甘肃省兰州市安宁区','15624906661569045.gif','科目二','甘A33486','张无极',1),(22,4429,'wMkYH0','李毅','男',11,'C2','13659865984','甘肃省平凉市崆峒区','15624907340084328.gif','科目三','甘A33487','张无极',1),(23,1995,'6DtYRT','李勇','男',16,'B1','13695684654','甘肃省兰州市西固区','15624907784532705.gif','科目三','甘A33488','张无极',1),(24,5371,'cI0Ero','李强','男',12,'B2','13695684562','四川省成都市青羊区','15625719316568053.jpg','科目二','甘A33490','张无极',1),(25,2270,'1Gs7ft','收到','男',12,'B1','15286489561','甘肃省兰州市城关区','15626406380232727.gif','科目三','甘A33491','张无极',0),(26,2270,'1Gs7ft','收','男',12,'B1','15286489561','甘肃省兰州市城关区','1562640651868699.gif','科目三','甘A33491','张无极',0),(27,2578,'KSBmZa','教练','女',18,'C1','15298469524','','15630813151413963.jpg','科目二','甘A33491','张无极',1);

/*Table structure for table `text1` */

DROP TABLE IF EXISTS `text1`;

CREATE TABLE `text1` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_code` varchar(4) DEFAULT NULL,
  `s_name` varchar(20) DEFAULT NULL,
  `t_type` varchar(20) DEFAULT NULL,
  `t_stage` varchar(20) DEFAULT NULL,
  `t_date` varchar(20) DEFAULT NULL,
  `t_time` varchar(20) DEFAULT NULL,
  `t_address` varchar(20) DEFAULT NULL,
  `setname` varchar(20) DEFAULT NULL,
  `t_staus` int(11) DEFAULT '1',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `text1` */

insert  into `text1`(`t_id`,`s_code`,`s_name`,`t_type`,`t_stage`,`t_date`,`t_time`,`t_address`,`setname`,`t_staus`) values (1,'3254','张三','C1','科目一','2019-7-9','14:00——17:00','成都市武侯区驾考中心','张无极',1),(2,'3254','张三','C1','科目二','2019-7-11','8:00——11:00','成都市武侯区驾考中心','张无极',1),(3,'9997','陈艺','C1','科目一','2019-7-9','14:00——17:00','兰州市西固区驾考中心','张无极',1),(4,'9997','陈艺','C1','科目二','2019-7-16','14:00——17:00','兰州市安宁区驾考中心','张无极',1),(5,'4446','金龙','C1','科目一','2019-7-10','14:00——17:00','天水市麦积区驾考中心','张无极',1),(6,'4446','金龙','C1','科目二','2019-7-16','14:00——17:00','天水市秦州区驾考中心','张无极',1),(7,'7407','李四','A1','科目一','2019-7-11','14:00——17:00','南充市嘉陵区驾考中心','张无极',1),(8,'7407','李四','A1','科目二','2019-7-20','14:00——17:00','南充市嘉陵区驾考中心','张无极',1),(9,'3150','赵武','B2','科目一','2019-7-10','8:00——11:00','南充市嘉陵区驾考中心','张无极',1),(10,'4734','刘强','A2','科目一','2019-7-12','8:00——11:00','成都市高新区驾考中心','张无极',1),(11,'9565','刘成','B1','科目一','2019-7-10','8:00——11:00','兰州市西固区驾考中心','张无极',1),(12,'6026','程欣','C2','科目一','2019-7-12','8:00——11:00','成都市青羊区驾考中心','张无极',1),(14,'1658','张速度','C1','科目一','2019-7-14','8:00——11:00','南充市高坪区驾考中心','张无极',1),(16,'1658','张速度','C1','科目一','2019-7-15','8:00——11:00','成都市武侯区驾考中心','王瑾',1),(17,'3254','张三','C1','科目三','2019-7-14','8:00——11:00','南充市嘉陵区驾考中心','张无极',1);

/*Table structure for table `type1` */

DROP TABLE IF EXISTS `type1`;

CREATE TABLE `type1` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `tp` varchar(20) DEFAULT NULL,
  `pay` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `type1` */

insert  into `type1`(`t_id`,`tp`,`pay`) values (1,'A1',15000),(2,'A2',12000),(3,'B2',10000),(4,'B1',8000),(5,'C1',5000),(6,'C2',3000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
