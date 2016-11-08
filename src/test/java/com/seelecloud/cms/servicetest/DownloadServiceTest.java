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

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seelecloud.cms.entity.Download;
import com.seelecloud.cms.service.DownloadService;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
public class DownloadServiceTest {

	@Autowired
	private DownloadService downloadService;
	
	@Before
	public void before() {
		System.out.print("begin test!");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/spring.xml",
						"classpath:/spring-mybatis.xml" });
		downloadService = (DownloadService) context.getBean("downloadService");
	}

	@Ignore
	@Test
	public void testSave(){
		Download download = new Download();
		for(int i=0; i < 10; i++){
		download.setTime(new Date(i*100000000));
		download.setUserId(i);
		this.downloadService.save(download);
		}
	}
	
	@Ignore
	@Test
	public void testGetTotalCount(){
		int total = 0;
		Date start = new Date(0);
		Date end = new Date();
		total = this.downloadService.getTotalByTime(0, 0, start, end);
		System.out.println(start.toString() + " total = " + total);
	}
	
	@Test
	public void testListByTime(){
		List<Download> downloadList = null;
		downloadList = this.downloadService.listByTime(0, 0, new Date(0), new Date());
		if(downloadList != null)
		{
			for(Download d:downloadList)
			System.out.println(d.getId() + " ++ " + d.getTime());
		}
	}
	
	@Test
	public void testListByResource(){
		List<Download> downloadList = null;
		downloadList = this.downloadService.listByResource(0, 0);
		if(downloadList != null)
		{
			for(Download d:downloadList)
				System.out.println(d.getId() + " == " + d.getTime());
		}
	}
	
	@After
	public void teardown(){
		System.out.println("the end !!");
	}
}
