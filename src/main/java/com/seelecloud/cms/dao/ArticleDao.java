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

	public int save(Article article);

	public int update(Article article);

	public int deleteById(Integer id);

	public Article findById(Integer id);
	
	public List<Article> listByChannelId(int channelId);
	
	public List<Article> listByPublisherId(int publisherId);
	
	public List<Article> listByPublishTime(Date publishStartTime,
			Date publishEndTime);
	
	public List<Article> listByCreatorId(int creatorId);
	
	public List<Article> listByCreateTime(Date createStartTime,
			Date createEndTime);

	public List<Article> listBySource(String source);
	
}
