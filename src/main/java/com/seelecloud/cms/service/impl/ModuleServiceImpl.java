/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月6日 下午2:30:27
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

import com.seelecloud.cms.dao.ModuleDao;
import com.seelecloud.cms.entity.Module;
import com.seelecloud.cms.service.ModuleService;

/** 
 * @Desc: (功能模块Service实现类) 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午2:30:27 
 * @email:ramostear@163.com 
 */
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{
	
	@Autowired
	private ModuleDao moduleDao;

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#save(com.seelecloud.cms.entity.Model)
	 */
	@Override
	public void save(Module model) {
		this.moduleDao.save(model);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.moduleDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#update(com.seelecloud.cms.entity.Model)
	 */
	@Override
	public void update(Module model) {
		this.moduleDao.update(model);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#findById(int)
	 */
	@Override
	public Module findById(int id) {
		return this.moduleDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#findByParent(int)
	 */
	@Override
	public List<Module> findByParent(int parentId) {
		return this.moduleDao.findByParent(parentId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#findByManagerId(int)
	 */
	@Override
	public List<Module> findByManagerId(int managerId) {
		return this.moduleDao.findByManagerId(managerId);
	}

}
