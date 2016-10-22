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
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seelecloud.cms.consts.ConstString;
import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.entity.Role;
import com.seelecloud.cms.service.ManagerService;
import com.seelecloud.cms.service.RoleService;
import com.seelecloud.cms.vo.PermissionVo;

/**
 * @description: 用于权限管理操作: 给角色(role)添加模块操作权限，给管理员(manager)赋予角色身份
 * @author: vabo
 * @version:
 * @Datetime:2016年9月28日
 * @Email:
 */
@Controller
@RequestMapping("/admin/permission")
public class PermissionController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private ManagerService managerService;
	
	/**
	 * 查看用户所对应的权限角色列表
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/permissionList")
	public String listPermission(HttpSession session, Model model)
	{
		//1.获取当前登录的用户, 是不是应该写一个测试用的Manager
		Manager currentManager = (Manager)session.getAttribute("LoginManager");
		if(currentManager == null){
			currentManager = new Manager();
			currentManager.setId(2);
		}
		
		List<PermissionVo> permissionList = new ArrayList<PermissionVo>();
		List<Manager> managerList = new ArrayList<Manager>();
		managerList = this.managerService.ListAll();
		
		PermissionVo permissionVo;
		Role role;
		for(Manager manager: managerList)
		{
			role = this.roleService.findById(manager.getRoleId());
			if(role == null)
			{
				role = new Role();// 异常情况，可能server出错
				role.setRoleName("No Role");//表示用户还没有被授权角色
				role.setDescription("No Role");//表示用户还没有被授权角色
			}
			permissionVo = new PermissionVo(
							manager.getId(),
							manager.getManagerName(),
							role.getId(),
							role.getRoleName(),
							role.getDescription());
			
			permissionList.add(permissionVo);
		}
		model.addAttribute("permissionList", permissionList);
		
		return "permission/permissionList";
	}
	
	/**
	 * 移出指定用户的权限角色
	 * @param managerId
	 * @return
	 */
	@RequestMapping(value="/permissionRemove/{managerId}", method = RequestMethod.POST)
	public String removeManagerRole(@PathVariable int managerId)
	{
		Manager manager;
		manager = this.managerService.findById(managerId);
		if(manager != null)
		{
			//将角色从用户移出之后，用户角色id设置为 0，表示没有角色
			manager.setRoleId(ConstString.ROLE_NONE);
			this.managerService.update(manager);
		}
		return "redirect:/permission/permissionList";
	}

	/**
	 * 修改用户的角色
	 * @param managerId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/permissionEdit/{managerId}", method = RequestMethod.GET)
	public String editManagerRole(@PathVariable int managerId, Model model, HttpSession session)
	{
		Manager currentManager = (Manager)session.getAttribute("LoginManager");
		if(currentManager == null){
			currentManager = new Manager();
			currentManager.setId(2);
		}
		
		Manager manager;
		manager = this.managerService.findById(managerId);
		if(manager == null)
		{
			manager = new Manager();
		}
		model.addAttribute("manager", manager);
		 
		List<Role> roleList;
		roleList = this.roleService.findByManangerId(currentManager.getId());
		if(roleList == null)
		{
			// 当前管理员没有创建角色
		}
		else
		{
			model.addAttribute("roleList", roleList);
		}
		
		return "/permission/permissionEdit";
	}
	
}
