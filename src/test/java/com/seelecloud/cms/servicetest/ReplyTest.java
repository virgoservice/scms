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

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.Reply;
import com.seelecloud.cms.service.ReplyService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月31日
 * @Email:
 */
public class ReplyTest {

	private static ReplyService replyService;

	@BeforeClass
	public static void before() {
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring.xml",
						"classpath:/spring-mybatis.xml" });
		replyService = (ReplyService) context.getBean("replyService");
	}

	@Ignore
	@Test
	public void testSave() {
		Reply reply = new Reply();

//		reply.setCommentId(1);
//		reply.setParentId(-1);
//		for (int i = 1; i < 4; i++) {
//			reply.setId(i);
//			reply.setText("text " + i);
//			replyService.save(reply);
//		}

		reply.setCommentId(1);
		reply.setParentId(2);
		for (int i = 4; i < 8; i++) {
			reply.setId(i);
			reply.setText("text " + i);
			replyService.save(reply);
		}

		reply.setCommentId(2);
		reply.setParentId(-1);
		for (int i = 8; i < 12; i++) {
			reply.setId(i);
			reply.setText("text " + i);
			replyService.save(reply);
		}

		reply.setParentId(9);
		for (int i = 12; i < 14; i++) {
			reply.setId(i);
			reply.setText("text " + i);
			replyService.save(reply);
		}

		reply.setCommentId(3);
		reply.setParentId(-1);
		for (int i = 14; i < 18; i++) {
			reply.setId(i);
			reply.setText("text " + i);
			replyService.save(reply);
		}
	}

	@Ignore
	@Test
	public void testUpdate() {

	}

	@Ignore
	@Test
	public void testDeleteById() {

	}

//	@Ignore
	@Test
	public void testDeleteByParentId() {
		List<Integer> parentIds = new ArrayList<Integer>();
		parentIds.add(2);
		parentIds.add(9);
		replyService.deleteByParentIds(parentIds);
	}

	@Ignore
	@Test
	public void testDeleteByCommentId() {

	}

	@Ignore
	@Test
	public void testListByParentId() {

	}

	@Ignore
	@Test
	public void testListByCommentId() {

	}

	@AfterClass
	public static void tearDown() {
		System.out.println("test end\n");
	}

}
