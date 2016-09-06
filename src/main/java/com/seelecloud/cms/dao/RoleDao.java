/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月6日 下午10:06:23
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.Role;

/** 
 * @Desc: (角色Dao) 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午10:06:23 
 * @email:ramostear@163.com 
 */
public interface RoleDao {

	
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
	public List<Role> findByManagerId(@Param("managerId")int managerId);
	
}
