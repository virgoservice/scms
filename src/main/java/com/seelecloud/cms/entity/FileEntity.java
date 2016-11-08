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
 * @description: 文件属性实体, 用于对文件进行管理
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
public class FileEntity {

	/**
	 * 文件id,数据库主键
	 */
	private int id;

	/**
	 * 文件标题
	 */
	private String title;

	/**
	 * 文件描述
	 */
	private String description;

	/**
	 * 系统识别的文件格式
	 */
	private int format;

	/**
	 * 文件关键词, 用于检索
	 */
	private String keyword;

	/**
	 * 文件的存储地址
	 */
	private String resourceUrl;

	/**
	 * 文件归类, (按内容归类)
	 */
	private int category;

	/**
	 * 文件上传者
	 */
	private int creatorId;

	/**
	 * 文件上传时间
	 */
	private Date createTime;

	/**
	 * 文件发布时间
	 */
	private Date publishTime;

	/**
	 * 文件发布者(审核并发布)
	 */
	private int publisherId;

	/**
	 * 文件的大小,单位 KB
	 */
	private int size;

	/**
	 * 文件来源, 原创还是转载自某处
	 */
	private String source;

	/**
	 * 文件隶属栏目
	 */
	private int channelId;

	/**
	 * 文件处于状态(已发布1, 停用0, 已删除等)
	 */
	private byte status;

	/**
	 * 推荐true, 不推荐false
	 */
	private boolean recommend;

	/**
	 * 文件权限, 允许分享, 允许匿名下载等
	 */
	private int permission;

	public FileEntity() {
		super();
	}

	public FileEntity(int id, String title, String description, int format,
			String keyword, String resourceUrl, int category, int creatorId,
			Date createTime, Date publishTime, int publisherId, int size,
			String source, int channelId, byte status, boolean recommend,
			int permission) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.format = format;
		this.keyword = keyword;
		this.resourceUrl = resourceUrl;
		this.category = category;
		this.creatorId = creatorId;
		this.createTime = createTime;
		this.publishTime = publishTime;
		this.publisherId = publisherId;
		this.size = size;
		this.source = source;
		this.channelId = channelId;
		this.status = status;
		this.recommend = recommend;
		this.permission = permission;
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

	public int getFormat() {
		return format;
	}

	public void setFormat(int format) {
		this.format = format;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
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

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", title=" + title + ", description="
				+ description + ", format=" + format + ", keyword=" + keyword
				+ ", resourceUrl=" + resourceUrl + ", category=" + category
				+ ", creatorId=" + creatorId + ", createTime=" + createTime
				+ ", publishTime=" + publishTime + ", publisherId="
				+ publisherId + ", size=" + size + ", source=" + source
				+ ", channelId=" + channelId + ", status=" + status
				+ ", recommend=" + recommend + ", permission=" + permission
				+ "]";
	}

}
