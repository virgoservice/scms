/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午5:23:15
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.dao;

import java.util.List;

import com.seelecloud.cms.entity.Manager;

/** 
 * @Desc: (管理员实体数据访问接口) 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午5:23:15 
 * @email:ramostear@163.com 
 */
public interface ManagerDao {

	/**
	 * 保存实体
	 * @param manger
	 */
	public void save(Manager manger);
	
	/**
	 * 根据Id删除实体
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 更新实体
	 * @param manager
	 */
	public void update(Manager manager);
	
	/**
	 * 根据ID查找实体
	 * @param id
	 * @return
	 */
	public Manager findById(int id);
	
	/**
	 * 根据名字查找
	 * @param managerName
	 * @return
	 */
	public Manager findByName(String managerName);
	
	/**
	 * 查找所有的管理员实体信息
	 * @return
	 */
	public List<Manager> ListAll();
	
}
