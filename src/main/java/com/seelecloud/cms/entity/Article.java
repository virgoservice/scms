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

	private int id;
	private String title;
	private String description;
	private String icon;
	private String frontCover;
	private String keyword;
	private int creatorId;
	private Date createTime;
	private Date publishTime;
	private int publisherId;
	private int type; // 类型是文章
	private int size;
	private String author; // 原作者
	private String source; // 来源(原创, 转载)
	private int channelId; //
	private int hint; // 点击量
	private int agree;
	private byte status; // 1 可用, 0不可用
	private boolean recommend; // true 推荐置顶, false不推荐

	public Article() {
		super();
	}

	public Article(int id, String title, String description, String icon,
			String frontCover, String keyword, int creatorId, Date createTime,
			Date publishTime, int publisherId, int type, int size,
			String author, String source, int channelId, int hint, int agree,
			byte status, boolean recommend) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.icon = icon;
		this.frontCover = frontCover;
		this.keyword = keyword;
		this.creatorId = creatorId;
		this.createTime = createTime;
		this.publishTime = publishTime;
		this.publisherId = publisherId;
		this.type = type;
		this.size = size;
		this.author = author;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
		return "Article [id=" + id + ", title=" + title + ", description="
				+ description + ", icon=" + icon + ", frontCover=" + frontCover
				+ ", keyword=" + keyword + ", creatorId=" + creatorId
				+ ", createTime=" + createTime + ", publishTime=" + publishTime
				+ ", publisherId=" + publisherId + ", type=" + type + ", size="
				+ size + ", author=" + author + ", source=" + source
				+ ", channelId=" + channelId + ", hint=" + hint + ", agree="
				+ agree + ", status=" + status + ", recommend=" + recommend
				+ "]";
	}

}
