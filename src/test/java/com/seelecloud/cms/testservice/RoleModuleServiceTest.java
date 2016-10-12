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

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.RoleModule;
import com.seelecloud.cms.service.RoleModuleService;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午10:22:54 
 * @email:ramostear@163.com 
 */
public class RoleModuleServiceTest {

	private RoleModuleService roleModuleService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring.xml","classpath:/spring-mybatis.xml"});
		roleModuleService = (RoleModuleService)context.getBean("roleModuleService"); 
	}
	
	
	@Test
	public void testSave(){
		RoleModule roleModel = new RoleModule(1, 2);
		this.roleModuleService.save(roleModel);
	}
	@Test
	public void testfindById(){
		RoleModule roleModel = this.roleModuleService.findById(1);
		assertNotNull(roleModel);
		
	}
	@Test
	public void testUpdate(){
		RoleModule roleModel = this.roleModuleService.findById(2);
		roleModel.setModuleId(3);
		this.roleModuleService.update(roleModel);
		
	}
	
	@Test
	public void testDelete(){
		RoleModule roleModel = this.roleModuleService.findById(2);
		this.roleModuleService.delete(roleModel.getId());
	}
	
	@Test
	public void testFindModelIdsByRole(){
		List<Integer> modelIds = this.roleModuleService.findModuleIdsByRole(1);
		assertNotNull(modelIds);
	}
	
	@Test
	public void testFindRoleIdsByModel(){
		List<Integer> roleIds = this.roleModuleService.findModuleIdsByRole(1);
		assertNotNull(roleIds);
	}
	
	@Test
	public void testDeleteByRoleId(){
		this.roleModuleService.deleteByRoleId(1);
	}
	
	
}
