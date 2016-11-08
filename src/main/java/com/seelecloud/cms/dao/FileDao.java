/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.FileEntity;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
public interface FileDao {

	public void save(FileEntity file);

	public void update(FileEntity file);

	public void deleteById(@Param("id") int id);

	public FileEntity findById(@Param("id") int id);

	public List<FileEntity> listByChannel(@Param("channelId") int channelId);

	public List<FileEntity> listByCreator(@Param("creatorId") int creatorId);
}
