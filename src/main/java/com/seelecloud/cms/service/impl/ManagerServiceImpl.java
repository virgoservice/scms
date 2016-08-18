/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午5:46:06
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

import com.seelecloud.cms.dao.ManagerDao;
import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.service.ManagerService;

/** 
 * @Desc: (管理员业务接口实现类) 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午5:46:06 
 * @email:ramostear@163.com 
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	
	/**
	 * 注入ManagerDao数据访问接口 
	 */
	@Autowired
	private ManagerDao managerDao;

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ManagerService#save(com.seelecloud.cms.entity.Manager)
	 */
	@Override
	public void save(Manager manger) {
		this.managerDao.save(manger);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ManagerService#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.managerDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ManagerService#update(com.seelecloud.cms.entity.Manager)
	 */
	@Override
	public void update(Manager manager) {
		this.managerDao.update(manager);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ManagerService#findById(int)
	 */
	@Override
	public Manager findById(int id) {
		return this.managerDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ManagerService#findByName(java.lang.String)
	 */
	@Override
	public Manager findByName(String managerName) {
		return this.managerDao.findByName(managerName);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ManagerService#ListAll()
	 */
	@Override
	public List<Manager> ListAll() {
		return this.managerDao.ListAll();
	}

}
