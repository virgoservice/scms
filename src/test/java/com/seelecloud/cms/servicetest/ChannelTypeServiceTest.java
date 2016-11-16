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

import com.seelecloud.cms.entity.ChannelType;
import com.seelecloud.cms.service.ChannelTypeService;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class ChannelTypeServiceTest {

	private ChannelTypeService channelTypeService;
	
	@Before
	public void before(){
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring.xml","classpath:/spring-mybatis.xml"});
		channelTypeService = (ChannelTypeService)context.getBean("channelTypeService");
	}
	
	@Test
	public void testSave()
	{
		ChannelType ChannelType = new ChannelType();
		ChannelType.setId(4);
		ChannelType.setName("media");
		ChannelType.setDescription("media");
		this.channelTypeService.save(ChannelType);
	}

	@Ignore
	@Test
	public void testUpdate()
	{
		ChannelType ChannelType = new ChannelType();
		ChannelType.setId(2);
		ChannelType.setName("article");
		ChannelType.setDescription("description");
		this.channelTypeService.save(ChannelType);
	}
	
	@Test
	public void testFindById()
	{
		ChannelType ChannelType = null;
		ChannelType = this.channelTypeService.findById(3);
		if(ChannelType != null)
		{
			System.out.println(ChannelType.toString());
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
