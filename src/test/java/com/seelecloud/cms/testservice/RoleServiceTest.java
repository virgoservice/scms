/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月6日 下午10:22:54
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.testservice;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.Role;
import com.seelecloud.cms.service.RoleService;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午10:22:54 
 * @email:ramostear@163.com 
 */
public class RoleServiceTest {

	private RoleService roleService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring.xml","classpath:/spring-mybatis.xml"});
		roleService = (RoleService)context.getBean("roleService"); 
	}
	
	@Test
	public void testSave(){
		Role role = new Role();
		role.setManagerId(2);
		role.setRoleName("超级管理员");
		role.setCreateTime(new Date());
		this.roleService.save(role);
		
	}
	
	@Test
	public void testFindById(){
		Role role = this.roleService.findById(1);
		assertNotNull(role);
	}
	
	@Test
	public void testFindByManagerId(){
		List<Role> roleList = this.roleService.findByManangerId(2);
		assertNotNull(roleList);
	}
}
