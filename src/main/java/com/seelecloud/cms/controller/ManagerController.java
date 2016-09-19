/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年9月17日 下午9:01:27
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.service.ManagerService;

/** 
 * @Desc: (管理员COntroller) 
 * @author: 谭朝红 
 * @date: 2016年9月17日 下午9:01:27 
 * @email:ramostear@163.com 
 */
@Controller
@RequestMapping("/admin/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	/**
	 * 获取管理员列表
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/managerList")
	public String managerList(HttpSession session,HttpServletRequest request,HttpServletResponse response, Model model){
		//1.获取当前登录的用户
		Manager currentManager = (Manager)session.getAttribute("LoginManager");
		if(currentManager == null){
			currentManager = new Manager();
			currentManager.setId(2);
		}
		String offsetStr = request.getParameter("offset");
		int offset = 0;
		if(offsetStr != null){
			offset = Integer.parseInt(offsetStr);
		}
		int size = 10;
		String sizeStr = request.getParameter("size");
		if(sizeStr != null){
			size = Integer.parseInt(sizeStr);
		}
		//2.根据当前的用户获取他所创建的子管理员
		List<Manager> managerList = managerService.findByPage(currentManager.getId(), offset, size, "id", true);
		//3.返回查询到的数据
		model.addAttribute("managerList", managerList);
		return "manager/managerList";
	}
	
	/**
	 * 跳转到添加管理员界面，需要通过Spring的Model为前台准备好Manager对象的初始数据绑定
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toManagerSave",method=RequestMethod.GET)
	public String toManagerSave(Model model){
		model.addAttribute("manager", new Manager());
		return "manager/managerSave";
	}
	
	/**
	 * 向数据库插入一条manager数据
	 * @param manager  校验对象manager,如果校验通过，则向数据执行插入操作
	 * @param br
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/managerSave",method=RequestMethod.POST)
	public String managerSave(@Valid Manager manager,BindingResult br,Model model){
		//如果校验失败，则重新返回添加页面，进行修改
		if(br.hasErrors()){
			model.addAttribute("manager", new Manager());
			return "manager/managerSave";
		}
		manager.setCreateTime(new Date());
		manager.setParentId(2);
		this.managerService.save(manager);
		return "redirect:/admin/manager/managerList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
