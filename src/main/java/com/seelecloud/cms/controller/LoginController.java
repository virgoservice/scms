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

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.service.ManagerService;

/**
 * @Desc: ()
 * @author: 谭朝红
 * @date: 2016年9月12日 下午4:29:09
 * @email:ramostear@163.com
 */
@Controller
@RequestMapping("/manager")
public class LoginController {

	@Autowired
	private ManagerService manangerService;

	/**
	 * 跳转到登录界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	/**
	 * 登录验证成功，将登录信息写入session
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAuthenticate(String username, String password,
			String checkcode, Model model, HttpSession session) {
		// String cc = (String)session.getAttribute("cc");
		// if(!cc.equals(checkcode)) {
		// model.addAttribute("error","验证码出错，请重新输入");
		// return "admin/login";
		// }

		Manager loginManager = new Manager();
		loginManager = this.manangerService.findByName(username);
		// authenticate password and authorization

		session.setAttribute("LoginManager", loginManager);
		// session.removeAttribute("cc");

		return "admin/index";
	}

	/**
	 * sign out, remove session
	 */
	public String logout(HttpSession session) {
		// remove session

		return "redirect:admin/login";
	}

}
