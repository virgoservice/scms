package com.seelecloud.cms.vo;

import java.util.Date;
import com.seelecloud.cms.entity.Article;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2016年11月4日 下午7:25:28  
 * @email:2411685663@qq.com 
 */
public class ArticleVo {
	/**
	 * 文章id,数据库主键
	 */
	private int id;

	/**
	 * 文章标题
	 */
	private String title;

	/**
	 * 文章副标题
	 */
	private String subtitle;

	/**
	 * 文章摘要描述
	 */
	private String description;

	/**
	 * 文章封面图片URL,默认为null
	 */
	private String frontCover;

	/**
	 * 文章关键词,用于检索
	 */
	private String keyword;

	/**
	 * 文章创建者
	 */
	private String creator;
	
	/**
	 * 文章创建者
	 */
	private Date createTime;
	
	/**
	 * 文章发布时间
	 */
	private Date publishTime;
	
	/**
	 * 文章栏目
	 */
	private String channelName;

	/**
	 * 文章发布者(审核并发布)
	 */
	private String publisher;

	/**
	 * 文章分类
	 */
	private int category;
	
	/**
	 * 文章来源, 原创还是转载自某处
	 */
	private String source;

	/**
	 * 文章绝对隶属栏目, 其他栏目可以引用
	 */
	private int channelId;
	
	/**
	 * 文章处于状态(已发布1, 停用0, 删除等)
	 */
	private byte status;

	/**
	 * 推荐true, 不推荐false
	 */
	private boolean recommend;
	
	/**
	 * 文章正文
	 */
	private String content;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFrontCover() {
		return frontCover;
	}

	public void setFrontCover(String frontCover) {
		this.frontCover = frontCover;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	public ArticleVo(int id, String title, String description,Date createTime,Date publishTime, String publisher, String channelName,
			byte status, boolean recommend) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createTime = createTime;
		this.publishTime = publishTime;
		this.publisher = publisher;
		this.channelName = channelName;
		this.status = status;
		this.recommend = recommend;
	}

	public ArticleVo() {
		super();
	}

	public ArticleVo(Article article,String publisher,String channelName,String content) {
		this.setId(article.getId());
		this.setTitle(article.getTitle());
		this.setChannelName(channelName);
		this.setSubtitle(article.getSubtitle());
		this.setDescription(article.getDescription());
		this.setSource(article.getSource());
		this.setPublisher(publisher);
		this.setRecommend(article.isRecommend());
		this.setStatus(article.getStatus());
		this.setContent(content);
	}

	@Override
	public String toString() {
		return "ArticleVo [id=" + id + ", title=" + title + ", subtitle="
				+ subtitle + ", description=" + description + ", frontCover="
				+ frontCover + ", keyword=" + keyword + ", creator=" + creator
				+ ", publishTime=" + publishTime + ", publisher=" + publisher
				+ ", category=" + category + ", source=" + source
				+ ", channelId=" + channelId + ", status=" + status
				+ ", recommend=" + recommend + ", content=" + content + "]";
	}
}
