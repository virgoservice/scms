/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seelecloud.cms.dao.ChannelDao;
import com.seelecloud.cms.entity.Channel;
import com.seelecloud.cms.service.ChannelService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
@Service("channelService")
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	ChannelDao channelDao;

	@Override
	public void save(Channel channel) {
		this.channelDao.insert(channel);
	}

	@Override
	public void update(Channel channel) {
		this.channelDao.update(channel);
	}

	@Override
	public void delete(int id) {
		this.channelDao.deleteById(id);
	}

	@Override
	public Channel findChannelById(int id) {
		return this.channelDao.selectById(id);
	}

	@Override
	public List<Channel> listChannelByIds(List<Integer> channelIds) {
		return this.channelDao.listChannelByIds(channelIds);
	}

	@Override
	public List<Channel> listChannelByTree() {
		return this.channelDao.listChannelByTree();
	}

	@Override
	public List<Channel> listChannelByParent(Integer pid) {
		return this.channelDao.listChannelByParent(pid);
	}

	@Override
	public Integer getMaxOrderByParent(Integer pid) {
		return this.channelDao.getMaxOrderByParent(pid);
	}

	@Override
	public List<Channel> listPublishChannel() {
		return this.channelDao.listPublishChannel();
	}

}
