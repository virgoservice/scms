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
  `status` int(11) NOT NULL COMMENT '管理员状态，1：启用，0：停用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_manager` */

insert  into `t_manager`(`id`,`managername`,`managernickname`,`password`,`createtime`,`roleid`,`parentid`,`status`) values (2,'administrator','系统管理员','123456','2015-10-27 17:44:37',1,0,1),(3,'siteAdmin','张云鹏','123456','2015-10-27 17:44:37',1,2,1),(4,'tomcat','Ramostear','123456','2016-09-19 17:41:55',0,2,1),(5,'virgotom','张九龄啊','123456','2016-09-19 17:45:57',0,2,0),(6,'abihu','吴邪','123456','2016-09-19 17:51:20',0,2,0);

/*Table structure for table `t_module` */

DROP TABLE IF EXISTS `t_module`;

CREATE TABLE `t_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块编号，自增长类型',
  `moduleName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '模块名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `parentId` int(11) NOT NULL COMMENT '父模块编号',
  `moduleUrl` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '模块访问路径',
  `moduleIcon` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '模块显示图标',
  `managerId` int(11) NOT NULL COMMENT '模块所属管理员编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_module` */

insert  into `t_module`(`id`,`moduleName`,`createTime`,`parentId`,`moduleUrl`,`moduleIcon`,`managerId`) values (6,'管理员管理',NULL,-1,'#','&#xe62d;',2),(7,'角色管理',NULL,6,'/admin/role/roleList','&#xe70d;',2),(8,'权限管理',NULL,6,'/admin/permission/permissionList','&#xe638;',2),(9,'管理员列表',NULL,6,'/admin/manager/managerList','&#xe62b;',2),(10,'系统管理',NULL,-1,'#','&#xe62e;',2),(11,'系统设置',NULL,10,'#','&#xe62e;',2),(12,'系统统计',NULL,-1,'#','&#xe61a;',2),(13,'折线图',NULL,12,'#','&#xe61a;',2),(14,'会员管理',NULL,-1,'#','&#xe60d;',2),(15,'会员列表',NULL,14,'#','&#xe60d;',2),(16,'会员积分',NULL,14,'#','&#xe60d;',2),(17,'评论管理',NULL,-1,'#','&#xe622;',2),(18,'产品管理',NULL,-1,'#','&#xe620;',2),(19,'图片管理',NULL,-1,'#','&#xe613;',2),(20,'资讯管理',NULL,-1,'#','&#xe616;',2),(21,'插件管理',NULL,-1,'#','&#xe654;',2),(22,'模板管理',NULL,-1,'#','&#xe6d2;',2),(23,'站点管理',NULL,-1,'#','&#xe62b;',2),(24,'AppInfo',NULL,23,'/admin/app/AppInfo','&#xe681;',2),(25,'模块管理',NULL,-1,'/module/moduleList','&#xe6c0;',2),(26,'模块管理',NULL,25,'/module/moduleList','&#xe6c4;',2);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `roleName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `managerId` int(11) DEFAULT NULL COMMENT '管理员编号',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(256) DEFAULT NULL COMMENT '角色描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`roleName`,`managerId`,`createTime`,`description`) values (1,'超级管理员',2,'2016-09-06 22:33:03','我就党'),(2,'兽人苦役',2,'2016-09-06 22:33:03','搬砖挖矿');

/*Table structure for table `t_rolemodule` */

DROP TABLE IF EXISTS `t_rolemodule`;

CREATE TABLE `t_rolemodule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色模块关联编号',
  `roleId` int(11) DEFAULT NULL COMMENT '角色编号',
  `moduleId` int(11) DEFAULT NULL COMMENT '模块编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_rolemodule` */

insert  into `t_rolemodule`(`id`,`roleId`,`moduleId`) values (1,1,6),(2,1,7),(3,1,8),(4,1,9),(5,1,10),(6,1,11),(7,1,12),(8,1,13),(9,1,14),(10,1,15),(11,1,16),(12,1,17),(13,1,18),(14,1,19),(15,1,20),(16,1,21),(17,1,22),(18,1,23),(23,1,24),(24,1,25),(25,1,26);


drop table if exists t_article;

drop table if exists t_articleContent;

drop table if exists t_channel;

drop table if exists t_channelContent;

drop table if exists t_comment;

drop table if exists t_contentType;

drop table if exists t_reply;

/*==============================================================*/
/* Table: t_article                                             */
/*==============================================================*/
create table t_article
(
   id                   int not null AUTO_INCREMENT,
   title                varchar(64),
   description          varchar(256),
   icon                 varchar(128),
   frontCover           varchar(128),
   keyword              varchar(128),
   creatorId            int,
   createTime           datetime,
   publishTime          datetime,
   publisherId          int,
   type                 int,
   size                 int,
   author               varchar(32),
   source               varchar(128),
   channelId            int,
   hint                 int,
   agree                int,
   status               bool,
   recommend            bool,
   primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

alter table t_article comment '文章实体, 必须通常属性(id,title.etc), 特殊属性(content,size,author,agree)';

/*==============================================================*/
/* Table: t_articleContent                                     */
/*==============================================================*/
create table t_articleContent
(
   id                   int not null,
   sectionNum           int,
   text                 varchar(2048)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table t_articleContent comment '所有文章的正文，分片存储。';

/*==============================================================*/
/* Table: t_channel                                             */
/*==============================================================*/
create table t_channel
(
   id                   int not null AUTO_INCREMENT,
   title                varchar(64),
   description          varchar(256),
   icon                 varchar(128),
   frontCover           varchar(128),
   keyword              varchar(128),
   creatorId            int,
   createTime           datetime,
   publishTime          datetime,
   publisherId          int,
   type                 int,
   hint                 int,
   channelOrder         int,
   parentId             int,
   status               bool,
   recommend            bool,
   primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

alter table t_channel comment '栏目实体，作为一个分类，其下可以包含其他栏目，或文章，媒体文件等';

/*==============================================================*/
/* Table: t_channelContent                                      */
/*==============================================================*/
create table t_channelContent
(
   id                   int not null,
   type                 int,
   contentId            int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_comment                                             */
/*==============================================================*/
create table t_comment
(
   id                   int not null AUTO_INCREMENT,
   type                 int,
   contentId            int,
   agree                int,
   replyCount           int,
   status               int,
   creatorId            int,
   createTime           datetime,
   text                 varchar(512),
   primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

alter table t_comment comment '内容的评论。';

/*==============================================================*/
/* Table: t_contentType                                         */
/*==============================================================*/
create table t_contentType
(
   id                   int not null AUTO_INCREMENT,
   name                 varchar(32),
   description          varchar(256),
   primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

alter table t_contentType comment '内容的类型，包括文章,多媒体文件(Audio,Media,Picture),栏目(Navigation)';

/*==============================================================*/
/* Table: t_reply                                               */
/*==============================================================*/
create table t_reply
(
   id                   int not null AUTO_INCREMENT,
   commentId            int,
   parentId             int,
   agree                int,
   replyCount			int,
   status               tinyint,
   creatorId            int,
   createTime           datetime,
   text                 varchar(512),
   primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

alter table t_reply comment '各个评论的回复，回复的回复。';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
