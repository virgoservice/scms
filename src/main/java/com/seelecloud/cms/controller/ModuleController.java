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

import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.entity.Module;
import com.seelecloud.cms.service.ModuleService;
import com.seelecloud.cms.service.RoleModuleService;

/**
 * @description: 模块管理， 查询模块，修改模块信息，删除模块【增删操作的影响】
 * @author: vabo
 * @version:
 * @Datetime:2016年9月28日
 * @Email:
 */
@Controller
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	ModuleService moduleService;
	@Autowired
	RoleModuleService roleModuleService;

	/**
	 * 查询指定用户 所拥有操作权限的所有模块
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/moduleList")
	public String listModuleByRole(HttpSession session, Model model) {
		// 1.获取当前登录的用户的角色id
		Manager currentManager = (Manager) session.getAttribute("LoginManager");
		if (currentManager == null) {
			currentManager = new Manager();
			currentManager.setRoleId(1);
		}
		int roleId = currentManager.getRoleId();

		// 2 查询当前角色id 可以操作的所有模块id
		// List<Integer> moduleIds;// = new ArrayList<Integer>();
		// moduleIds = this.roleModuleService.findModuleIdsByRole(roleId);

		// 3 通过模块id 查询模块详细信息
		List<Module> moduleList = new ArrayList<Module>();

		//moduleList = this.moduleService.findByRoleId(roleId);
		model.addAttribute("moduleList", moduleList);
		return "module/moduleList";
	}

	/**
	 * 修改一个已经存在的模块信息:(允许修改哪一些信息,name,parent,icon,creator)
	 */
	public String editModule() {
		// 注意检查指定的parent id 是否会引起环
		return "module/moduleEdit";
	}

	/**
	 * 添加一个模块
	 */
	@RequestMapping(value = "/toModuleSave", method = RequestMethod.GET)
	public String toModuleSave(Model model) {
		model.addAttribute("module", new Module());
		return "/module/moduleSave";
	}

	@RequestMapping(value = "/moduleSave", method = RequestMethod.POST)
	public String toModuleSave(@Valid Module module, BindingResult br,
			HttpSession session, Model model) {
		// 获取当前登录的用户
		Manager currentManager = (Manager) session.getAttribute("LoginManager");
		if (currentManager == null) {
			currentManager = new Manager();
			currentManager.setId(2);
		}

		module.setCreateTime(new Date());
		module.setManagerId(currentManager.getId());
		this.moduleService.save(module);
		return "/module/moduleList";
	}

	/**
	 * 删除一个已经存在的模块，注意删除
	 */
	@RequestMapping(value = "/moduleDelete/{moduleId}", method = RequestMethod.POST)
	public String deleteModule(@PathVariable int moduleId) {
		// 查询
		Module module = this.moduleService.findById(moduleId);
		if (module == null) {
			// 查询异常，返回
		}

		// 删除
		this.moduleService.delete(moduleId);

		return "/module/moduleList";
	}
}
