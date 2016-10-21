/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午5:44:54
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.Manager;

/** 
 * @Desc: (管理员业务接口) 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午5:44:54 
 * @email:ramostear@163.com 
 */
public interface ManagerService {

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
	
	/**
	 * 查询管理员编号为id的管理员所创建的子管理员的数量
	 * @param id
	 * @return
	 */
	public int findTotalCount(@Param("id")int id);
	
	/**
	 * 分页查询编号为id的管理员所创建的子管理员
	 * @param id			管理员编号
	 * @param offset		起始页
	 * @param size			查询条数
	 * @param orderBy		排序字段
	 * @param order 		排序方式 true:desc,false:asc
	 * @return
	 */
	public List<Manager> findByPage(@Param("id") int id,@Param("offset")int offset,@Param("size")int size,@Param("oderBy")String orderBy,@Param("order") boolean order);
	
	
	
}
