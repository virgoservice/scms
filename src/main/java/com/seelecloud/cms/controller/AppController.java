/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月21日 下午2:10:42
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seelecloud.cms.service.AppService;

/** 
 * @Desc: (站点信息Controller) 
 * @author: 谭朝红 
 * @date: 2016年9月21日 下午2:10:42 
 * @email:ramostear@163.com 
 */
@Controller
@RequestMapping("/admin/app")
public class AppController {
	/**
	 * 站点信息Service
	 */
	@Autowired
	private AppService appService;
	
	/**
	 * 跳转到站点信息页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toAppInfo",method=RequestMethod.GET)
	public String toAppInfo(Model model){
		//TODO 只添加了页面跳转逻辑，后续方法待具体实现人员添加[author:谭朝红]
		return "app/appInfo";
	}
	
	

}
