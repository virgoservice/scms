/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月6日 下午11:50:28
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.RoleModule;

/** 
<<<<<<< HEAD
 * @Desc: 角色-模块关联表(role-module)用以确定角色可以操作的功能模块
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午11:50:28 
 * @email:ramostear@163.com 
 */
public interface RoleModuleDao {

	/**
	 * 为角色添加一个可以操作模块
	 * @param roleModule
	 */
	public void save(RoleModule roleModule);
	
	/**
	 * 修改一个角色可以操作的模块
	 * @param roleModule
	 */
	public void update(RoleModule roleModule);
	
	/**
	 * delete roleModule object by id
	 * @param id
	 */
	public void delete(int id);
	
	
	/**
	 * 根据关联编号查找
	 * @param id
	 * @return
	 */
	public RoleModule findById(int id);
	
	/**
	 * 通过角色id查找所有关联的模块
	 * @param roleId
	 * @return
	 */
	public List<Integer> findModuleIdsByRole(@Param("roleId")int roleId);
	
	/**
	 * 根据指定模块id查找所有关联的角色(哪些角色可以操作这个模块)
	 * @param moduleId
	 * @return
	 */
	public List<Integer> findRoleIdsByModule(@Param("moduleId")int moduleId);
	/**
	 * find the model id by the role id
	 * @param roleId
	 * @return
	 */
	public List<Integer> findModelIdsByRole(@Param("roleId")int roleId);
	
	/**
	 * find role id by the model Id
	 * @param modelId
	 * @return
	 */
	public List<Integer> findRoleIdsByModel(@Param("modelId")int modelId);
	
	/**
	 * 根据角色Id接触角色和模块的关系
	 * @param roleId
	 */
	public void deleteByRoleId(@Param("roleId")int roleId);
	
}
