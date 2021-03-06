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

import com.seelecloud.cms.entity.ChannelContent;
import com.seelecloud.cms.service.ChannelContentService;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class ChannelContentServiceTest {

	private ChannelContentService channelContentService;
	
	@Before
	public void before() {
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring.xml",
						"classpath:/spring-mybatis.xml" });
		channelContentService = (ChannelContentService)context.getBean("channelContentService");
	}
	
	@Ignore
	@Test
	public void testSave() {
		ChannelContent cc = new ChannelContent();
		cc.setId(0);
		cc.setType(3);
		cc.setContentId(1);
		this.channelContentService.save(cc);
	}
	
	@Test
	public void testFind() {
		List<ChannelContent> ccList = null;
		ccList = this.channelContentService.listAllById(0);
		if(ccList != null)
		{
			for(ChannelContent cc: ccList)
			{
				System.out.print(cc.toString());
			}
		}
		else{
			System.out.print("no data");
		}
	}
	
	@After
	public void tearDown()
	{
		System.out.println(" test end !");			
	}
}
