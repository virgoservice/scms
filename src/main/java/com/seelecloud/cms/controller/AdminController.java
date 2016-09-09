/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月10日 上午2:58:14
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月10日 上午2:58:14 
 * @email:ramostear@163.com 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "admin/index";
	}
	
	
}
