/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月6日 下午10:19:30
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

import com.seelecloud.cms.dao.RoleDao;
import com.seelecloud.cms.entity.Role;
import com.seelecloud.cms.service.RoleService;

/** 
 * @Desc: (RoleService接口实现类) 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午10:19:30 
 * @email:ramostear@163.com 
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleService#save(com.seelecloud.cms.entity.Role)
	 */
	@Override
	public void save(Role role) {
		this.roleDao.save(role);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleService#update(com.seelecloud.cms.entity.Role)
	 */
	@Override
	public void update(Role role) {
		this.roleDao.update(role);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleService#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.roleDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleService#findById(int)
	 */
	@Override
	public Role findById(int id) {
		return this.roleDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.RoleService#findByManangerId(int)
	 */
	@Override
	public List<Role> findByManangerId(int managerId) {
		return this.roleDao.findByManagerId(managerId);
	}

	@Override
	public List<Role> findByPage(int mannagerId, int begin, int pageSize, String orderBy, boolean order)
	{
		return this.roleDao.findByPage(mannagerId, begin,pageSize, orderBy, order);
	}
}
