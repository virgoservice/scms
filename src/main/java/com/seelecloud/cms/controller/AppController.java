package com.seelecloud.cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seelecloud.cms.entity.App;
import com.seelecloud.cms.service.AppService;

/**
 * @Desc: (站点的查看和修改)
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
	 * 跳转到站点信息页面(显示站点),也可以进行修改
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/toAppInfo" }, method = RequestMethod.GET)
	public String toAppInfo(HttpSession session, Model model) {
		// 1.获取当前登录的用户
		App currentManager = (App) session.getAttribute("LoginManager");
		if (currentManager == null) {
			currentManager = new App();
			currentManager.setId(2); // 获取登陆Id
		}

		// 2.根据当前的用户获取他所创建的站点信息
		App app = appService.findById(currentManager.getId());
		// 3.返回查询到的数据
		model.addAttribute("app", app);

		return "app/appInfo";
	}

	/**
	 * 提交修改的站点信息
	 * 
	 * @param id
	 * @param app
	 * @param br
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAppInfo", method = RequestMethod.POST)
	public String toAppInfo(App app,HttpSession session) {
		// 1.获取当前登录的用户
		App currentManager = (App) session.getAttribute("LoginManager");
		if (currentManager == null) {
			currentManager = new App();
			currentManager.setId(2); // 获取登陆Id
		}		
		
		App app2 = appService.findById(currentManager.getId());
		// 把需要在表单页面修改的值在下面列出，便于更改
		app2.setAppName(app.getAppName());
		app2.setAppKeyword(app.getAppKeyword());
		app2.setAppDescription(app.getAppDescription());
		app2.setAppCopyright(app.getAppCopyright());
	
		appService.update(app2);
		return "redirect:/admin/app/toAppInfo";
	}
	

}