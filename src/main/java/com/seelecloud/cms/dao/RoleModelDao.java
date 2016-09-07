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

import com.seelecloud.cms.entity.RoleModel;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午11:50:28 
 * @email:ramostear@163.com 
 */
public interface RoleModelDao {

	/**"
	 * 添加RoleModel
	 * @param roleModel
	 */
	public void save(RoleModel roleModel);
	
	/**
	 * update roleModel object
	 * @param roleModel
	 */
	public void update(RoleModel roleModel);
	
	/**
	 * delete roleModel object by id
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * find the model id by the role id
	 * @param roleId
	 * @return
	 */
	public List<Integer> findModelIdsByRole(int roleId);
	
	/**
	 * find role id by the model Id
	 * @param modelId
	 * @return
	 */
	public List<Integer> findRoleIdsByModel(int modelId);
	
	/**
	 * 根据角色Id接触角色和模块的关系
	 * @param roleId
	 */
	public void deleteByRoleId(int roleId);
	
}
