/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.ChannelType;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public interface ChannelTypeDao {

	/**
	 * 新增一条栏目类型记录
	 * 
	 * @param channelType
	 */
	public void save(ChannelType channelType);

	/**
	 * 更新一条栏目类型记录
	 * 
	 * @param channelType
	 */
	public void update(ChannelType channelType);

	/**
	 * 根据指定id 删除栏目类型记录
	 * 
	 * @param id
	 */
	public void deleteById(@Param("id") int id);

	/**
	 * 根据指定id 查找栏目类型实体
	 * 
	 * @param id
	 * @return
	 */
	public ChannelType findById(@Param("id") int id);

	/**
	 * 根据指定id 查找栏目类型的名称
	 * 
	 * @param id
	 * @return
	 */
	public String findNameById(@Param("id") Integer id);

	/**
	 * 列出所有栏目类型记录
	 * 
	 * @return
	 */
	public List<ChannelType> listAllChannelType();

}
