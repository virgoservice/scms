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

import com.seelecloud.cms.entity.Article;

/**
 * @description:文章实体的增删改查方法接口
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public interface ArticleService {

	/**
	 * 添加文章
	 * 
	 * @Article
	 */
	public void save(Article article);
	
	/**
	 * 更新文章
	 * 
	 * @Article
	 */
	public void update(Article article);

	/**
	 * 删除指定一篇文章
	 * 
	 * @param uuid
	 */
	public void deleteByUuid(@Param("uuid") String uuid);

	/**
	 * 根据文章id 查找文章实体
	 * 
	 * @param uuid
	 * @return
	 */
	public Article findByUuid(@Param("uuid") String uuid);

	/**
	 * 根据栏目id 查找文章列表
	 * 
	 * @param channelId
	 * @return
	 */
	public List<Article> listByChannelId(@Param("channelId") int channelId);

	/**
	 * 根据发布者id 查找文章列表
	 * 
	 * @param publisherId
	 * @return
	 */
	public List<Article> listByPublisherId(@Param("publisherId") int publisherId);

	/**
	 * 根据发布的时间段，查找文章列表
	 * 
	 * @param publishStartTime
	 * @param publishEndTime
	 * @return
	 */
	public List<Article> listByPublishTime(
			@Param("publishStartTime") Date publishStartTime,
			@Param("publishEndTime") Date publishEndTime);

	/**
	 * 根据发布者id 查找文章列表
	 * 
	 * @param publisherId
	 * @return
	 */
	public List<Article> listByCreatorId(@Param("creatorId") int creatorId);

	/**
	 * 根据创建的时间段，查找文章列表
	 * 
	 * @param createStartTime
	 * @param createEndTime
	 * @return
	 */
	public List<Article> listByCreateTime(
			@Param("createStartTime") Date createStartTime,
			@Param("createEndTime") Date createEndTime);

	/**
	 * 根据文章来源查找文章列表
	 * 
	 * @param source
	 * @return
	 */
	public List<Article> listBySource(@Param("source") String source);

	/**
	 * 根据用户，栏目和标题和状态进行检索
	 * @param creatorId:用户id
	 * @param channelId
	 * @param title
	 * @param status
	 * @return
	 */
	public List<Article> listByConditions(
			@Param("creatorId") Integer creatorId,
			@Param("status") Integer status,
			@Param("channelId") Integer channelId,
			@Param("title") String title,
			@Param("orderBy")String orderBy,
			@Param("idAsc")boolean isAsc);
}
