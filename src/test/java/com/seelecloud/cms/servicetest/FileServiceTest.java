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

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.FileEntity;
import com.seelecloud.cms.service.FileService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
public class FileServiceTest {

	private FileService fileService;

	@Before
	public void before() {
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring.xml",
						"classpath:/spring-mybatis.xml" });
		fileService = (FileService) context.getBean("fileService");
	}

	@Ignore
	@Test
	public void testSave() {
		FileEntity file = new FileEntity();
		for (int i = 0; i < 10; i++) {
			file.setCreatorId(i);
			file.setCreateTime(new Date());
			this.fileService.save(file);
		}
	}

	@Ignore
	@Test
	public void testUpdate() {
		FileEntity file = new FileEntity();
		file.setId(4);
		file.setCreateTime(new Date());
		this.fileService.update(file);
	}

	@Ignore
	@Test
	public void testDelete() {
		this.fileService.deleteById(5);
	}

	@Test
	public void testFind() {
		FileEntity file = null;
		file = this.fileService.findById(1);
		if (file != null) {
			System.out.print("find:" + file.getId());
		}
	}

	@Test
	public void testListByChannel() {
		List<FileEntity> list = null;
		list = this.fileService.listByChannel(0);
		if (list != null) {
			for (FileEntity f : list) {
				System.out.println(f.getCreatorId());
			}
		}
	}

	@Test
	public void testListByCreator() {
		List<FileEntity> list = null;
		list = this.fileService.listByCreator(0);
		if (list != null) {
			for (FileEntity f : list) {
				System.out.println(f.getCreatorId());
			}
		}
	}
}
