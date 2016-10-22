/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午2:46:36
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.entity;

import java.util.Date;

/** 
 * @Desc: (系统模块实体，如人员管理模块，角色管理模块，权限管理模块，文章管理模块等) 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午2:46:36 
 * @email:ramostear@163.com 
 */
public class Module {
	/**
	 * 模块编号
	 */
	private int id;
	/**
	 * 模块名称
	 */
	private String moduleName;
	/**
	 * 模块创建时间
	 */
	private Date createTime;
	/**
	 * 父模块编号，如果是顶级模块，则模块的父模块编号为-1
	 */
	private int parentId;
	
	/**
	 * 模块的访问地址
	 */
	private String moduleUrl;
	/**
	 * 模块的显示图标
	 */
	private String moduleIcon;
	/**
	 * 模块的创建者
	 */
	private int managerId;
	
	
	/**
	 * 无参的构造函数
	 */
	public Module() {}
	/**
	 * 带参数的构造函数
	 * @param moduleName
	 * @param moduleUrl
	 * @param moduleIcon
	 * @param managerId
	 */
	public Module(String moduleName,String moduleUrl,String moduleIcon,int managerId){
		this.moduleName = moduleName;
		this.moduleUrl = moduleUrl;
		this.moduleIcon = moduleIcon;
		this.managerId = managerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}
	public String getModuleIcon() {
		return moduleIcon;
	}
	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
