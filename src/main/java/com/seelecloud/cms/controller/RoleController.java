/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.entity.Role;
import com.seelecloud.cms.service.ManagerService;
import com.seelecloud.cms.service.ModuleService;
import com.seelecloud.cms.service.RoleModuleService;
import com.seelecloud.cms.service.RoleService;

/**
 * @description: 查看管理所创建的角色列表，创建一个新角色，修改已经存在的角色信息，删除一个已经存在的角色
 * @author: vabo
 * @version:
 * @Datetime:2016年9月19日
 * @Email:
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {

	private static Logger log= Logger.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;

	/**
	 * 获取管理员列表
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/roleList")
	public String managerList(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		// 1.获取当前登录的用户
		Manager currentManager = (Manager) session.getAttribute("LoginManager");
		if (currentManager == null) {
			currentManager = new Manager();
			currentManager.setId(2);
		}
		String offsetStr = request.getParameter("offset");
		int offset = 0;
		if (offsetStr != null) {
			offset = Integer.parseInt(offsetStr);
		}
		int size = 10;
		String sizeStr = request.getParameter("size");
		if (sizeStr != null) {
			size = Integer.parseInt(sizeStr);
		}
		// 2.根据当前的用户获取他所创建的role
		// List<Role> roleList = roleService.findByPage(currentManager.getId(),
		// offset, size, "id", true);
		List<Role> roleList = roleService.findByManangerId(currentManager
				.getId());

		// 3.返回查询到的数据
		model.addAttribute("roleList", roleList);
		return "role/roleList";
	}

	/**
	 * 跳转到角色创建
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/toRoleSave", method = RequestMethod.GET)
	public String toRoleSave(Model model) {
		model.addAttribute("role", new Role());
		return "role/roleSave";
	}

	/**
	 * 创建一个新角色
	 * 
	 */
	@RequestMapping(value = "/roleSave", method = RequestMethod.POST)
	public String roleSave(@Valid Role role, BindingResult br, Model model) {
		// 如果校验失败，则重新返回添加页面，进行修改
		log.error("++++" + role.getRoleName());
		if (br.hasErrors()) {
			model.addAttribute("role", new Role());
			return "role/roleSave";
		}
		role.setCreateTime(new Date());
		role.setManagerId(2);
		this.roleService.save(role);
		return "redirect:/admin/role/roleList";
	}

	/**
	 * 删除一个已经存在的角色
	 */
	@RequestMapping(value = "/roleDelete/{roleId}", method = RequestMethod.POST)
	public String roleDelete(@PathVariable int roleId) {
		// 是否删除成功?
		this.roleService.delete(roleId);
		return "redirect:/admin/role/roleList";
	}

	/**
	 * 更改一个已经存在角色的信息
	 */
	@RequestMapping(value = "/toRoleEdit/{roleId}", method = RequestMethod.GET)
	public String roleUpdate(@PathVariable int roleId, Model model) {
		Role role = new Role();
		role = roleService.findById(roleId);
		model.addAttribute("role", role);
		log.error(role.getRoleName());
		log.error(role.getManagerId());
		return "role/roleEdit";
	}

	@RequestMapping(value = "/roleEdit", method = RequestMethod.POST)
	public String roleUpdate(@Valid Role role, BindingResult br, Model model) {
		log.error("===" + role.getRoleName());
		if (br.hasErrors()) {
			model.addAttribute("role", new Role());
			return "redirect:/admin/role/roleList";
		}
		log.error(role.getCreateTime());
		log.error("mmm"+role.getManagerId());
		role.setCreateTime(new Date());
		role.setManagerId(2);
		this.roleService.update(role);
		return "redirect:/admin/role/roleList";
	}
}
