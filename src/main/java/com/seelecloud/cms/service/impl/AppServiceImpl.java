/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月23日 上午9:15:12
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

import com.seelecloud.cms.dao.AppDao;
import com.seelecloud.cms.entity.App;
import com.seelecloud.cms.service.AppService;

/** 
 * @Desc: (站点信息业务逻辑接口实现类) 
 * @author: 谭朝红 
 * @date: 2016年8月23日 上午9:15:12 
 * @email:ramostear@163.com 
 */
@Service("appService")
public class AppServiceImpl implements AppService{
	
	/**
	 * 注入站点信息数据访问对象
	 */
	@Autowired
	private AppDao appDao;
	

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#save(com.seelecloud.cms.entity.App)
	 */
	@Override
	public void save(App app) {
		this.appDao.save(app);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.appDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#update(com.seelecloud.cms.entity.App)
	 */
	@Override
	public void update(App app) {
		this.appDao.update(app);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#findById(int)
	 */
	@Override
	public App findById(int id) {
		return this.appDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#findByName(java.lang.String)
	 */
	@Override
	public App findByName(String appName) {
		return this.appDao.findByName(appName);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#findByUrl(java.lang.String)
	 */
	@Override
	public App findByUrl(String appUrl) {
		return this.appDao.findByUrl(appUrl);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#findByManagerId(int)
	 */
	@Override
	public List<App> findByManagerId(int managerId) {
		return this.appDao.findByManagerId(managerId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#appCountByManager(int)
	 */
	@Override
	public int appCountByManager(int managerId) {
		return this.appDao.appCountByManager(managerId);
	}

	/* (non-Javadoc)
	 * @see com.seelecloud.cms.service.AppService#findByPageAndManager(int, int, int, java.lang.String, boolean)
	 */
	@Override
	public List<App> findByPageAndManager(int managerId, int offset, int size,
			String orderBy, boolean order) {
		return this.appDao.findByPageAndManager(managerId, offset, size, orderBy, order);
	}

}
