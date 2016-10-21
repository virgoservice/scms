/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.vo;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年9月30日
 * @Email:
 */
public class PermissionVo {

	/**
	 * 管理员编号
	 */
	private int id;
	/**
	 * 管理员名称
	 */
	private String managerName;

	/**
	 * 角色Id
	 */
	private int roleId;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色描述说明
	 */
	private String description;

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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PermissionVo() {
	}

	public PermissionVo(int id, String managerName, int roleId,
			String roleName, String description) {
		super();
		this.id = id;
		this.managerName = managerName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
	}

}
