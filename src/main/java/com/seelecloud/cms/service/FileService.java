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

import com.seelecloud.cms.entity.FileEntity;

/**
 * @description: 资源文件实体管理, 新增文件, 删除文件, 修改文件属性
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
public interface FileService {

	public void save(FileEntity file);

	public void update(FileEntity file);

	public void deleteByUuid(@Param("uuid") String uuid);

	public FileEntity findByUuid(@Param("uuid") String uuid);

	public List<FileEntity> listByChannel(@Param("channelId") int channelId);

	public List<FileEntity> listByCreator(@Param("creatorId") int creatorId);
}
