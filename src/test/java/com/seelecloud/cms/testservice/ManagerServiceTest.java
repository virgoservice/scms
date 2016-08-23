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
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.service.ManagerService;

import static org.junit.Assert.*;

/** 
 * @Desc: (管理员业务层测试) 
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
		manager.setManagerName("appadmin");
		manager.setManagerNickname("站点管理员");
		manager.setPassword("123456");
		manager.setRoleId(2);
		manager.setCreateTime(new Date());
		managerService.save(manager);
	}
	@Test
	public void testUpdate(){
		Manager manager = this.managerService.findById(2);
		assertNotNull(manager);
		manager.setManagerNickname("系统管理员");
		this.managerService.update(manager);
		System.out.println(manager.getManagerNickname());
	}
	@Test
	public void testFindByName(){
		Manager manger = this.managerService.findByName("administrator");
		assertNotNull(manger);
	}
	@Test
	public void testDelete(){
		Manager manager = this.managerService.findById(4);
		assertNotNull(manager);
		this.managerService.delete(manager.getId());
		Manager m = this.managerService.findById(4);
		assertNull(m);
	}
	
	@Test
	public void testFindAll(){
		List<Manager> managerList = this.managerService.ListAll();
		assertSame(1, managerList.size());
	}
	
}
