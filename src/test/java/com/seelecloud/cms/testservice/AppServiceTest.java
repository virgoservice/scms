/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月23日 上午9:27:18
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.testservice;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.App;
import com.seelecloud.cms.service.AppService;

/** 
 * @Desc: (站点信息业务逻辑测试用例) 
 * @author: 谭朝红 
 * @date: 2016年8月23日 上午9:27:18 
 * @email:ramostear@163.com 
 */
public class AppServiceTest {

	private AppService appService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring.xml","classpath:/spring-mybatis.xml"});
		appService = (AppService)context.getBean("appService"); 
	}
	
	
	@Test
	public void testSave(){
		App app = new App();
		app.setAppName("贵州塞拉科技有限公司");
		app.setAppCopyright("黔ICP备521254111号");
		app.setAppDescription("让教育变得更简单");
		app.setAppKeyword("云服务");
		app.setAppLogo("SeeleCloud");
		app.setAppManagerId(2);
		app.setAppUrl("http://www.seelecloud.com");
		app.setCreateTime(new Date());
		appService.save(app);
		
	}
	
	@Test
	public void testUpdate(){
		App app = this.appService.findById(1);
		app.setAppDescription("桃李云让教育变得更简单！");
		this.appService.update(app);
	}
	
	@Test
	public void testFindById(){
		App app = this.appService.findById(1);
		assertNotNull(app);
	}
	
	@Test
	public void testFindByName(){
		App app = this.appService.findByName("贵州塞拉科技有限公司");
		assertNotNull(app);
		
	}
	@Test
	public void testFindByMangerId(){
		List<App> app = this.appService.findByManagerId(2);
		assertNotNull(app);
	}
	
	@Test
	public void testFindByUrl(){
		App app = this.appService.findByUrl("http://www.seelecloud.com");
		assertNotNull(app);
		
	}
	@Test
	public void testAppCountByManager(){
		int num = this.appService.appCountByManager(2);
		assertNotNull(num);
		System.out.println(num);
	}
	@Test
	public void testFindByPagAndManager(){
		List<App>  appList = this.appService.findByPageAndManager(2, 1, 10, "id", true);
		assertNotNull(appList);
	}
	
	
}
