/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午3:00:05
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.entity;

/** 
 * @Desc: (角色模块关联实体) 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午3:00:05 
 * @email:ramostear@163.com 
 */
public class RoleModel {
	
	private int id;
	
	/**
	 * 角色编号
	 */
	private int roleId;
	/**
	 * 模块编号
	 */
	private int modelId;
	
	
	/**
	 * 无参构造函数 
	 */
	public RoleModel() {
	}
	/**
	 * 带参数的构造函数
	 * @param roleId
	 * @param modelId
	 */
	public RoleModel(int roleId,int modelId){
		this.roleId = roleId;
		this.modelId = modelId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
}
