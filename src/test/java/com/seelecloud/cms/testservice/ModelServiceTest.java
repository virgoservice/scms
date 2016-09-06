/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月6日 下午2:37:44
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

import com.seelecloud.cms.entity.Model;
import com.seelecloud.cms.service.ModelService;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月6日 下午2:37:44 
 * @email:ramostear@163.com 
 */
public class ModelServiceTest {

	private ModelService modelService;
	
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring.xml","classpath:/spring-mybatis.xml"});
		modelService = (ModelService)context.getBean("modelService"); 
	}
	
	
	@Test
	public void testSave(){
		Model model = new Model();
		model.setManagerId(2);
		model.setModelName("站点管理");
		model.setParentId(-1);
		model.setModelUrl("#");
		model.setModelIcon("&5150");
		model.setCreateTime(new Date());
		modelService.save(model);
		
	}
	
	@Test
	public void testFindById(){
		Model model = this.modelService.findById(1);
		model.setCreateTime(new Date());
		this.modelService.update(model);
	}
	
	@Test
	public void testFindByParent(){
		List<Model> modelList = this.modelService.findByParent(-1);
		System.out.println(modelList.size());
	}
	
	@Test
	public void testFindByManagerId(){
		List<Model> modelList = this.modelService.findByManagerId(2);
		System.out.println(modelList.size());
		
	}
	
	
	
}
