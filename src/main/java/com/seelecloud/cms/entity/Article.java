/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.entity;

import java.util.Date;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月21日
 * @Email:
 */
public class Article {

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
	private int creatorId;
	
	/**
	 * 文章原作者
	 */
	private String author;
	
	/**
	 * 文章创建时间
	 */
	private Date createTime;

	/**
	 * 文章发布时间
	 */
	private Date publishTime;

	/**
	 * 文章发布者(审核并发布)
	 */
	private int publisherId;

	/**
	 * 文章分类
	 */
	private int category;

	/**
	 * 文章的大小,单位 KB
	 */
	private int size;

	/**
	 * 文章来源, 原创还是转载自某处
	 */
	private String source;

	/**
	 * 文章绝对隶属栏目, 其他栏目可以引用
	 */
	private int channelId;

	/**
	 * 文章点击量
	 */
	private int hint;

	/**
	 * 点赞
	 */
	private int agree;

	/**
	 * 文章处于状态(已发布1, 停用0, 删除等)
	 */
	private byte status;

	/**
	 * 推荐true, 不推荐false
	 */
	private boolean recommend;

	public Article() {
		super();
	}

	public Article(int id, String title, String subtitle, String description,
			String frontCover, String keyword, int creatorId, Date createTime,
			Date publishTime, int publisherId, int category, int size,
			String author, String source, int channelId, int hint, int agree,
			byte status, boolean recommend) {
		super();
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.description = description;
		this.frontCover = frontCover;
		this.keyword = keyword;
		this.creatorId = creatorId;
		this.createTime = createTime;
		this.publishTime = publishTime;
		this.publisherId = publisherId;
		this.category = category;
		this.size = size;
		this.source = source;
		this.channelId = channelId;
		this.hint = hint;
		this.agree = agree;
		this.status = status;
		this.recommend = recommend;
	}

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

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public int getHint() {
		return hint;
	}

	public void setHint(int hint) {
		this.hint = hint;
	}

	public int getAgree() {
		return agree;
	}

	public void setAgree(int agree) {
		this.agree = agree;
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

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", subtitle="
				+ subtitle + ", description=" + description + ", frontCover="
				+ frontCover + ", keyword=" + keyword + ", creatorId="
				+ creatorId + ", author=" + author + ", createTime="
				+ createTime + ", publishTime=" + publishTime
				+ ", publisherId=" + publisherId + ", category=" + category
				+ ", size=" + size + ", source=" + source + ", channelId="
				+ channelId + ", hint=" + hint + ", agree=" + agree
				+ ", status=" + status + ", recommend=" + recommend + "]";
	}
}
