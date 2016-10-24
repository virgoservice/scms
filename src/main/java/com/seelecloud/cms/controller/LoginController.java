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

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final transient Logger log = LoggerFactory
			.getLogger(LoginController.class);

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
		log.info(username + ":" + password);

		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username,
					password);
			token.setRememberMe(true);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				log.info("There is no user with username of "
						+ token.getPrincipal());
			} catch (IncorrectCredentialsException ice) {
				log.info("Password for account " + token.getPrincipal()
						+ " was incorrect!");
			} catch (LockedAccountException lae) {
				log.info("The account for username " + token.getPrincipal()
						+ " is locked.  "
						+ "Please contact your administrator to unlock it.");
			}
			// ... catch more exceptions here (maybe custom ones specific to
			// your application?
			catch (AuthenticationException ae) {
				// unexpected condition? error?
			}
		} else {
			log.info("user has authc!");
		}

		// 验证是否成功登录的方法
		if (currentUser.isAuthenticated()) {
			Manager loginManager = new Manager();
			loginManager = this.manangerService.findByName(username);
			// authenticate password and authorization
			session.setAttribute("LoginManager", loginManager);
			return "redirect:/admin/index";
		}

		// session.removeAttribute("cc");

		return "admin/login";
	}

	/**
	 * sign out, remove session
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// remove session

		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:admin/login";
	}

}
