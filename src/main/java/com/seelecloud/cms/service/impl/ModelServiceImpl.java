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

import com.seelecloud.cms.dao.ModelDao;
import com.seelecloud.cms.entity.Model;
import com.seelecloud.cms.service.ModelService;

/** 
 * @Desc: (功能模块Service实现类) 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午2:30:27 
 * @email:ramostear@163.com 
 */
@Service("modelService")
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelDao modelDao;

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#save(com.seelecloud.cms.entity.Model)
	 */
	@Override
	public void save(Model model) {
		this.modelDao.save(model);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.modelDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#update(com.seelecloud.cms.entity.Model)
	 */
	@Override
	public void update(Model model) {
		this.modelDao.update(model);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#findById(int)
	 */
	@Override
	public Model findById(int id) {
		return this.modelDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#findByParent(int)
	 */
	@Override
	public List<Model> findByParent(int parentId) {
		return this.modelDao.findByParent(parentId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.ModelService#findByManagerId(int)
	 */
	@Override
	public List<Model> findByManagerId(int managerId) {
		return this.modelDao.findByManagerId(managerId);
	}

}
