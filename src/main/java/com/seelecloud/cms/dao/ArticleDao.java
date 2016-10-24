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

import java.util.Date;
import java.util.List;

import com.seelecloud.cms.entity.Article;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public interface ArticleDao {

	public int insert(Article record);

	public int update(Article record);

	public int deleteById(Integer id);

	public Article selectByPrimaryKey(Integer id);
	
	public List<Article> findByChannelId(int channelId);
	
	public List<Article> findByPublisherId(int publisherId);
	
	public List<Article> findByPublishTime(Date publishStartTime,
			Date publishEndTime);
	
	public List<Article> findByCreatorId(int creatorId);
	
	public List<Article> findByCreateTime(Date createStartTime,
			Date createEndTime);

	public List<Article> findBySource(String source);
	
}
