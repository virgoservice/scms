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

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seelecloud.cms.dao.DownloadDao;
import com.seelecloud.cms.entity.Download;
import com.seelecloud.cms.service.DownloadService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {

	@Autowired
	private DownloadDao downloadDao;

	@Override
	public void save(Download download) {
		this.downloadDao.save(download);
	}

	@Override
	public int getTotalByTime(String resourceUuid, Date startTime, Date endTime) {
		return this.downloadDao
				.getTotalByTime(resourceUuid, startTime, endTime);
	}

	@Override
	public List<Download> listByTime(@Param("resourceId") String resourceUuid,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime) {
		return this.downloadDao.listByTime(resourceUuid, startTime, endTime);
	}

	@Override
	public List<Download> listByUser(int userId) {
		return this.downloadDao.listByUser(userId);
	}

	@Override
	public List<Download> listByResourceUuid(String resourceUuid) {
		return this.downloadDao.listByResourceUuid(resourceUuid);
	}

}
