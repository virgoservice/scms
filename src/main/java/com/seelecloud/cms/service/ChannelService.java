/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.service;

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
public interface ChannelService {

	public void save(Channel channel);
	
	public void update(Channel channel);
	
	public void delete(@Param("id")int id);
	
	public Channel findChannelById(@Param("id")int id);
	
	/**
	 * 通过传入一组id值查询栏目列表
	 * @param channelIds
	 * @return
	 */
	public List<Channel> listChannelByIds(@Param("channelIds")List<Integer> channelIds);
	
	public List<Channel> listChannelByType(@Param("type")int type);
}
