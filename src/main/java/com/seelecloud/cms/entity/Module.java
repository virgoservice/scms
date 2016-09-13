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
	private String modelName;
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
	private String modelUrl;
	/**
	 * 模块的显示图标
	 */
	private String modelIcon;
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
	 * @param modelName
	 * @param modelUrl
	 * @param modelIcon
	 * @param managerId
	 */
	public Module(String modelName,String modelUrl,String modelIcon,int managerId){
		this.modelName = modelName;
		this.modelUrl = modelUrl;
		this.modelIcon = modelIcon;
		this.managerId = managerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
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
	public String getModelUrl() {
		return modelUrl;
	}
	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}
	public String getModelIcon() {
		return modelIcon;
	}
	public void setModelIcon(String modelIcon) {
		this.modelIcon = modelIcon;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
