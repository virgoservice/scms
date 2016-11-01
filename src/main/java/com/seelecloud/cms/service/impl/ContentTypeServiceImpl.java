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

import com.seelecloud.cms.dao.ContentTypeDao;
import com.seelecloud.cms.entity.ContentType;
import com.seelecloud.cms.service.ContentTypeService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
@Service("contentTypeService")
public class ContentTypeServiceImpl implements ContentTypeService {

	@Autowired
	ContentTypeDao contentTypeDao;

	@Override
	public void save(ContentType contentType) {
		this.contentTypeDao.insert(contentType);
	}

	@Override
	public void update(ContentType contentType) {
		this.contentTypeDao.updateByPrimaryKeySelective(contentType);
	}

	@Override
	public void delete(int id) {
		this.contentTypeDao.deleteByPrimaryKey(id);
	}

	@Override
	public ContentType findById(int id) {
		return this.contentTypeDao.selectByPrimaryKey(id);
	}

	@Override
	public ContentType findByName(String name) {
		return this.contentTypeDao.selectByName(name);
	}

	@Override
	public List<ContentType> findNameById(Integer id) {
		return this.contentTypeDao.selectNameById(id);
	}
	
	
}
