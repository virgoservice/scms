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

import com.seelecloud.cms.dao.ChannelTypeDao;
import com.seelecloud.cms.entity.ChannelType;
import com.seelecloud.cms.service.ChannelTypeService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
@Service("channelTypeService")
public class ChannelTypeServiceImpl implements ChannelTypeService {

	@Autowired
	ChannelTypeDao channelTypeDao;

	@Override
	public void save(ChannelType channelType) {
		this.channelTypeDao.save(channelType);
	}

	@Override
	public void update(ChannelType channelType) {
		this.channelTypeDao.update(channelType);
	}

	@Override
	public void deleteById(int id) {
		this.channelTypeDao.deleteById(id);
	}

	@Override
	public ChannelType findById(int id) {
		return this.channelTypeDao.findById(id);
	}

	@Override
	public String findNameById(Integer id) {
		return this.channelTypeDao.findNameById(id);
	}

	@Override
	public List<ChannelType> listAllChannelType() {
		return this.channelTypeDao.listAllChannelType();
	}

}
