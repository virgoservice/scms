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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.entity.Module;
import com.seelecloud.cms.entity.Role;
import com.seelecloud.cms.entity.RoleModule;
import com.seelecloud.cms.service.ModuleService;
import com.seelecloud.cms.service.RoleModuleService;
import com.seelecloud.cms.service.RoleService;
import com.seelecloud.cms.vo.ModuleVo;

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

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleModuleService roleModuleService;

	@Autowired
	private ModuleService moduleService;

	/**
	 * 跳转到角色列表显示页
	 * @return
	 */
	@RequestMapping("/roleList")
	public String roleList(HttpSession session, Model model) {
		
		// 1.获取当前登录的用户
		Manager currentManager = (Manager) session.getAttribute("LoginManager");
		if (currentManager == null) {
			currentManager = new Manager();
			currentManager.setId(2);
		}
		// 2.根据当前的用户获取他所创建的roles, 只是为了获取总记录数
		List<Role> roleList = this.roleService.findByManangerId(currentManager.getId());
		model.addAttribute("totalSize", roleList.size());
		//跳转页面，由分页查找去获取列表数据
		return "role/roleList";
	}
	
	/**
	 * 分页获取管理员创建的所有角色
	 * @param page
	 * @param pageSize
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/ajaxRoleList")
	@ResponseBody
	public List<Role> pagingRoleList(@RequestParam(value="page",defaultValue="1")int page,
									@RequestParam(value="pageSize",defaultValue="10")int pageSize, 
									HttpSession session, Model model) {
		// 1.获取当前登录的用户
		Manager currentManager = (Manager) session.getAttribute("LoginManager");
		if (currentManager == null) {
			currentManager = new Manager();
			currentManager.setId(2);
		}
		// 2.根据当前的用户获取他所创建的roles
		List<Role> roleList = roleService.findByPage(currentManager.getId(), ((page-1)>0?(page-1):0)*pageSize, pageSize, "id", true);
		return roleList;
	}

	/**
	 * 跳转到角色创建
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/toRoleSave", method = RequestMethod.GET)
	public String toSaveRole(Model model) {
		model.addAttribute("role", new Role());
		return "role/roleSave";
	}

	/**
	 * 创建一个新角色
	 * @param role 表单提交的role值
	 * @param session 用以获取当前用户id
	 * @return  创建新角色完成成功后返回角色列表，否则返回创建界面
	 */
	@RequestMapping(value = "/roleSave", method = RequestMethod.POST)
	public String saveRole(@Valid Role role, BindingResult br, HttpSession session, Model model) {
		// 如果校验失败，则重新返回添加页面，进行修改
		if (br.hasErrors()) {
			model.addAttribute("role", new Role());
			return "role/roleSave";
		}
		
		// 获取当前登录的用户
		Manager currentManager = (Manager) session.getAttribute("LoginManager");
		if (currentManager == null) {
			currentManager = new Manager();
			currentManager.setId(2);
		}
		role.setCreateTime(new Date());
		role.setManagerId(currentManager.getId());
		this.roleService.save(role);
		return "redirect:/admin/role/roleList";
	}

	/**
	 * 删除一个已经存在的角色
	 * @param roleId 需要被删除角色的id
	 * @return 返回角色列表页面
	 */
	@RequestMapping(value = "/roleDelete/{roleId}", method = RequestMethod.POST)
	public String deleteRole(@PathVariable int roleId) {
		// 是否删除成功?
		if(roleId >= 1)//auto-increment begin from 1
		{
			this.roleService.delete(roleId);
		}
		return "redirect:/admin/role/roleList";
	}

	/**
	 * 更改一个已经存在角色的信息
	 * @param roleId 需要更改的角色id
	 * @return 跳转到角色编辑页面
	 */
	@RequestMapping(value = "/toRoleEdit/{roleId}", method = RequestMethod.GET)
	public String toEditRole(@PathVariable int roleId, Model model) {
		Role role = new Role();
		role = roleService.findById(roleId);
		model.addAttribute("role", role);
		return "role/roleEdit";
	}

	/**
	 * 更改已经存在的角色的信息
	 * @param roleId 需要更改的角色的id
	 * @param role 表单提交的更新的角色信息，将被存入数据库
	 * @param br
	 * @param model
	 * @return 更改成功后返回角色列表页
	 */
	@RequestMapping(value = "/roleEdit/{roleId}", method = RequestMethod.POST)
	public String editRole(@PathVariable int roleId, @Valid Role role, BindingResult br, Model model) {
		if (br.hasErrors()) {
			model.addAttribute("role", new Role());
			return "role/roleEdit";
		}
		Role roleTemp = this.roleService.findById(roleId);
		roleTemp.setRoleName(role.getRoleName());
		roleTemp.setDescription(role.getDescription());
		this.roleService.update(roleTemp);
		return "redirect:/admin/role/roleList";
	}
	
	
	/************************************************************************************************/
	@RequestMapping(value = "/roleModule/{roleId}", method = RequestMethod.GET)
	public String listRoleModule(@PathVariable int roleId, Model model) {
		model.addAttribute("roleId", roleId);

		// only need page view, get data by AJAX method
		return "role/roleModuleTree";
	}

	/**
	 * 查看指定角色的所有的可操作模块
	 */
	@RequestMapping(value = "/roleModuleData/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ModuleVo> listRoleModule(@PathVariable int roleId) {
		// 1 获取角色id 对应所有的module ids
		List<Integer> moduleIds = this.roleModuleService
				.findModuleIdsByRole(roleId);

		// 2 查询mid对应的模块详细
		List<Module> moduleList = new ArrayList<Module>();
		Module module = new Module();
		for (int id : moduleIds) {
			module = this.moduleService.findById(id);
			moduleList.add(module);
		}

		// 3 生成模块树展现
		List<ModuleVo> mvList = new ArrayList<ModuleVo>();
		ModuleVo mv = null;
		for (Module m : moduleList) {
			mv = new ModuleVo(m.getId(), m.getModuleName(), m.getParentId(),
					null, null, 0, null);
			if (m.getParentId() == -1) {
				mv.setParentId(0);
			}
			mvList.add(mv);
		}

		return mvList;
	}

	/**
	 * 修改可以操作模块
	 */
	@RequestMapping(value = "/roleModuleEditData/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ModuleVo> editRoleModule(@PathVariable int roleId) {
		// 1 获取当前登录的用户
		// Manager currentManager = (Manager)
		// session.getAttribute("LoginManager");
		// if (currentManager == null) {
		// //return "error";// invalid login info
		// }
		int managerRoleId = 1;

		List<Integer> managerModuleIds = this.roleModuleService.findModuleIdsByRole(managerRoleId);
		List<Module> moduleList = new ArrayList<Module>();
		Module module = new Module();
		for (int id : managerModuleIds) {
			module = this.moduleService.findById(id);
			// if(module != null)
			{
				moduleList.add(module);
			}
		}

		// 2 指定角色所有的模块，更新VO
		List<Integer> roleModuleIds = this.roleModuleService.findModuleIdsByRole(roleId);

		// 3 tree展示
		List<ModuleVo> mvList = new ArrayList<ModuleVo>();
		ModuleVo mv = null;
		for (Module m : moduleList) {
			int checked = 0;
			int id = m.getId();
			for (int i : roleModuleIds) {
				if (id == i) {
					checked = 1;
					break;
				}
			}// TODO 应该被优化

			// building module tree
			mv = new ModuleVo(m.getId(), m.getModuleName(), m.getParentId(),
					null, null, checked, null);
			if (m.getParentId() == -1) {
				mv.setParentId(0);
			}
			mvList.add(mv);
		}

		return mvList;
	}
	
	@RequestMapping(value = "/roleModuleEdit/{roleId}", method = RequestMethod.GET)
	public String toRoleModuleEdit(@PathVariable int roleId, Model model) {
		model.addAttribute("roleId", roleId);
		return "/role/roleModuleTreeEdit";
	}

	/**
	 * 修改成功后，返回指定角色模块页面
	 */
	@RequestMapping(value = "/ajaxSendRoleModuleEdit", method = RequestMethod.POST)
	public String editRoleModule(@RequestParam("roleId") int roleId,
			@RequestParam("moduleIds[]") int[] moduleIds) {

		// 1 delete all old r-m records
		this.roleModuleService.deleteByRoleId(roleId);

		// 2 add new r-m records
		RoleModule rm = new RoleModule();
		rm.setRoleId(roleId);
		for (int i = 0; i < moduleIds.length; i++)// effect is lowly ?
		{
			rm.setModuleId(moduleIds[i]);
			this.roleModuleService.save(rm);
		}

		return "redirect:/admin/role/roleModule/" + roleId;
	}
	
}
