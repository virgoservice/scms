/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午2:42:07
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.entity;

import java.util.Date;

/** 
 * @Desc: (角色实体) 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午2:42:07 
 * @email:ramostear@163.com 
 */
public class Role {
	/**
	 * 角色编号
	 */
	private int id;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 创建者Id
	 */
	private int managerId;
	/**
	 * 角色创建时间
	 */
	private Date createTime;
	
	/**
	 * 角色描述说明
	 */
	private String description;
	

	/**
	 * 空构造函数
	 */
	public Role() {}
	
	/**
	 * 带参数的构造函数
	 * @param roleName
	 * @param managerId
	 * @param description
	 */
	public Role(String roleName,int managerId, String description){
		this.roleName = roleName;
		this.managerId = managerId;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
