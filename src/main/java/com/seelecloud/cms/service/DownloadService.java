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

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.Download;

/**
 * @description: 资源下载记录
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
public interface DownloadService {

	/**
	 * 写入一条新的下载记录
	 * @param download
	 */
	public void save(Download download);

	/**
	 * 按时间查询指定资源的下载记录
	 * 
	 * @param resourceUuid
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public int getTotalByTime(
			@Param("resourceUuid") String resourceUuid,
			@Param("startTime") Date startTime,
			@Param("endTime") Date endTime);

	/**
	 * 列出指定资源在时间段内的下载记录
	 * 
	 * @param resourceUuid
	 * @param channelId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<Download> listByTime(
			@Param("resourceUuid") String resourceUuid,
			@Param("startTime") Date startTime,
			@Param("endTime") Date endTime);

	/**
	 * 查询资源的所有下载记录
	 * 
	 * @param resourceUuid
	 * @return
	 */
	public List<Download> listByResourceUuid(@Param("resourceUuid") String resourceUuid);

	/**
	 * 查询用户的下载记录
	 * 
	 * @param userId
	 * @return
	 */
	public List<Download> listByUser(@Param("userId") int userId);
	
}
