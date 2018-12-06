/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.6.39 : Database - epi_demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`epi_demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `epi_demo`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_author` varchar(100) DEFAULT NULL,
  `r_sort` varchar(100) DEFAULT NULL,
  `r_image` varchar(100) DEFAULT NULL,
  `r_content` text,
  `r_date` varchar(100) DEFAULT NULL,
  `r_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`r_id`,`r_author`,`r_sort`,`r_image`,`r_content`,`r_date`,`r_status`) values 
(17,'aaa','一卡通',NULL,NULL,'322332',NULL);

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `lr_id` int(11) NOT NULL AUTO_INCREMENT,
  `lr_name` varchar(100) DEFAULT NULL,
  `lr_date` varchar(100) DEFAULT NULL,
  `lr_content` varchar(300) DEFAULT NULL,
  `lr_for_name` varchar(100) DEFAULT NULL,
  `lr_for_words` varchar(100) DEFAULT NULL,
  `lr_for_reply` varchar(100) DEFAULT NULL,
  `lr_for_article_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `reply` */

insert  into `reply`(`lr_id`,`lr_name`,`lr_date`,`lr_content`,`lr_for_name`,`lr_for_words`,`lr_for_reply`,`lr_for_article_id`) values 
(23,'ccc','2018-12-05 11:35:45','fffffffffffffff','ccc','39','','9'),
(24,'apple','2018-12-05 11:38:42','留言','ccc','39','23','9');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_email` varchar(25) NOT NULL,
  `user_time` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_password`,`user_email`,`user_time`) values 
(1,'apple','12345','d0571d8b-@qq.com',NULL),
(98,'aaa','aaa','wd32323-@qq.com',NULL),
(99,'ccc','ccc','324324@qq.com','2018-11-28'),
(100,'123','123','21313232@qq.com','2018-12-03');

/*Table structure for table `words` */

DROP TABLE IF EXISTS `words`;

CREATE TABLE `words` (
  `lw_id` int(11) NOT NULL AUTO_INCREMENT,
  `lw_name` varchar(100) DEFAULT NULL,
  `lw_date` varchar(100) DEFAULT NULL,
  `lw_content` varchar(300) DEFAULT NULL,
  `lw_for_name` varchar(100) DEFAULT NULL,
  `lw_for_article_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lw_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `words` */

insert  into `words`(`lw_id`,`lw_name`,`lw_date`,`lw_content`,`lw_for_name`,`lw_for_article_id`) values 
(39,'ccc','2018-12-05 11:35:42','qqqqqqqqqqqqqqqqqqqq','aaa','9'),
(40,'123','2018-12-05 11:38:35','xxxxxxxxxxxxxx','aaa','9');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
