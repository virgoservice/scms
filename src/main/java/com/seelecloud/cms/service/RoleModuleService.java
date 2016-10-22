/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月7日 下午11:26:24
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.RoleModule;

/** 
 * @Desc: (RoleModule Service Interface) 
 * @author: 谭朝红 
 * @date: 2016年9月7日 下午11:26:24 
 * @email:ramostear@163.com 
 */
public interface RoleModuleService {

	/**
	 * 添加一条角色-模块关系记录
	 * @param roleModule
	 */
	public void save(RoleModule roleModule);
	
	/**
	 * 修改一条角色-模块记录
	 * @param roleModule
	 */
	public void update(RoleModule roleModule);
	
	/**
	 * 通过id 删除一条角色-模块关系记录
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 根据表id查找记录
	 * @param id
	 * @return
	 */
	public RoleModule findById(int id);
	
	/**
	 * 查找与指定角色有关系的所有模块id
	 * @param roleId
	 * @return
	 */
	public List<Integer> findModuleIdsByRole(@Param("roleId")int roleId);
	
	/**
	 * 查找与指定模块关联的所有角色id
	 * @param moduleId
	 * @return
	 */
	public List<Integer> findRoleIdsByModule(@Param("moduleId")int moduleId);
	
	/**
	 * 删除指定角色相关的所有关系记录
	 * @param roleId
	 */
	public void deleteByRoleId(@Param("roleId")int roleId);
	
}
