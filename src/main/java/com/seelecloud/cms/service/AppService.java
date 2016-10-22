/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月23日 上午9:13:34
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.App;

/** 
 * @Desc: (站点信息业务逻辑接口) 
 * @author: 谭朝红 
 * @date: 2016年8月23日 上午9:13:34 
 * @email:ramostear@163.com 
 */
public interface AppService {
	/**
	 * 保存站点信息
	 * @param app
	 */
	public void save(App app);
	
	/**
	 * 删除站点信息
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 更新站点信息
	 * @param app
	 */
	public void update(App app);
	/**
	 * 根据id查找站点信息
	 * @param id
	 * @return
	 */
	public App findById(int id);
	/**
	 * 根据站点名称查找站点信息
	 * @param appName
	 * @return
	 */
	public App findByName(@Param("appName")String appName);
	/**
	 * 根据域名查找站点信息
	 * @param appUrl
	 * @return
	 */
	public App findByUrl(@Param("appUrl") String appUrl);
	/**
	 * 根据管理员查找管理员所创建的站点信息
	 * @param managerId
	 * @return
	 */
	public List<App> findByManagerId(@Param("appManagerId")int managerId);
	/**
	 * 根据管理员Id获取站点数量
	 * @param managerId
	 * @return
	 */
	public int appCountByManager(@Param("appManagerId")int managerId);
	
	/**
	 * 分页查询站点信息
	 * @param managerId		管理员Id
	 * @param offset		起始页
	 * @param size			查询条数
	 * @param orderBy		排序字段
	 * @param order			排序方式
	 * @return
	 */
	public List<App> findByPageAndManager(@Param("appManagerId") int managerId,@Param("offset")int offset,@Param("size")int size,@Param("oderBy")String orderBy,@Param("order") boolean order);
}
