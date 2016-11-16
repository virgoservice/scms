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

import com.seelecloud.cms.dao.ChannelContentDao;
import com.seelecloud.cms.entity.ChannelContent;
import com.seelecloud.cms.service.ChannelContentService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
@Service("channelContentService")
public class ChannelContentServiceImpl implements ChannelContentService {

	@Autowired
	ChannelContentDao channelContentDao;

	@Override
	public void save(ChannelContent channelContent) {
		this.channelContentDao.insert(channelContent);
	}

	@Override
	public void update(ChannelContent channelContent) {
		this.channelContentDao.update(channelContent);
	}

	@Override
	public void delete(int id) {
		this.channelContentDao.deleteById(id);
	}

	@Override
	public List<ChannelContent> listAllById(int id) {
		return this.channelContentDao.selectById(id);
	}

}
