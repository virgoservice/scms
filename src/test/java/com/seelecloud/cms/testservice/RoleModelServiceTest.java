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

import com.seelecloud.cms.entity.RoleModel;
import com.seelecloud.cms.service.RoleModelService;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午10:22:54 
 * @email:ramostear@163.com 
 */
public class RoleModelServiceTest {

	private RoleModelService roleModelService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring.xml","classpath:/spring-mybatis.xml"});
		roleModelService = (RoleModelService)context.getBean("roleModelService"); 
	}
	
	
	@Test
	public void testSave(){
		RoleModel roleModel = new RoleModel(1, 2);
		this.roleModelService.save(roleModel);
	}
	@Test
	public void testfindById(){
		RoleModel roleModel = this.roleModelService.findById(1);
		assertNotNull(roleModel);
		
	}
	@Test
	public void testUpdate(){
		RoleModel roleModel = this.roleModelService.findById(2);
		roleModel.setModelId(3);
		this.roleModelService.update(roleModel);
		
	}
	
	@Test
	public void testDelete(){
		RoleModel roleModel = this.roleModelService.findById(2);
		this.roleModelService.delete(roleModel.getId());
	}
	
	@Test
	public void testFindModelIdsByRole(){
		List<Integer> modelIds = this.roleModelService.findModelIdsByRole(1);
		assertNotNull(modelIds);
	}
	
	@Test
	public void testFindRoleIdsByModel(){
		List<Integer> roleIds = this.roleModelService.findModelIdsByRole(1);
		assertNotNull(roleIds);
	}
	
	@Test
	public void testDeleteByRoleId(){
		this.roleModelService.deleteByRoleId(1);
	}
	
	
}
