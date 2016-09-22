package com.seelecloud.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seelecloud.cms.entity.App;
import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.service.AppService;

/** 
 * @Desc: () 
 * @author: 张瑞 
 * @date: 2016年9月21日 下午5:47:05
 * @email: ramostear@163.com 
 */
@Controller
@RequestMapping("/admin/app")
public class AppController {
	/**
	 * 站点信息Service
	 */
	@Autowired
	private AppService appService;
	
	/**
	 * 跳转到站点信息页面(分页显示所有站点)
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/toAppInfo","/"},method=RequestMethod.GET)
	public String toAppInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response, Model model){
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
		model.addAttribute("pagers", appService.findByPageAndManager(currentManager.getId(), offset, size, "id", true));
		return "app/appInfo";
	}
	
	/**
	 * 增加站点信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toAppAdd",method=RequestMethod.GET)
	public String toAppAdd(Model model){
		model.addAttribute(new App());
		return "app/appAdd";
	}
	
	/**
	 * 增加站点信息并对所填写内容进行验证
	 * @param app
	 * @param br
	 * @return
	 */
	@RequestMapping(value="/toAppAdd",method=RequestMethod.POST)
	public String toAppAdd(@Validated App app,BindingResult br){
		if (br.hasErrors()) {
			return "app/appAdd";
		}
		appService.save(app);
		return "redirect:/admin/app/toAppInfo";
	}
	
	/**
	 * 跳转到站点修改页面，进行修改
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}/toAppUpdate",method=RequestMethod.GET)
	public String toAppUpdate(@PathVariable int id,Model model) {
		model.addAttribute(appService.findById(id));
		return "app/appUpdate";
	}
	
	/**
	 * 提交修改的站点信息
	 * @param id
	 * @param app
	 * @param br
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}/toAppUpdate",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated App app,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "app/appUpdate";
		}
		App app2 = appService.findById(id);
		//把需要在表单页面修改的值在下面列出，便于更改
		app2.setAppName(app.getAppName());
		// app2.setXXX()   ....
		appService.update(app2);
		return "redirect:/admin/app/toAppInfo";
	}
	
	/**
	 * 删除某个站点
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}/toAppDelete",method=RequestMethod.GET)
	public String toAppDelete(@PathVariable int id) {
		appService.delete(id);
		return "redirect:/admin/app/toAppInfo";
	}
	
}
