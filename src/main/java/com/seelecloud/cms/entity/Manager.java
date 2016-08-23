/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午2:33:52
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.entity;

import java.util.Date;

/** 
 * @Desc: (管理员实体) 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午2:33:52 
 * @email:ramostear@163.com 
 */
public class Manager {
	
	/**
	 * 管理员编号
	 */
	private int id;
	/**
	 * 管理员名称
	 */
	private String managerName;
	/**
	 * 管理员别名
	 */
	private String managerNickname;
	/**
	 * 管理员密码
	 */
	private String password;
	
	/**
	 * 角色Id
	 */
	private int roleId;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	private int parentId;
	
	
	/**
	 * 空构造函数
	 */
	public Manager() {}
	/**
	 * 带参数的造函数
	 * @param managerName
	 * @param password
	 */
	public Manager(String managerName,String password){
		this.managerName = managerName;
		this.password = password;
	}
	public Manager(String managerName,String password,int parentId){
		this.managerName = managerName;
		this.password = password;
		this.parentId = parentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerNickname() {
		return managerNickname;
	}
	public void setManagerNickname(String managerNickname) {
		this.managerNickname = managerNickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
