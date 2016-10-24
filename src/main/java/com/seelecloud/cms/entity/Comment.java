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
 * @description: 文章/文件/专题 的评论
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class Comment {

	/**
	 * 编号
	 */
	private int id;

	/**
	 * 内容类型
	 */
	private int type;

	/**
	 * 内容id, 标识内容
	 */
	private int contentId;

	/**
	 * 点赞
	 */
	private int agree;

	/**
	 * 对当前评论的回复数量
	 */
	private int replyCount;

	/**
	 * 当前评论的状态
	 */
	private byte status;

	/**
	 * 创建人id
	 */
	private int creatorId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 当前评论的正文
	 */
	private String text;

	public Comment() {
		super();
	}

	public Comment(int id, int type, int contentId, int agree, int replyCount,
			byte status, int creatorId, Date createTime, String text) {
		super();
		this.id = id;
		this.type = type;
		this.contentId = contentId;
		this.agree = agree;
		this.replyCount = replyCount;
		this.status = status;
		this.creatorId = creatorId;
		this.createTime = createTime;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getAgree() {
		return agree;
	}

	public void setAgree(int agree) {
		this.agree = agree;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", type=" + type + ", contentId="
				+ contentId + ", agree=" + agree + ", replyCount=" + replyCount
				+ ", status=" + status + ", creatorId=" + creatorId
				+ ", createTime=" + createTime + ", text=" + text + "]";
	}

}
