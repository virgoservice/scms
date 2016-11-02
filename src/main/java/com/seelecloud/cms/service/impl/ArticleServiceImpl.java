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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seelecloud.cms.dao.ArticleDao;
import com.seelecloud.cms.entity.Article;
import com.seelecloud.cms.service.ArticleService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleDao articleDao;

	@Override
	public void save(Article article) {
		this.articleDao.save(article);
	}

	@Override
	public void update(Article article) {
		this.articleDao.update(article);
	}

	@Override
	public void delete(int id) {
		this.articleDao.deleteById(id);
	}

	@Override
	public Article findById(int id) {
		return this.articleDao.findById(id);
	}

	@Override
	public List<Article> listByChannelId(int channelId) {
		return this.articleDao.listByChannelId(channelId);
	}

	@Override
	public List<Article> listByPublisherId(int publisherId) {
		return this.articleDao.listByPublisherId(publisherId);
	}

	@Override
	public List<Article> listByPublishTime(Date publishStartTime,
			Date publishEndTime) {
		return this.articleDao.listByPublishTime(publishStartTime, publishEndTime);
	}

	@Override
	public List<Article> listByCreatorId(int creatorId) {
		return this.articleDao.listByCreatorId(creatorId);
	}

	@Override
	public List<Article> listByCreateTime(Date createStartTime,
			Date createEndTime) {
		return this.articleDao.listByCreateTime(createStartTime, createEndTime);
	}

	@Override
	public List<Article> listBySource(String source) {
		return this.articleDao.listBySource(source);
	}

}
