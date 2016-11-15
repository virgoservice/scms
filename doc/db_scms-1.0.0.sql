/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : db_scms

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2016-11-07 20:18:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_app`
-- ----------------------------
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

-- ----------------------------
-- Records of t_app
-- ----------------------------
INSERT INTO `t_app` VALUES ('1', '贵州塞拉科技有限公司', '桃李云让教育变得更简单！', 'SeeleCloud', '云服务', '黔ICP备521254111号', 'http://www.seelecloud.com', '2016-08-23 09:37:13', '2');
INSERT INTO `t_app` VALUES ('2', '贵州塞拉科技有限公司s', '让教育变得更简单', 'SeeleCloud', '云服务', '黔ICP备521254111号', 'http://www.seelecloud.com', '2016-09-12 10:59:52', '2');

-- ----------------------------
-- Table structure for `t_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;

CREATE TABLE `t_article` (
  `uuid` varchar(32) NOT NULL,
  `title` varchar(64) DEFAULT NULL,
  `subtitle` varchar(64) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `frontCover` varchar(32) DEFAULT NULL,
  `keyword` varchar(128) DEFAULT NULL,
  `author` varchar(64) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `publisherId` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `source` varchar(128) DEFAULT NULL,
  `channelId` int(11) DEFAULT NULL,
  `hint` int(11) DEFAULT NULL,
  `agree` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `recommend` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章实体, 必须通常属性(id,title.etc), 特殊属性(content,size,author,agree)';

/*Data for the table `t_article` */

insert  into `t_article`(`uuid`,`title`,`subtitle`,`description`,`frontCover`,`keyword`,`author`,`creatorId`,`createTime`,`publishTime`,`publisherId`,`category`,`size`,`source`,`channelId`,`hint`,`agree`,`status`,`recommend`) values ('739d55dcb220439197e52cfd3c875852','title','sub title 2','hhhhhhh','66aeb5c759c44257a2a8489f5c03ba41','kw',NULL,0,'2016-11-15 11:57:04','2016-11-15 11:59:36',0,0,0,NULL,0,0,0,0,0);

/*Table structure for table `t_articlecontent` */

DROP TABLE IF EXISTS `t_articlecontent`;

CREATE TABLE `t_articlecontent` (
  `uuid` varchar(32) NOT NULL,
  `sectionNum` int(11) DEFAULT NULL,
  `content` longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='所有文章的正文，分片存储。';

/*Data for the table `t_articlecontent` */

insert  into `t_articlecontent`(`uuid`,`sectionNum`,`content`) values ('739d55dcb220439197e52cfd3c875852',2,'2this is a text 2'),('739d55dcb220439197e52cfd3c875852',1,'1this is a text 1'),('739d55dcb220439197e52cfd3c875852',0,'0this is a text 0'),('739d55dcb220439197e52cfd3c875852',-1,'-1this is a text -1');

/*Table structure for table `t_channel` */

DROP TABLE IF EXISTS `t_channel`;
CREATE TABLE `t_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `frontCover` varchar(128) DEFAULT NULL,
  `keyword` varchar(128) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `publisherId` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `hint` int(11) DEFAULT NULL,
  `channelOrder` int(11) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `recommend` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=387 DEFAULT CHARSET=utf8 COMMENT='栏目实体，作为一个分类，其下可以包含其他栏目，或文章，媒体文件等';

/*Data for the table `t_channel` */

INSERT INTO `t_channel` VALUES ('0', '网站内容管理栏目', null, null, null, null, null, null, null, null, '0', '12', '0', '-1', '0', '0');
INSERT INTO `t_channel` VALUES ('1', '校园趣味', null, null, null, null, null, null, null, null, '1', '231', '0', '0', '1', '1');
INSERT INTO `t_channel` VALUES ('2', '校园趣味1', null, null, null, null, null, null, null, null, '2', '32', '1', '1', '1', '0');
INSERT INTO `t_channel` VALUES ('3', '校园趣味2', null, null, null, null, null, null, null, null, '3', '12', '2', '1', '1', '0');
INSERT INTO `t_channel` VALUES ('4', '校园趣味3', null, null, null, null, null, null, null, null, '4', '23', '3', '1', '0', '1');
INSERT INTO `t_channel` VALUES ('5', '校园趣味4', null, null, null, null, null, null, null, null, '2', '343', '4', '1', '0', '0');
INSERT INTO `t_channel` VALUES ('6', '文化交流', null, null, null, null, null, null, null, null, '2', '343', '0', '0', '1', '0');
INSERT INTO `t_channel` VALUES ('7', '文化交流1', null, null, null, null, null, null, null, null, '3', '33', '1', '6', '1', '1');
INSERT INTO `t_channel` VALUES ('8', '文化交流2', null, null, null, null, null, null, null, null, '2', '22', '2', '6', '0', '0');
INSERT INTO `t_channel` VALUES ('9', '文化交流3', null, null, null, null, null, null, null, null, '3', '434', '3', '6', '1', '1');
INSERT INTO `t_channel` VALUES ('10', '文化交流4', null, null, null, null, null, null, null, null, '1', '54', '4', '6', '0', '0');
INSERT INTO `t_channel` VALUES ('11', '校园天地', null, null, null, null, '0', null, null, '0', '2', '56', '0', '0', '0', '0');
INSERT INTO `t_channel` VALUES ('12', '校园天地1', null, null, null, null, null, null, null, null, '4', '7687', '1', '11', '1', '0');
INSERT INTO `t_channel` VALUES ('13', '校园天地2', null, null, null, null, null, null, null, null, '2', '676', '2', '11', '0', '1');
INSERT INTO `t_channel` VALUES ('14', '校园天地3', null, null, null, null, null, null, null, null, '1', '7898', '3', '11', '1', '0');
INSERT INTO `t_channel` VALUES ('359', '娱乐说教', null, null, null, null, '0', null, null, '0', '2', '0', '0', '0', '1', '1');
INSERT INTO `t_channel` VALUES ('360', '校园天地4', null, null, null, null, '0', null, null, '0', '1', '0', '4', '11', '0', '0');
INSERT INTO `t_channel` VALUES ('361', '文化交流5', null, null, null, null, '0', null, null, '0', '1', '0', '5', '6', '0', '0');
INSERT INTO `t_channel` VALUES ('362', '世界太大1', null, null, null, null, '0', null, null, '0', '4', '0', '0', '0', '1', '1');
INSERT INTO `t_channel` VALUES ('363', '校园天地5', null, null, null, null, '0', null, null, '0', '1', '0', '5', '11', '0', '0');
INSERT INTO `t_channel` VALUES ('383', '5555', null, null, null, null, '0', null, null, '0', '1', '0', '1', '5', '1', '0');
INSERT INTO `t_channel` VALUES ('384', '吼吼吼', null, null, null, null, '0', null, null, '0', '4', '0', '0', '0', '0', '1');
INSERT INTO `t_channel` VALUES ('385', '我去看看', null, null, null, null, '0', null, null, '0', '4', '0', '1', '362', '0', '0');
INSERT INTO `t_channel` VALUES ('386', '执行主席1', null, null, null, null, '0', null, null, '0', '1', '0', '1', '384', '0', '0');


/*Table structure for table `t_channelcontent` */

DROP TABLE IF EXISTS `t_channelcontent`;

CREATE TABLE `t_channelcontent` (
  `id` int(11) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `contentId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_channelcontent` */

/*Table structure for table `t_channeltype` */

DROP TABLE IF EXISTS `t_channeltype`;

CREATE TABLE `t_channeltype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_channeltype` */

insert  into `t_channeltype`(`id`,`name`,`description`) values (1, '导航栏目', '首页顶部导航栏目'),(2,'文章列表栏目','不同文章不同列表'),(3,'文章内容栏目','不同内容的文章栏目'),(4,'最火栏目','点击量最高的前几篇文章');

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `contentId` int(11) DEFAULT NULL,
  `agree` int(11) DEFAULT NULL,
  `replyCount` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `text` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='内容的评论。';

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`type`,`contentId`,`agree`,`replyCount`,`status`,`creatorId`,`createTime`,`text`) values (1,2,1,34,0,1,4,NULL,'124634634ibfdfadsafdsaffd'),(2,2,1,6,0,1,3,NULL,'adf dsfds dsfasdfsdf'),(3,2,1,2,0,1,6,NULL,'ggggggggggggggggg'),(4,2,1,5,0,1,5,NULL,'(NUhhhhhhhhhhhhhhLL)'),(6,2,1,10,0,1,6,'2016-10-30 01:30:09','test null'),(7,2,1,10,0,1,6,'2016-10-30 01:31:55','test null'),(8,2,1,10,0,1,6,'2016-10-30 01:34:10','test null'),(9,0,0,0,0,0,0,NULL,NULL),(11,2,1,10,0,1,6,'2016-10-30 01:34:59','test null'),(12,0,0,0,0,0,0,NULL,NULL),(13,2,1,10,0,1,6,'2016-10-30 01:44:30','test null'),(14,2,1,10,0,1,6,'2016-10-30 01:44:30',NULL);

/*Table table `t_contenttype` has been discarded*/

DROP TABLE IF EXISTS `t_contenttype`;


-- ----------------------------
-- Table structure for `t_manager`
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES ('1', 'administrator1', '系统管理员', '123456', '2015-10-27 17:44:37', '1', '0', '1');
INSERT INTO `t_manager` VALUES ('2', 'Nisbc', 'Nisbc', '123456', '2016-11-03 17:09:48', '1', '2', '1');
INSERT INTO `t_manager` VALUES ('3', 'siteAdmin', '张云鹏', '123456', '2015-10-27 17:44:37', '1', '2', '1');
INSERT INTO `t_manager` VALUES ('4', 'tomcat', 'Ramostear', '123456', '2016-09-19 17:41:55', '0', '2', '1');
INSERT INTO `t_manager` VALUES ('5', 'virgotom', '张九龄', '123456', '2016-09-19 17:45:57', '0', '2', '0');
INSERT INTO `t_manager` VALUES ('6', 'abihu', '吴邪', '123456', '2016-09-19 17:51:20', '0', '2', '0');

-- ----------------------------
-- Table structure for `t_module`
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('6', '管理员管理', null, '-1', '#', '&#xe62d;', '2');
INSERT INTO `t_module` VALUES ('7', '角色管理', null, '6', '/admin/role/roleList', '&#xe70d;', '2');
INSERT INTO `t_module` VALUES ('8', '权限管理', null, '6', '/admin/permission/permissionList', '&#xe638;', '2');
INSERT INTO `t_module` VALUES ('9', '管理员列表', null, '6', '/admin/manager/managerList', '&#xe62b;', '2');
INSERT INTO `t_module` VALUES ('10', '系统管理', null, '-1', '#', '&#xe62e;', '2');
INSERT INTO `t_module` VALUES ('11', '系统设置', null, '10', '#', '&#xe62e;', '2');
INSERT INTO `t_module` VALUES ('12', '系统统计', null, '-1', '#', '&#xe61a;', '2');
INSERT INTO `t_module` VALUES ('13', '折线图', null, '12', '#', '&#xe61a;', '2');
INSERT INTO `t_module` VALUES ('14', '会员管理', null, '-1', '#', '&#xe60d;', '2');
INSERT INTO `t_module` VALUES ('15', '会员列表', null, '14', '#', '&#xe60d;', '2');
INSERT INTO `t_module` VALUES ('16', '会员积分', null, '14', '#', '&#xe60d;', '2');
INSERT INTO `t_module` VALUES ('17', '评论管理', null, '-1', '#', '&#xe622;', '2');
INSERT INTO `t_module` VALUES ('18', '产品管理', null, '-1', '#', '&#xe620;', '2');
INSERT INTO `t_module` VALUES ('19', '图片管理', null, '-1', '#', '&#xe613;', '2');
INSERT INTO `t_module` VALUES ('20', '资讯管理', null, '-1', '#', '&#xe616;', '2');
INSERT INTO `t_module` VALUES ('21', '插件管理', null, '-1', '#', '&#xe654;', '2');
INSERT INTO `t_module` VALUES ('22', '模板管理', null, '-1', '#', '&#xe6d2;', '2');
INSERT INTO `t_module` VALUES ('23', '站点管理', null, '-1', '#', '&#xe62b;', '2');
INSERT INTO `t_module` VALUES ('24', '站点信息', null, '23', '/admin/app/toAppInfo', '&#xe637;', '2');
INSERT INTO `t_module` VALUES ('25', '模块管理', null, '-1', '/module/moduleList', '&#xe6c0;', '2');
INSERT INTO `t_module` VALUES ('26', '模块管理', null, '25', '/module/moduleList', '&#xe6c4;', '2');
INSERT INTO `t_module` VALUES ('27', '内容管理', '2016-10-25 09:52:55', '-1', '#', '&#xe627;', '2');
INSERT INTO `t_module` VALUES ('28', '文章管理', null, '27', '/article/publicationArticleList', '&#xe623;', '2');
INSERT INTO `t_module` VALUES ('29', '栏目管理', null, '27', '/admin/content/channel', '&#xe60c;', '2');
INSERT INTO `t_module` VALUES ('30', '文件管理', null, '27', '/file/fileList', '&#xe60c;', '2');

-- ----------------------------
-- Table structure for `t_reply`
-- ----------------------------
DROP TABLE IF EXISTS `t_reply`;
CREATE TABLE `t_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commentId` int(11) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `agree` int(11) DEFAULT NULL,
  `replyCount` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `text` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='各个评论的回复，回复的回复。';

-- ----------------------------
-- Records of t_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `roleName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `managerId` int(11) DEFAULT NULL COMMENT '管理员编号',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '2', '2016-09-06 22:33:03', '管理所有管理员，权限最大');
INSERT INTO `t_role` VALUES ('2', '文章发布人员', '3', '2016-09-06 22:33:03', '只具备实现基础功能的权限');

-- ----------------------------
-- Table structure for `t_rolemodule`
-- ----------------------------
DROP TABLE IF EXISTS `t_rolemodule`;
CREATE TABLE `t_rolemodule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色模块关联编号',
  `roleId` int(11) DEFAULT NULL COMMENT '角色编号',
  `moduleId` int(11) DEFAULT NULL COMMENT '模块编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_rolemodule
-- ----------------------------
INSERT INTO `t_rolemodule` VALUES ('1', '1', '6');
INSERT INTO `t_rolemodule` VALUES ('2', '1', '7');
INSERT INTO `t_rolemodule` VALUES ('3', '1', '8');
INSERT INTO `t_rolemodule` VALUES ('4', '1', '9');
INSERT INTO `t_rolemodule` VALUES ('5', '1', '10');
INSERT INTO `t_rolemodule` VALUES ('6', '1', '11');
INSERT INTO `t_rolemodule` VALUES ('7', '1', '12');
INSERT INTO `t_rolemodule` VALUES ('8', '1', '13');
INSERT INTO `t_rolemodule` VALUES ('9', '1', '14');
INSERT INTO `t_rolemodule` VALUES ('10', '1', '15');
INSERT INTO `t_rolemodule` VALUES ('11', '1', '16');
INSERT INTO `t_rolemodule` VALUES ('12', '1', '17');
INSERT INTO `t_rolemodule` VALUES ('13', '1', '18');
INSERT INTO `t_rolemodule` VALUES ('14', '1', '19');
INSERT INTO `t_rolemodule` VALUES ('15', '1', '20');
INSERT INTO `t_rolemodule` VALUES ('16', '1', '21');
INSERT INTO `t_rolemodule` VALUES ('17', '1', '22');
INSERT INTO `t_rolemodule` VALUES ('18', '1', '23');
INSERT INTO `t_rolemodule` VALUES ('23', '1', '24');
INSERT INTO `t_rolemodule` VALUES ('24', '1', '25');
INSERT INTO `t_rolemodule` VALUES ('25', '1', '26');
INSERT INTO `t_rolemodule` VALUES ('26', '1', '27');
INSERT INTO `t_rolemodule` VALUES ('27', '1', '28');
INSERT INTO `t_rolemodule` VALUES ('28', '1', '29');
INSERT INTO `t_rolemodule` VALUES ('29', '1', '30');


/*Table structure for table `t_download` */

DROP TABLE IF EXISTS `t_download`;

CREATE TABLE `t_download` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resourceUuid` varchar(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_download` */

/*Table structure for table `t_fileentity` */

DROP TABLE IF EXISTS `t_fileentity`;

CREATE TABLE `t_fileentity` (
  `uuid` varchar(32) NOT NULL,
  `title` varchar(64) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `format` int(11) DEFAULT NULL,
  `keyword` varchar(128) DEFAULT NULL,
  `resourceUrl` varchar(128) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `publisherId` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `source` varchar(128) DEFAULT NULL,
  `channelId` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `recommend` tinyint(1) DEFAULT NULL,
  `permission` int(11) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_fileentity` */

insert  into `t_fileentity`(`uuid`,`title`,`description`,`format`,`keyword`,`resourceUrl`,`category`,`creatorId`,`createTime`,`publishTime`,`publisherId`,`size`,`source`,`channelId`,`status`,`recommend`,`permission`) values ('2888612f98614168956bd23802cce4bc',NULL,NULL,0,NULL,NULL,0,8,'1970-01-01 10:13:20',NULL,0,0,NULL,0,0,0,0),('44ef5b330a2f428b8cfc527f97145dac',NULL,NULL,0,NULL,NULL,0,0,'1970-01-01 08:00:00',NULL,0,0,NULL,0,0,0,0);

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
