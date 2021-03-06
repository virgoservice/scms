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
 * @description: 栏目: 其下可以包含多个栏目, 文章, 媒体资源.
 * @author: vabo
 * @version:
 * @Datetime:2016年10月21日
 * @Email:
 */
public class Channel {
	
	/**
	 * 栏目的主键
	 */
	private int id;
	/**
	 *栏目的名称 
	 */
	private String title;
	/**
	 *栏目的描述
	 */
	private String description;
	/**
	 *栏目的图标
	 */
	private String icon;
	/**
	 *栏目标题处的封面
	 */
	private String frontCover;
	/**
	 *栏目的关键字
	 */
	private String keyword;
	/**
	 *栏目的创建者
	 */
	private int creatorId;
	/**
	 *栏目创建时间
	 */
	private Date createTime;
	/**
	 *栏目的发布时间
	 */
	private Date publishTime;
	/**
	 *栏目的发布id
	 */
	private int publisherId;
	/**
	 *栏目的类型
	 */
	private int type; // 栏目, 专题
	/**
	 *栏目的点击量
	 */
	private int hint;
	/**
	 *栏目的排列
	 */
	private int channelOrder; // 排列的优先顺序

	/**
	 *父类栏目Id
	 */
	private int parentId; // 方便逆向查找, 以及不同上层栏目下面包含同一栏目,(保留字段)
	/**
	 * 栏目的状态，1 可用, 0不可用
	 */
	private byte status; 
	/**
	 * 是否是推荐栏目， true 推荐, false不推荐
	 */
	private boolean recommend; 

	public Channel() {
	}
	
	public Channel(int id, String title, String description, String icon,
			String frontCover, String keyword, int creatorId, Date createTime,
			Date publishTime, int publisherId, int type, int hint,
			int channelOrder, int parentId, byte status, boolean recommend) {
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
		this.hint = hint;
		this.channelOrder = channelOrder;
		this.parentId = parentId;
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

	public int getHint() {
		return hint;
	}

	public void setHint(int hint) {
		this.hint = hint;
	}

	public int getChannelOrder() {
		return channelOrder;
	}
	
	public void setChannelOrder(int channelOrder) {
		this.channelOrder = channelOrder;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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
		return "Channel [id=" + id + ", title=" + title + ", description="
				+ description + ", icon=" + icon + ", frontCover=" + frontCover
				+ ", keyword=" + keyword + ", creatorId=" + creatorId
				+ ", createTime=" + createTime + ", publishTime=" + publishTime
				+ ", publisherId=" + publisherId + ", type=" + type + ", hint="
				+ hint + ", channelOrder=" + channelOrder + ", parentId="
				+ parentId + ", status=" + status + ", recommend=" + recommend
				+ "]";
	}

}
