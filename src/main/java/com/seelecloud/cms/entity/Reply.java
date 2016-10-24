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
 * @description: 各个评论的回复
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class Reply {

	/**
	 * 编号
	 */
	private int id;

	/**
	 * 属于的评论
	 */
	private int commentId;

	/**
	 * 对回复的回复
	 */
	private int parentId;

	/**
	 * 点赞
	 */
	private int agree;

	/**
	 * 对当前回复的回复数量
	 */
	private int replyCount;

	/**
	 * 当前回复的状态
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
	 * 当前回复的正文
	 */
	private String text;

	public Reply() {
		super();
	}

	public Reply(int id, int commentId, int parentId, int agree,
			int replyCount, byte status, int creatorId, Date createTime,
			String text) {
		super();
		this.id = id;
		this.commentId = commentId;
		this.parentId = parentId;
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

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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
		return "Reply [id=" + id + ", commentId=" + commentId + ", parentId="
				+ parentId + ", agree=" + agree + ", replyCount=" + replyCount
				+ ", status=" + status + ", creatorId=" + creatorId
				+ ", createTime=" + createTime + ", text=" + text + "]";
	}

}
