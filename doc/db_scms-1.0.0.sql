/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : db_scms

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2016-10-25 21:25:12
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
  `size` int(11) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  `source` varchar(128) DEFAULT NULL,
  `channelId` int(11) DEFAULT NULL,
  `hint` int(11) DEFAULT NULL,
  `agree` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `recommend` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章实体, 必须通常属性(id,title.etc), 特殊属性(content,size,author,agree)';

-- ----------------------------
-- Records of t_article
-- ----------------------------

-- ----------------------------
-- Table structure for `t_articlecontent`
-- ----------------------------
DROP TABLE IF EXISTS `t_articlecontent`;
CREATE TABLE `t_articlecontent` (
  `id` int(11) NOT NULL,
  `sectionNum` int(11) DEFAULT NULL,
  `text` varchar(2048) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='所有文章的正文，分片存储。';

-- ----------------------------
-- Records of t_articlecontent
-- ----------------------------

-- ----------------------------
-- Table structure for `t_channel`
-- ----------------------------
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='栏目实体，作为一个分类，其下可以包含其他栏目，或文章，媒体文件等';

-- ----------------------------
-- Records of t_channel
-- ----------------------------

-- ----------------------------
-- Table structure for `t_channelcontent`
-- ----------------------------
DROP TABLE IF EXISTS `t_channelcontent`;
CREATE TABLE `t_channelcontent` (
  `id` int(11) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `contentId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_channelcontent
-- ----------------------------

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容的评论。';

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contenttype`
-- ----------------------------
DROP TABLE IF EXISTS `t_contenttype`;
CREATE TABLE `t_contenttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容的类型，包括文章,多媒体文件(Audio,Media,Picture),栏目(Navigation)';

-- ----------------------------
-- Records of t_contenttype
-- ----------------------------

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
INSERT INTO `t_manager` VALUES ('2', 'administrator', '系统管理员', '123456', '2015-10-27 17:44:37', '1', '0', '1');
INSERT INTO `t_manager` VALUES ('3', 'siteAdmin', '张云鹏', '123456', '2015-10-27 17:44:37', '1', '2', '1');
INSERT INTO `t_manager` VALUES ('4', 'tomcat', 'Ramostear', '123456', '2016-09-19 17:41:55', '0', '2', '1');
INSERT INTO `t_manager` VALUES ('5', 'virgotom', '张九龄啊', '123456', '2016-09-19 17:45:57', '0', '2', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `t_module` VALUES ('28', '文章管理', null, '27', '/admin/content/articleList', '&#xe623;', '2');
INSERT INTO `t_module` VALUES ('29', '栏目管理', null, '27', '/admin/content/channel', '&#xe60c;', '2');

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
INSERT INTO `t_role` VALUES ('1', '超级管理员', '2', '2016-09-06 22:33:03', '我就党');
INSERT INTO `t_role` VALUES ('2', '兽人苦役', '2', '2016-09-06 22:33:03', '搬砖挖矿');

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
