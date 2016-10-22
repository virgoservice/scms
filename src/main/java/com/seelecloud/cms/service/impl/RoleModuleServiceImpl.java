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
 * @Desc: (implements the roleModuleService interface file) 
 * @author: 谭朝红 
 * @date: 2016年9月7日 下午11:27:39 
 * @email:ramostear@163.com 
 */
@Service("roleModuleService")
public class RoleModuleServiceImpl  implements RoleModuleService{

	@Autowired
	private RoleModuleDao roleModuleDao;
	
	
	
	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.roleModuleService#save(com.seelecloud.cms.entity.roleModule)
	 */
	@Override
	public void save(RoleModule roleModule) {
		this.roleModuleDao.save(roleModule);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.roleModuleService#update(com.seelecloud.cms.entity.roleModule)
	 */
	@Override
	public void update(RoleModule roleModule) {
		this.roleModuleDao.update(roleModule);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.roleModuleService#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.roleModuleDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.roleModuleService#findModuleIdsByRole(int)
	 */
	@Override
	public List<Integer> findModuleIdsByRole(int roleId) {
		return this.roleModuleDao.findModuleIdsByRole(roleId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.roleModuleService#findRoleIdsByModule(int)
	 */
	@Override
	public List<Integer> findRoleIdsByModule(int moduleId) {
		return this.roleModuleDao.findRoleIdsByModule(moduleId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.roleModuleService#deleteByRoleId(int)
	 */
	@Override
	public void deleteByRoleId(int roleId) {
		this.roleModuleDao.deleteByRoleId(roleId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.roleModuleService#findById(int)
	 */
	@Override
	public RoleModule findById(int id) {
		return this.roleModuleDao.findById(id);
	}

}
