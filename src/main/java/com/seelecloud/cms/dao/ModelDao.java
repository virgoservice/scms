/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月23日 上午11:52:22
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.Model;

/** 
 * @Desc: (系统模块Dao) 
 * @author: 谭朝红 
 * @date: 2016年8月23日 上午11:52:22 
 * @email:ramostear@163.com 
 */
public interface ModelDao {

	/**
	 * 添加模块
	 * @param model
	 */
	public void save(Model model);
	/**
	 * 根据ID删除模块
	 * @param id
	 */
	public void delete(@Param("id")int id);
	/**
	 * 更新模块
	 * @param model
	 */
	public void update(Model model);
	/**
	 * 根据Id查找模块
	 * @param id
	 * @return
	 */
	public Model findById(int id);
	/**
	 * 根据父Id查询子模块
	 * @param parentId
	 * @return
	 */
	public List<Model> findByParent(@Param("parentId")int parentId);
	
	/**
	 * 根据管理员来查找
	 * @param managerId
	 * @return
	 */
	public List<Model> findByManagerId(@Param("managerId")int managerId);
	
	
	
	
}
