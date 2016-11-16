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

import com.seelecloud.cms.entity.Channel;
import com.seelecloud.cms.service.ChannelService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class ChannelServiceTest {

	private ChannelService channelService;

	@Before
	public void before() {
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring.xml",
						"classpath:/spring-mybatis.xml" });
		channelService = (ChannelService) context.getBean("channelService");
	}

	@Test
	public void testSave() {
		Channel ch = new Channel();
		
		int i = 5;
		while (i-- >= 1) {
			ch.setId(i);
			ch.setTitle("channel-" + i);
			this.channelService.save(ch);
		}
	}
	
	@Ignore
	@Test
	public void testFind() {
		Channel ch = null;

		ch = this.channelService.findChannelById(1);
		if(ch != null)
		{
			System.out.println(ch.toString());
		}
		else{
			System.out.println(" no found!");			
		}
	}
	
	@After
	public void tearDown()
	{
		System.out.println(" test end !");			
	}
}
