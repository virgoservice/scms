/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.21-log : Database - db_scms
Organization:贵州塞拉科技有限公司
Url:http://www.seelecloud.com
Author:谭朝红
Email:ramostear@seelecloud.cn
Date:2016-08-19 11:10:20
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_scms` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `db_scms`;

/*Table structure for table `t_manager` */

DROP TABLE IF EXISTS `t_manager`;

CREATE TABLE `t_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `managername` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '管理员名称',
  `managernickname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '管理员别名',
  `password` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `roleid` int(11) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_manager` */

insert  into `t_manager`(`id`,`managername`,`managernickname`,`password`,`createtime`,`roleid`) values (2,'administrator','系统管理员','123456','2016-08-18 18:21:01',1);


/*
 * Table structure for table `t_app`
 */
DROP TABLE IF EXISTS `t_app`;

CREATE TABLE `t_app` (
   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '站点编号',
   `appName` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '站点名称',
   `appDescription` varchar(500) COLLATE utf8_bin NOT NULL COMMENT '站点描述',
   `appLogo` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '站点logo',
   `appkeyword` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '站点关键字',
   `appCopyright` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '版权信息',
   `appUrl` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '站点域名',
   `createTime` datetime DEFAULT NULL COMMENT '创建时间',
   `appManagerId` int(11) DEFAULT NULL COMMENT '站点创建者编号',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
