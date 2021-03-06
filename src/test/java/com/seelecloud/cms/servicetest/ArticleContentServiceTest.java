/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.servicetest;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.ArticleContent;
import com.seelecloud.cms.service.ArticleContentService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class ArticleContentServiceTest {

	private ArticleContentService articleContentService;

	@Before
	public void before() {
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring.xml",
						"classpath:/spring-mybatis.xml" });
		articleContentService = (ArticleContentService) context
				.getBean("articleContentService");
	}

	@Ignore
	@Test
	public void testSave() {
		ArticleContent articleContent = new ArticleContent();

		articleContent.setUuid("739d55dcb220439197e52cfd3c875852");
		for (int i=3; i> 0; i--) {
			articleContent.setSectionNum(i);
			articleContent.setContent(i + "this is a text " + i);
			this.articleContentService.save(articleContent);
		}
	}

	@Test
	public void testFind() {
		List<ArticleContent> acList = null;
		acList = this.articleContentService.listArticleAllContent("739d55dcb220439197e52cfd3c875852");
		if (acList != null) {
			for (ArticleContent ac : acList) {
				System.out.println(ac.toString());
			}
		} else {
			System.out.println("no data!");
		}
	}

	@After
	public void tearDown() {
		System.out.println("test end!");
	}
}
