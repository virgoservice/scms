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
 * @description:
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
	 * @param id
	 */
	public void delete(@Param("id") int id);

	/**
	 * 根据文章id 查找文章实体
	 * 
	 * @param id
	 * @return
	 */
	public Article findById(@Param("id") int id);

	/**
	 * 根据栏目id 查找文章列表
	 * 
	 * @param channelId
	 * @return
	 */
	public List<Article> findByChannelId(@Param("channelId") int channelId);

	/**
	 * 根据发布者id 查找文章列表
	 * 
	 * @param publisherId
	 * @return
	 */
	public List<Article> findByPublisherId(@Param("publisherId") int publisherId);

	/**
	 * 根据发布的时间段，查找文章列表
	 * 
	 * @param publishStartTime
	 * @param publishEndTime
	 * @return
	 */
	public List<Article> findByPublishTime(
			@Param("publishStartTime") Date publishStartTime,
			@Param("publishEndTime") Date publishEndTime);

	/**
	 * 根据发布者id 查找文章列表
	 * 
	 * @param publisherId
	 * @return
	 */
	public List<Article> findByCreatorId(@Param("creatorId") int creatorId);

	/**
	 * 根据创建的时间段，查找文章列表
	 * 
	 * @param createStartTime
	 * @param createEndTime
	 * @return
	 */
	public List<Article> findByCreateTime(
			@Param("createStartTime") Date createStartTime,
			@Param("createEndTime") Date createEndTime);

	/**
	 * 根据文章来源查找文章列表
	 * 
	 * @param source
	 * @return
	 */
	public List<Article> findBySource(@Param("source") String source);
}
