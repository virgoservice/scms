/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月12日 下午4:29:09
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月12日 下午4:29:09 
 * @email:ramostear@163.com 
 */
@Controller
@RequestMapping("/manager")
public class LoginController {

	/**
	 * 跳转到登录界面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "admin/login";
	}
	
	
	
}
