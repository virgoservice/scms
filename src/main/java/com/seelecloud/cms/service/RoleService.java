/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月6日 下午10:18:26
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.Role;

/** 
 * @Desc: (角色Service接口) 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午10:18:26 
 * @email:ramostear@163.com 
 */
public interface RoleService {

	/**
	 * 添加角色实体
	 * @param role
	 */
	public void save(Role role);
	
	/**
	 * 更新实体信息
	 * @param role
	 */
	public void update(Role role);
	
	/**
	 * 删除角色信息
	 * @param id
	 */
	public void delete(@Param("id")int id);
	
	/**
	 * 根据Id查找角色信息
	 * @param id
	 * @return
	 */
	public Role findById(@Param("id")int id);
	
	/**
	 * 查找管理员所有的角色
	 * @param managerId
	 * @return
	 */
	public List<Role> findByManangerId(@Param("managerId")int managerId);
	
	public List<Role> findByPage(int mannagerId, int begin, int pageSize, String orderBy, boolean order);
}
