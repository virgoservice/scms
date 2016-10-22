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
 * @Desc: (RoleModel Service Interface) 
 * @author: 谭朝红 
 * @date: 2016年9月7日 下午11:26:24 
 * @email:ramostear@163.com 
 */
public interface RoleModuleService {

	/**"
	 * 添加RoleModel
	 * @param roleModel
	 */
	public void save(RoleModule roleModel);
	
	/**
	 * update roleModel object
	 * @param roleModel
	 */
	public void update(RoleModule roleModel);
	
	/**
	 * delete roleModel object by id
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
