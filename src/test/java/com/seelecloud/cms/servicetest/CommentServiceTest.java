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

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.Comment;
import com.seelecloud.cms.service.CommentService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月29日
 * @Email:
 */
public class CommentServiceTest {

	private CommentService commentService;

	@Before
	public void before() {
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring.xml",
						"classpath:/spring-mybatis.xml" });
		this.commentService = (CommentService) context
				.getBean("commentService");
	}

	@Ignore
	@Test
	public void testSave() {
		Comment comment = new Comment(13, 2, 1, 10, 0, (byte)1, 	6, new Date(), "test null");
		
		System.out.println(comment.toString());
//		comment.setText("3333");
		this.commentService.save(comment);

		comment.setId(14);
		comment.setText(null);
		this.commentService.save(comment);

	}

	@After
	public void tearDown() {
		System.out.println("the end!");
	}
}
