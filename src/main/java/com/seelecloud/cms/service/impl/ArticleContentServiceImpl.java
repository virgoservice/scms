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
	public void SaveArticleSection(ArticleContent articleContent) {
		this.articleContentDao.insert(articleContent);
	}

	@Override
	public void deleteArticleContent(int id) {
		this.articleContentDao.deleteById(id);
	}

	@Override
	public List<ArticleContent> listArticleContent(int id) {
		return this.articleContentDao.listArticleContent(id);
	}

	@Override
	public ArticleContent findArticleSection(int id, int sectionNum) {
		return this.articleContentDao.findArticleSection(id, sectionNum);
	}

	@Override
	public void update(ArticleContent articleContent) {
		this.articleContentDao.update(articleContent);
	}

	@Override
	public ArticleContent listArticleById(int id) {
		return this.articleContentDao.listArticleById(id);
	}

}
