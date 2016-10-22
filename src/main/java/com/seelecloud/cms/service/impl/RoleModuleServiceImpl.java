/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月7日 下午11:27:39
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seelecloud.cms.dao.RoleModuleDao;
import com.seelecloud.cms.entity.RoleModule;
import com.seelecloud.cms.service.RoleModuleService;

/** 
 * @Desc: (implements the RoleModelService interface file) 
 * @author: 谭朝红 
 * @date: 2016年9月7日 下午11:27:39 
 * @email:ramostear@163.com 
 */
@Service("roleModuleService")
public class RoleModuleServiceImpl  implements RoleModuleService{

	@Autowired
	private RoleModuleDao roleModuleDao;
	
	
	
	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleModelService#save(com.seelecloud.cms.entity.RoleModel)
	 */
	@Override
	public void save(RoleModule roleModel) {
		this.roleModuleDao.save(roleModel);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleModelService#update(com.seelecloud.cms.entity.RoleModel)
	 */
	@Override
	public void update(RoleModule roleModel) {
		this.roleModuleDao.update(roleModel);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleModelService#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.roleModuleDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleModelService#findModelIdsByRole(int)
	 */
	@Override
	public List<Integer> findModelIdsByRole(int roleId) {
		return this.roleModuleDao.findModelIdsByRole(roleId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleModelService#findRoleIdsByModel(int)
	 */
	@Override
	public List<Integer> findRoleIdsByModel(int modelId) {
		return this.roleModuleDao.findRoleIdsByModel(modelId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleModelService#deleteByRoleId(int)
	 */
	@Override
	public void deleteByRoleId(int roleId) {
		this.roleModuleDao.deleteByRoleId(roleId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleModelService#findById(int)
	 */
	@Override
	public RoleModule findById(int id) {
		return this.roleModuleDao.findById(id);
	}

}
