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
	private String managerId;
	/**
	 * 角色创建时间
	 */
	private Date createTime;
	
	
	/**
	 * 空构造函数
	 */
	public Role() {}
	
	/**
	 * 带参数的构造函数
	 * @param roleName
	 * @param managerId
	 */
	public Role(String roleName,String managerId){
		this.roleName = roleName;
		this.managerId = managerId;
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

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
