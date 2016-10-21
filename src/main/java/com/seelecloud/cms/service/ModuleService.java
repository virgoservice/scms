/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月6日 下午2:29:39
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.Module;

/** 
 * @Desc: (功能模块Service) 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午2:29:39 
 * @email:ramostear@163.com 
 */
public interface ModuleService {
	/**
	 * 添加模块
	 * @param module
	 */
	public void save(Module module);
	/**
	 * 根据ID删除模块
	 * @param id
	 */
	public void delete(@Param("id")int id);
	/**
	 * 更新模块
	 * @param module
	 */
	public void update(Module module);
	/**
	 * 根据Id查找模块
	 * @param id
	 * @return
	 */
	public Module findById(int id);
	/**
	 * 根据父Id查询子模块
	 * @param parentId
	 * @return
	 */
	public List<Module> findByParent(@Param("parentId")int parentId);
	
	/**
	 * 根据管理员来查找
	 * @param managerId
	 * @return
	 */
	public List<Module> findByManagerId(@Param("managerId")int managerId);

	/**
	 * 角色-模块表 与 模块信息表联合查询
	 * @param roleId
	 * @return
	 */
	public List<Module> findByRoleId(@Param("roleId")int roleId);
}

