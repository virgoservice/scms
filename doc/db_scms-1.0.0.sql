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

/*Table structure for table `t_model` */

DROP TABLE IF EXISTS `t_model`;

CREATE TABLE `t_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块编号，自增长类型',
  `modelName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '模块名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `parentId` int(11) NOT NULL COMMENT '父模块编号',
  `modelUrl` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '模块访问路径',
  `modelIcon` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '模块显示图标',
  `managerId` int(11) NOT NULL COMMENT '模块所属管理员编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_model` */

insert  into `t_model`(`id`,`modelName`,`createTime`,`parentId`,`modelUrl`,`modelIcon`,`managerId`) values (1,'用户管理','2016-09-12 10:59:56',-1,'#','&5147',2),(2,'权限管理',NULL,-1,'#','&5148',2),(3,'内容管理','2016-09-06 14:47:48',-1,'#','&5149',2),(4,'站点管理','2016-09-06 14:48:24',-1,'#','&5150',2),(5,'站点管理','2016-09-12 10:59:56',-1,'#','&5150',2);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `roleName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `managerId` int(11) DEFAULT NULL COMMENT '管理员编号',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`roleName`,`managerId`,`createTime`) values (1,'超级管理员',2,'2016-09-06 22:33:03'),(2,'超级管理员',2,'2016-09-12 10:59:58');

/*Table structure for table `t_rolemodel` */

DROP TABLE IF EXISTS `t_rolemodel`;

CREATE TABLE `t_rolemodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色模块关联编号',
  `roleId` int(11) DEFAULT NULL COMMENT '角色编号',
  `modelId` int(11) DEFAULT NULL COMMENT '模块编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_rolemodel` */

insert  into `t_rolemodel`(`id`,`roleId`,`modelId`) values (1,1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
