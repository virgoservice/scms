/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月13日 下午12:44:55
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.vo;

import java.util.Date;
import java.util.List;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月13日 下午12:44:55 
 * @email:ramostear@163.com 
 */
public class ModuleVo {
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
	 * 模块编辑树 是否处于勾选状态
	 */
	private int checked;

	private List<ModuleVo> child;
	
	/**
	 * 
	 */
	public ModuleVo() {
	}

	public ModuleVo(int id, String moduleName, Date createTime, int parentId,
			String moduleUrl, String moduleIcon, int managerId, 
			List<ModuleVo> child) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.createTime = createTime;
		this.parentId = parentId;
		this.moduleUrl = moduleUrl;
		this.moduleIcon = moduleIcon;
		this.managerId = managerId;
		this.child = child;
	}
	
	/*
	 * 用于构造模块树:查看/编辑
	 */
	public ModuleVo(int id, String moduleName, int parentId, String moduleUrl, 
			String moduleIcon, int checked, List<ModuleVo> child) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.parentId = parentId;
		this.moduleUrl = moduleUrl;
		this.moduleIcon = moduleIcon;
		this.checked = checked;
		this.child = child;
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

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}
	
	public List<ModuleVo> getChild() {
		return child;
	}

	public void setChild(List<ModuleVo> child) {
		this.child = child;
	}
	
}
