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

import com.seelecloud.cms.dao.FileDao;
import com.seelecloud.cms.entity.FileEntity;
import com.seelecloud.cms.service.FileService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;

	@Override
	public void save(FileEntity file) {
		this.fileDao.save(file);
	}

	@Override
	public void update(FileEntity file) {
		this.fileDao.update(file);
	}

	@Override
	public void deleteById(int id) {
		this.fileDao.deleteById(id);
	}

	@Override
	public FileEntity findById(int id) {
		return this.fileDao.findById(id);
	}

	@Override
	public List<FileEntity> listByChannel(int channelId) {
		return this.fileDao.listByChannel(channelId);
	}

	@Override
	public List<FileEntity> listByCreator(int creatorId) {
		return this.fileDao.listByCreator(creatorId);
	}

}
