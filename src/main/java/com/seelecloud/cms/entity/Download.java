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
 * @description: 管理资源的下载记录
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
public class Download {

	/**
	 * 自增主键
	 */
	private int id;

	/**
	 * 资源文件编号
	 */
	private int resourceId;

	/**
	 * 资源文件所属栏目, 与资源编号共同确定唯一资源
	 */
	private int channelId;

	/**
	 * 下载时间
	 */
	private Date time;

	/**
	 * 下载的用户id, 或者允许路人匿名下载
	 */
	private int userId;

	public Download() {
		super();
	}

	public Download(int id, int resourceId, int channelId, Date time, int userId) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.channelId = channelId;
		this.time = time;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Download [id=" + id + ", resourceId=" + resourceId
				+ ", channelId=" + channelId + ", time=" + time + ", userId="
				+ userId + "]";
	}

}
