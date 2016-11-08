/**
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.servicetest;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.Article;
import com.seelecloud.cms.service.ArticleService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class ArticleServiceTest {

	private static final transient Logger log = LoggerFactory
			.getLogger(ArticleServiceTest.class);
	private ArticleService articleService;

	@Before
	public void before() {
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring.xml",
						"classpath:/spring-mybatis.xml" });
		articleService = (ArticleService) context.getBean("articleService");
	}

	@Ignore
	@Test
	public void testSave() {
		Article article = new Article();
		article.setId(14);
		article.setTitle("title");
		article.setSubtitle("sub title");
		article.setDescription("abcdef");
		article.setFrontCover("fc");
		article.setKeyword("kw");
		article.setCreateTime(new Date());
		article.setChannelId(0);
		this.articleService.save(article);
	}

	@Test
	public void testUpdate() {
		Article article = this.articleService.findById(14);
		if (article != null) {
			article.setDescription("hhhhhhh");
			article.setKeyword("kw");
			article.setPublishTime(new Date());
			article.setSubtitle("sub title 2");
			this.articleService.update(article);
		}
	}

	@Ignore
	@Test
	public void testFindById() {
		Article article = null;
		article = this.articleService.findById(2);
		if (article != null) {
			log.info(article.toString());
		} else {
			log.info("no found");
		}
	}

	@Ignore
	@Test
	public void testFindByChannelId() {
		List<Article> articleList = null;
		articleList = this.articleService.listByChannelId(0);
		if (articleList != null) {
			for (Article a : articleList)
				log.info(a.toString());
		} else {
			log.info("no data");
		}
	}
	
	@Test
	public void testListByBases() {
		List<Article> articleList = null;
		articleList = this.articleService.listByBases(0, 1 ,6,"csdn");
		if (articleList != null) {
			for (Article a : articleList)
				log.info(a.toString());
		} else {
			log.info("no data");
		}
	}

	@After
	public void tearDown() {
		System.out.println("test end!");
	}
}
