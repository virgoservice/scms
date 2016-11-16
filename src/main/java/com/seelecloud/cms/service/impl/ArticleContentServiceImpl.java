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

import com.seelecloud.cms.dao.ArticleContentDao;
import com.seelecloud.cms.entity.ArticleContent;
import com.seelecloud.cms.service.ArticleContentService;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
@Service("articleContentService")
public class ArticleContentServiceImpl implements ArticleContentService {

	@Autowired
	ArticleContentDao articleContentDao;
	
	@Override
	public void save(ArticleContent articleContent) {
		this.articleContentDao.save(articleContent);
	}

	@Override
	public void deleteByUuid(String uuid) {
		this.articleContentDao.deleteByUuid(uuid);
	}
	
	@Override
	public void update(ArticleContent articleContent) {
		this.articleContentDao.update(articleContent);
	}

	@Override
	public ArticleContent findArticleSection(String uuid, int sectionNum) {
		return this.articleContentDao.findArticleSection(uuid, sectionNum);
	}
	
	@Override
	public List<ArticleContent> listArticleAllContent(String uuid) {
		return this.articleContentDao.listArticleAllContent(uuid);
	}

}
