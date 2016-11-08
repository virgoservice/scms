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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `subtitle` varchar(64) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `frontCover` varchar(128) DEFAULT NULL,
  `keyword` varchar(128) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `publisherId` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `source` varchar(128) DEFAULT NULL,
  `channelId` int(11) DEFAULT NULL,
  `hint` int(11) DEFAULT NULL,
  `agree` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `recommend` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='文章实体, 必须通常属性(id,title.etc), 特殊属性(content,size,author,agree)';

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '校园天地,畅想未来', '校园天地', '校园百事通，试试我们的技术', null, null, '0', '2016-11-01 10:29:41', '2016-11-02 10:29:44', '0', '1', '张伟', '0', '', '0', '0', '0', '0', '1');
INSERT INTO `t_article` VALUES ('2', '校园广播天地', '校园广播', '广播正能量，传递爱心你我他', null, null, '0', '2016-11-02 10:29:48', '2016-11-03 10:29:51', '0', '0', '丽华', '0', '', '0', '0', '0', '1', '0');
INSERT INTO `t_article` VALUES ('3', 'csdn', '博客', 'CSDN深度IT技术博客,移动开发博客,Web前端博客', null, null, '0', '2016-11-07 17:16:57', null, '0', '0', null, '0', '', '0', '0', '0', '0', '0');
INSERT INTO `t_article` VALUES ('49', 'oracle', '甲骨文公司', '甲骨文公司，全称甲骨文股份有限公司(甲骨文软件系统有限公司)，是全球最大的企业级软件公司，总部位于美国加利福尼亚州的红木滩。', null, null, '0', '2016-11-07 17:14:14', null, '0', '0', null, '0', '百度百科', '8', '0', '0', '0', '0');
INSERT INTO `t_article` VALUES ('51', 'cms乖乖', '才描述', '的士国标vfgbg', null, null, '0', '2016-11-07 19:56:01', null, '0', '0', null, '0', '', '4', '0', '0', '0', '0');
INSERT INTO `t_article` VALUES ('52', '婆媳拌嘴儿子抢喝农药身亡 婆婆闻讯服毒自杀', '婆媳拌嘴儿子抢喝农药身亡', '婆媳拌嘴儿子抢喝农药身亡 婆婆闻讯服毒自杀....', null, null, '0', '2016-11-07 20:04:56', null, '0', '0', null, '0', '', '7', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `t_articlecontent`
-- ----------------------------
DROP TABLE IF EXISTS `t_articlecontent`;
CREATE TABLE `t_articlecontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sectionNum` int(11) DEFAULT NULL,
  `content` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='所有文章的正文，分片存储。';

-- ----------------------------
-- Records of t_articlecontent
-- ----------------------------
INSERT INTO `t_articlecontent` VALUES ('1', '0', '<p>&nbsp;&nbsp;&nbsp;&nbsp;百度（Nasdaq：BIDU），全球最大的中文搜索引擎、最大的中文网站。1999年底,身在美国硅谷的李彦宏看到了中国互联网及中文搜索引擎服务的巨大发展潜力，抱着技术改变世界的梦想，他毅然辞掉硅谷的高薪工作，携搜索引擎专利技术，于 2000年1月1日在中关村创建了百度公司。\r\n“百度”二字,来自于八百年前南宋词人辛弃疾的一句词：众里寻他千百度。这句话描述了词人对理想的执着追求。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;百度拥有数万名研发工程师，这是中国乃至全球最为优秀的技术团队。这支队伍掌握着世界上最为先进的搜索引擎技术，使百度成为中国掌握世界尖端科学核心技术的中国高科技企业，也使中国成为美国、俄罗斯、和韩国之外，全球仅有的4个拥有搜索引擎核心技术的国家之一。</p><p>&nbsp;</p><p><br/></p>');
INSERT INTO `t_articlecontent` VALUES ('2', '0', '<p><span style=\"color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 20.02px; background-color: rgb(255, 255, 255);\">甲骨文公司。。。</span></p>');
INSERT INTO `t_articlecontent` VALUES ('4', '0', '<p>千万千万的趣味的武器服务器而服务</p>');
INSERT INTO `t_articlecontent` VALUES ('5', '0', '<p><span class=\"ico ico_type_Original\" style=\"display: inline-block; width: 19px; height: 19px; margin: 0px 2px 0px 0px; vertical-align: middle; background: url(http://static.blog.csdn.net/images/ico_Original.gif) 0px 0px no-repeat;\"></span>&nbsp;</p><h1 style=\"margin: 0px; padding: 0px; display: inline; font-weight: normal; font-stretch: normal; font-size: 20px; vertical-align: middle;\"><span class=\"link_title\"><a href=\"http://blog.csdn.net/guguojin/article/details/6713244\" style=\"color: rgb(0, 0, 0); text-decoration: none;\">Java保存yyyy-MM-dd HH:mm:ss日期字符串到 oracle date类型字段[原]</a></span></h1><p><span class=\"link_categories\" style=\"margin: 0px 5px; float: left;\">标签：&nbsp;<a href=\"http://www.csdn.net/tag/date\" target=\"_blank\" style=\"color: rgb(51, 102, 153); text-decoration: none; display: inline-block; margin-right: 10px;\">date</a><a href=\"http://www.csdn.net/tag/oracle\" target=\"_blank\" style=\"color: rgb(51, 102, 153); text-decoration: none; display: inline-block; margin-right: 10px;\">oracle</a><a href=\"http://www.csdn.net/tag/java\" target=\"_blank\" style=\"color: rgb(51, 102, 153); text-decoration: none; display: inline-block; margin-right: 10px;\">java</a><a href=\"http://www.csdn.net/tag/sql\" target=\"_blank\" style=\"color: rgb(51, 102, 153); text-decoration: none; display: inline-block; margin-right: 10px;\">sql</a><a href=\"http://www.csdn.net/tag/insert\" target=\"_blank\" style=\"color: rgb(51, 102, 153); text-decoration: none; display: inline-block; margin-right: 10px;\">insert</a><a href=\"http://www.csdn.net/tag/function\" target=\"_blank\" style=\"color: rgb(51, 102, 153); text-decoration: none; display: inline-block; margin-right: 10px;\">function</a></span></p><p><span class=\"link_postdate\" style=\"margin: 0px 5px 0px 0px;\">2011-08-23 22:17</span>&nbsp;<span class=\"link_view\" style=\"margin: 0px 5px; padding: 0px 0px 0px 14px; background: url(http://static.blog.csdn.net/images/ico_view.png) 0% 50% no-repeat;\">12688人阅读</span>&nbsp;<span class=\"link_comments\" style=\"margin: 0px 5px; padding: 0px 0px 0px 14px; background: url(http://static.blog.csdn.net/images/ico_comm.png) 0% 50% no-repeat;\"><a href=\"http://blog.csdn.net/guguojin/article/details/6713244#comments\" style=\"color: rgb(51, 102, 153); text-decoration: none;\">评论</a>(0)</span>&nbsp;<span class=\"link_collect tracking-ad\" style=\"margin: 0px 5px;\"><a title=\"收藏\" target=\"_blank\" style=\"color: rgb(51, 102, 153);\">收藏</a></span>&nbsp;<span class=\"link_report\" style=\"margin: 0px 5px;\"><a href=\"http://blog.csdn.net/guguojin/article/details/6713244#report\" title=\"举报\" style=\"color: rgb(51, 102, 153); text-decoration: none;\">举报</a></span></p><p class=\"copyright_p\" style=\"height: 14px; line-height: 14px; border-left-style: solid; border-left-width: 3px; border-left-color: rgb(228, 28, 30); padding-left: 10px; color: rgb(102, 102, 102); font-size: 14px;\">版权声明：本文为博主原创文章，未经博主允许不得转载。</p><p><span style=\"color: rgb(51, 0, 51);\"><span style=\"background-color: rgb(255, 204, 204);\">+ &quot;&#39;,&#39;&quot;+ mytechnical + &quot;&#39;,TO_DATE(&#39;&quot;+mybirthday+&quot;&#39;,&#39;YYYY-MM-DD&#39;),&#39;&quot;+ myemail + &quot;&#39;,&#39;&quot;+ mytelephone<br/></span></span></p><p><span style=\"color: rgb(51, 0, 51);\"><span style=\"background-color: rgb(255, 204, 204);\"><br/></span></span></p><p><span style=\"color: rgb(51, 0, 51);\"><span style=\"background-color: rgb(255, 204, 204);\">TO_DATE(&#39;&#39;,&#39;&#39;)在SQL语句中不需要加‘’，但是为了获得变量必须用以上格式</span></span></p><p><span style=\"color: rgb(51, 0, 51);\">一、使用<a href=\"http://lib.csdn.net/base/oracle\" class=\"replace_word\" title=\"Oracle知识库\" target=\"_blank\" style=\"color: rgb(223, 52, 52); text-decoration: none; font-weight: bold;\">Oracle</a>函数：</span></p><p>TO_TIMESTAMP_TZ(&#39;2009-3-9 17:51:23.23 -05:00&#39;,&nbsp;&nbsp;&nbsp; &#39;YYYY-MM-D HH24:MI:SS.FF TZH:TZM&#39;)</p><p>TO_DATE(yourdate,&#39;YYYY-MM-D HH24:MI:SS&#39;);&nbsp;&nbsp;&nbsp; // 字符串转日期Date</p><p>T0_CHAR(yourdate,&#39;YYYY-MM-D HH24:MI:SS&#39;);&nbsp;&nbsp; // 日期Date转字符串</p><p>eg：</p><p>update t_fl_flownote set sendtime=TO_TIMESTAMP_TZ(&#39;2009-11-30 10:47:16&#39;,&#39;YYYY-MM-DD HH24:MI:SS&#39;)</p><p>二、转别人的日志</p><p><br/></p>');
INSERT INTO `t_articlecontent` VALUES ('6', '0', '<p>扬子晚报讯（记者 \r\n梅建明）11月5日上午，在南京浦口区盘城街道的一农场内，承包这处土地的一家人中，婆媳两人因琐事拌嘴，婆婆一气之下拿出一瓶农药要喝，被儿子抢下，并赌气服下。众人将其送往医院急救，无奈药量大毒性强，不治身亡。在家的母亲得知儿子的死讯后，趁人不注意，也服下一瓶农药。相隔两个多小时，母子双双身亡。</p><p>据介绍，相继被送往医院救治的母子两人，来自福建，一家人在浦口盘城一个农场内承包土地种菜。当天上午10点左右，因为家庭琐事，婆婆跟媳妇吵嘴，婆婆很生气，拿起家里存放的一瓶用于杀虫的农药要喝。此时，两边劝说的儿子徐某，两头受气，看到妈妈要喝农药，一把抢过来，并赌气说：“你喝农药死不如我喝死算了。”徐某把从妈妈手里抢下的农药仰头喝下。家里人见状赶紧喊人将他送往医院抢救。然而，由于徐某喝的农药毒性太大，中午12点多，徐某经抢救无效死亡。</p><p>当在家的妈妈得知儿子抢救无效死亡之后，不禁放声大哭。徐某的妈妈趁家里人一团慌乱，无人注意，再次拿起家里的一瓶农药喝下。家里人又赶紧将她送往医院抢救，但是徐某的妈妈也经抢救无效死亡。母子两人死亡前后仅相差两个小时。</p><p>据附近居民介绍，这一家人常年在当地租地种菜为生，与周围的人和睦相处。没想到发生这样的悲剧。</p><p>居民们称，徐某与妻子育有两个孩子，大的才三四岁，小的刚满2岁，才学会走路，而妻子又怀有四个多月的身孕。</p><p>目前，当地警方已经介入调查。</p><p><br/></p>');

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
) ENGINE=InnoDB AUTO_INCREMENT=387 DEFAULT CHARSET=utf8 COMMENT='栏目实体，作为一个分类，其下可以包含其他栏目，或文章，媒体文件等';

-- ----------------------------
-- Records of t_channel
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='内容的类型，包括文章,多媒体文件(Audio,Media,Picture),栏目(Navigation)';

-- ----------------------------
-- Records of t_contenttype
-- ----------------------------
INSERT INTO `t_contenttype` VALUES ('1', '导航栏目', '首页顶部导航栏目');
INSERT INTO `t_contenttype` VALUES ('2', '文章列表栏目', '不同文章不同列表');
INSERT INTO `t_contenttype` VALUES ('3', '文章内容栏目', '不同内容的文章栏目');
INSERT INTO `t_contenttype` VALUES ('4', '最火栏目', '点击量最高的前几篇文章');

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
INSERT INTO `t_manager` VALUES ('0', 'administrator1', '系统管理员', '123456', '2015-10-27 17:44:37', '1', '0', '1');
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


/*Table structure for table `t_download` */

DROP TABLE IF EXISTS `t_download`;

CREATE TABLE `t_download` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resourceId` int(11) DEFAULT NULL,
  `channelId` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


/*Table structure for table `t_fileentity` */

DROP TABLE IF EXISTS `t_fileentity`;

CREATE TABLE `t_fileentity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
