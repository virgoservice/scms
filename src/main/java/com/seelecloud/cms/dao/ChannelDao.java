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

import com.seelecloud.cms.entity.Channel;
/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public interface ChannelDao {

	public void deleteById(Integer id);

	public void insert(Channel channel);

	int update(Channel channel);
	
	/**
	 * 根据id获取所有值
	 * @param id
	 * @return
	 */
	public Channel selectById(Integer id);
	
	/**
	 * 根据父id获取所有的子栏目
	 * @param pid
	 * @return
	 */
	public List<Channel> listChannelByParent(Integer pid);
	
	/**
	 * 生成一棵树
	 * @return
	 */
	public List<Channel> listChannelByTree();
	
	public List<Channel> listChannelByIds(List<Integer> channelIds);

	public List<Channel> listChannelByType(Integer type);
	
}
