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
public class ModelVo {
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
	
	private List<ModelVo> child;
	
	/**
	 * 
	 */
	public ModelVo() {
	}

	/**
	 * @param id
	 * @param modelName
	 * @param createTime
	 * @param parentId
	 * @param modelUrl
	 * @param modelIcon
	 * @param managerId
	 * @param child
	 */
	public ModelVo(int id, String modelName, Date createTime, int parentId,
			String modelUrl, String modelIcon, int managerId,
			List<ModelVo> child) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.createTime = createTime;
		this.parentId = parentId;
		this.modelUrl = modelUrl;
		this.modelIcon = modelIcon;
		this.managerId = managerId;
		this.child = child;
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

	public List<ModelVo> getChild() {
		return child;
	}

	public void setChild(List<ModelVo> child) {
		this.child = child;
	}
	
}
