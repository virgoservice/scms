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

import com.seelecloud.cms.entity.ChannelContent;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public interface ChannelContentService {

	public void save(ChannelContent channelContent);

	public void update(ChannelContent channelContent);

	public void delete(@Param("id") int id);

	/**
	 * 通过栏目id获取所有关联的内容类型及内容id
	 * 
	 * @param id
	 * @return
	 */
	public List<ChannelContent> listAllById(@Param("id") int id);

}
