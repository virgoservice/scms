/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午5:50:32
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.testservice;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.service.ManagerService;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午5:50:32 
 * @email:ramostear@163.com 
 */
public class ManagerServiceTest {

	private ManagerService managerService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring.xml","classpath:/spring-mybatis.xml"});
		managerService = (ManagerService)context.getBean("managerService"); 
	}
	/**
	 * 测试管理员添加方法
	 */
	@Test
	public void testAddManager(){
		Manager manager = new Manager();
		manager.setManagerName("administrator");
		manager.setManagerNickname("超级管理员");
		manager.setPassword("123456");
		manager.setRoleId(1);
		manager.setCreateTime(new Date());
		managerService.save(manager);
	}
	
}
