/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.21-log : Database - db_scms
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

/*Table structure for table `t_app` */

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_app` */

insert  into `t_app`(`id`,`appName`,`appDescription`,`appLogo`,`appkeyword`,`appCopyright`,`appUrl`,`createTime`,`appManagerId`) values (1,'贵州塞拉科技有限公司','桃李云让教育变得更简单！','SeeleCloud','云服务','黔ICP备521254111号','http://www.seelecloud.com','2016-08-23 09:37:13',2),(2,'贵州塞拉科技有限公司s','让教育变得更简单','SeeleCloud','云服务','黔ICP备521254111号','http://www.seelecloud.com','2016-09-12 10:59:52',2);

/*Table structure for table `t_manager` */

DROP TABLE IF EXISTS `t_manager`;

CREATE TABLE `t_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `managername` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '管理员名称',
  `managernickname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '管理员别名',
  `password` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `roleid` int(11) DEFAULT NULL COMMENT '角色编号',
  `parentid` int(11) NOT NULL COMMENT '父编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_manager` */

insert  into `t_manager`(`id`,`managername`,`managernickname`,`password`,`createtime`,`roleid`,`parentid`) values (2,'administrator','系统管理员','123456','2016-08-18 18:21:01',1,0);

/*Table structure for table `t_module` */

DROP TABLE IF EXISTS `t_module`;

CREATE TABLE `t_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块编号，自增长类型',
  `modelName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '模块名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `parentId` int(11) NOT NULL COMMENT '父模块编号',
  `modelUrl` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '模块访问路径',
  `modelIcon` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '模块显示图标',
  `managerId` int(11) NOT NULL COMMENT '模块所属管理员编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_module` */

insert  into `t_module`(`id`,`modelName`,`createTime`,`parentId`,`modelUrl`,`modelIcon`,`managerId`) values (6,'管理员管理',NULL,-1,'#','&#xe62d;',2),(7,'角色管理',NULL,6,'#','&#xe70d;',2),(8,'权限管理',NULL,6,'#','&#xe638;',2),(9,'管理员列表',NULL,6,'#','&#xe62b;',2),(10,'系统管理',NULL,-1,'#','&#xe62e;',2),(11,'系统设置',NULL,10,'#','&#xe62e;',2),(12,'系统统计',NULL,-1,'#','&#xe61a;',2),(13,'折线图',NULL,12,'#','&#xe61a;',2),(14,'会员管理',NULL,-1,'#','&#xe60d;',2),(15,'会员列表',NULL,14,'#','&#xe60d;',2),(16,'会员积分',NULL,14,'#','&#xe60d;',2),(17,'评论管理',NULL,-1,'#','&#xe622;',2),(18,'产品管理',NULL,-1,'#','&#xe620;',2),(19,'图片管理',NULL,-1,'#','&#xe613;',2),(20,'资讯管理',NULL,-1,'#','&#xe616;',2),(21,'插件管理',NULL,-1,'#','&#xe654;',2),(22,'模板管理',NULL,-1,'#','&#xe6d2;',2),(23,'站点管理',NULL,-1,'#','&#xe62b;',2);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `roleName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `managerId` int(11) DEFAULT NULL COMMENT '管理员编号',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`roleName`,`managerId`,`createTime`) values (1,'超级管理员',2,'2016-09-06 22:33:03');

/*Table structure for table `t_rolemodule` */

DROP TABLE IF EXISTS `t_rolemodule`;

CREATE TABLE `t_rolemodule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色模块关联编号',
  `roleId` int(11) DEFAULT NULL COMMENT '角色编号',
  `modelId` int(11) DEFAULT NULL COMMENT '模块编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_rolemodule` */

insert  into `t_rolemodule`(`id`,`roleId`,`modelId`) values (1,1,6),(2,1,7),(3,1,8),(4,1,9),(5,1,10),(6,1,11),(7,1,12),(8,1,13),(9,1,14),(10,1,15),(11,1,16),(12,1,17),(13,1,18),(14,1,19),(15,1,20),(16,1,21),(17,1,22),(18,1,23);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
