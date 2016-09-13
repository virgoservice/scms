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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.entity.Role;
import com.seelecloud.cms.service.AppService;
import com.seelecloud.cms.service.ManagerService;
import com.seelecloud.cms.service.ModelService;
import com.seelecloud.cms.service.RoleModelService;
import com.seelecloud.cms.service.RoleService;
import com.seelecloud.cms.vo.ModelVo;

/** 
 * @Desc: () 
 * @author: 谭朝红 
 * @date: 2016年9月10日 上午2:58:14 
 * @email:ramostear@163.com 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleModelService roleModelService;
	@Autowired
	private AppService appService;
	
	/**
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
		//1.根据当前登录用户的编号查找用户的角色，如果角色为空，则进行信息提示，用户还没有被分配任何角色，暂不可以对站点进行任何管理操作
		Manager manager = (Manager)session.getAttribute("LoginManager");
		if(manager == null){
			//暂时设定一个用户
			manager = managerService.findById(2);
		}
		List<Role> roleList = roleService.findByManangerId(manager.getId());
		List<Integer> modelIds = new ArrayList<Integer>();
		List<com.seelecloud.cms.entity.Model> models = new ArrayList<com.seelecloud.cms.entity.Model>();
		if(roleList!=null&&roleList.size()>0){
			for(Role role:roleList){
				modelIds.addAll(roleModelService.findModelIdsByRole(role.getId()));
			}
		}
		for(int id:modelIds){
			com.seelecloud.cms.entity.Model m = modelService.findById(id);
			if(m!=null){
				models.add(m);
			}
		}
		List<ModelVo> mv = this.modelTree(models);
		//2.根据用户角色编号查找用户所能得到的模块，
		//3.获取模块信息，返回视图，如果没有任何模块可用，则提示用户还没有被分配任何可用模块
		model.addAttribute("models", mv);
		return "admin/index";
	}
	
	/**
	 * 组织模块树
	 * @param models
	 * @return
	 */
	private List<ModelVo> modelTree(List<com.seelecloud.cms.entity.Model> models){
		List<com.seelecloud.cms.entity.Model> pmodel = new ArrayList<com.seelecloud.cms.entity.Model>();
		List<ModelVo> mv = new ArrayList<ModelVo>();
		for(com.seelecloud.cms.entity.Model m:models){
			if(m.getParentId()==-1){
				pmodel.add(m);
			}
		}
		for(com.seelecloud.cms.entity.Model pm:pmodel){
			List<ModelVo> cmv = new ArrayList<ModelVo>();
			for(com.seelecloud.cms.entity.Model m:models){
				if(m.getParentId()==pm.getId()){
					cmv.add(new ModelVo(m.getId(), m.getModelName(), null, m.getParentId(), m.getModelUrl(), m.getModelIcon(), m.getManagerId(), null));
				}
			}
			mv.add(new ModelVo(pm.getId(), pm.getModelName(), null, pm.getParentId(), pm.getModelUrl(), pm.getModelIcon(), pm.getManagerId(), cmv));
		}
		return mv;
	}
}
