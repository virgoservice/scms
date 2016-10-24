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

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.ContentType;
import com.seelecloud.cms.service.ContentTypeService;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class ContentTypeServiceTest {

	private ContentTypeService contentTypeService;
	
	@Before
	public void before(){
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring.xml","classpath:/spring-mybatis.xml"});
		contentTypeService = (ContentTypeService)context.getBean("contentTypeService");
	}
	
	@Test
	public void testSave()
	{
		ContentType contentType = new ContentType();
		contentType.setId(4);
		contentType.setName("media");
		contentType.setDescription("media");
		this.contentTypeService.save(contentType);
	}

	@Ignore
	@Test
	public void testUpdate()
	{
		ContentType contentType = new ContentType();
		contentType.setId(2);
		contentType.setName("article");
		contentType.setDescription("description");
		this.contentTypeService.save(contentType);
	}
	
	@Test
	public void testFindById()
	{
		ContentType contentType = null;
		contentType = this.contentTypeService.findById(3);
		if(contentType != null)
		{
			System.out.println(contentType.toString());
		}
		else{
			System.out.println("no found!");
		}
	}
	
	@Ignore
	@Test
	public void testFindByName()
	{
		ContentType contentType = null;
		contentType = this.contentTypeService.findByName("article");
		if(contentType != null)
		{
			System.out.println(contentType.toString());
		}
		else{
			System.out.println("no found!");
		}
	}
	
	@After
	public void tearDown()
	{
		System.out.println("test end!");
	}
}
