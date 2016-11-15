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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seelecloud.cms.entity.Article;
import com.seelecloud.cms.entity.ArticleContent;
import com.seelecloud.cms.entity.Channel;
import com.seelecloud.cms.service.ArticleContentService;
import com.seelecloud.cms.service.ArticleService;
import com.seelecloud.cms.service.ChannelService;
import com.seelecloud.cms.service.ManagerService;
import com.seelecloud.cms.vo.ArticleVo;

/**
 * @description: 
 * @author: 张瑞
 * @version:
 * @Datetime:2016年11月15日
 * @Email:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ChannelService channelService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ArticleContentService articleContentService;

	private void initList(String con, Integer cid, Model model,
			HttpSession session, Integer status) {
		// // 1.获取当前登录的用户
		// Manager manager = session.getAttribute("loginManager");
		// if (manager==null) {
		// manager = new Manager();
		// manager.setPublisherId(0);
		// //系统管理员,创建文章的人就是登陆系统后台的人。根据登陆者来查看自己要发布或者已发布文章。后面在做修改(CRUD)
		// }
		//
		// // 2.根据当前的用户获取他所创建的managerName
		// Manager manager = managerService.findById(0);
		String managerName = "administrator1";// manager.getManagerName();
		List<ArticleVo> articleVoList = new ArrayList<ArticleVo>();
		ArticleVo articleVo = null;

		if (managerName.equals("administrator1")) {
			// 可以查看所有已发布文章
			List<Article> articles = articleService.listByConditions(null,
					status, cid, con, "createTime", true);
			for (Article article2 : articles) {
				articleVo = new ArticleVo(article2.getUuid(),
						article2.getTitle(), article2.getDescription(),
						article2.getCreateTime(), article2.getPublishTime(),
						managerName, channelService.findChannelById(
								article2.getChannelId()).getTitle(),
						article2.getStatus(), article2.isRecommend());
				articleVoList.add(articleVo);
			}
			model.addAttribute("articleVos", articleVoList);
		} else {
			// 只能查看自己已发布的文章：这里有问题，实体为用户。后面在做修改//TODO
			List<Article> articles = articleService.listByConditions(0, status,
					cid, con, "createTime", true);
			for (Article article2 : articles) {
				articleVo = new ArticleVo(article2.getUuid(),
						article2.getTitle(), article2.getDescription(),
						article2.getCreateTime(), article2.getPublishTime(),
						managerName, channelService.findChannelById(
								article2.getChannelId()).getTitle(),
						article2.getStatus(), article2.isRecommend());
				articleVoList.add(articleVo);
			}
			model.addAttribute("articleVos", articleVoList);
		}
		model.addAttribute("publishChannel",
				this.channelService.listPublishChannel());// 获取当前已发布栏目:下拉栏目
	}

	/**
	 * 已发布文章列表：登陆的超级管理员可以查看所有文章，普通管理员只能查看自己发布的文章。
	 * 
	 * @param model
	 * @param con
	 *            : 搜索内容(关键字)
	 * @param cid
	 *            :栏目id
	 * @param uid
	 *            :用户id
	 * @return
	 */
	@RequestMapping(value = "/publicationArticleList")
	public String publicationArticleList(
			@RequestParam(required = false) String con,
			@RequestParam(required = false) Integer cid, Model model,
			HttpSession session) {
		initList(con, cid, model, session, 1);
		return "article/articleList";
	}

	/**
	 * 未发布文章
	 * 
	 * @param model
	 * @param content
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/unpublicationArticleList")
	public String unpublicationArticleList(
			@RequestParam(required = false) String con,
			@RequestParam(required = false) Integer cid, Model model,
			HttpSession session) {
		initList(con, cid, model, session, 0);
		return "article/articleList";
	}

	/**
	 * 栏目树：获取id,parentId,Name 异步ajax
	 * 添加文章模块，栏目树不是普通管理员可以看见的，比如：只能是文章发布人员等。后期要做权限分配
	 * 
	 * @return
	 */
	@RequestMapping("/ajaxchannel")
	@ResponseBody
	public List<Channel> ajaxchannel() {
		List<Channel> mvList = channelService.listChannelByTree();
		return mvList;
	}

	//TODO 添加文章分为两步  创建文章并属性 / 添加文章内容
	/**
	 * 添加文章 文章创建者先不为登陆的用户，后面在做修改
	 * 
	 * @return
	 */
	@RequestMapping(value = "/articleSave", method = RequestMethod.GET)
	public String articleSave(Model model) {
		model.addAttribute("articleVo", new ArticleVo());
		return "article/articleSave";
	}

	/**
	 * 添加文章后跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/articleSave", method = RequestMethod.POST)
	public String articleSave(ArticleVo articleVo) {// 当传递的参数为空时，不进入post请求中
		Article article = new Article();
		ArticleContent articleContent = new ArticleContent();
		article.setTitle(articleVo.getTitle());
		article.setChannelId(articleVo.getChannelId());
		article.setSubtitle(articleVo.getSubtitle());
		article.setSource(articleVo.getSource());
		article.setCreateTime(new Date());
		article.setDescription(articleVo.getDescription());
		articleContent.setContent(articleVo.getContent());
		articleContentService.save(articleContent);
		articleService.save(article);
		return "redirect:/article/unpublicationArticleList";
	}

	//TODO 更新文章也分为两步：更新文章属性　/ 更新文章内容
	/**
	 * 更新文章
	 * 
	 * @return
	 */
	@RequestMapping(value = "/articleUpdate/{id}", method = RequestMethod.GET)
	public String articleUpdate(@PathVariable Integer id, Model model) {
/*		Article article = articleService.findById(id);
		ArticleContent articleContent = articleContentService
				.listArticleById(1);// id之后修改
		ArticleVo articleVo = new ArticleVo(article, managerService.findById(0)
				.getManagerName(), channelService.findChannelById(
				article.getChannelId()).getTitle(), articleContent.getContent());// article.getCreatorId()后面修改id
		model.addAttribute("articleVo", articleVo);*/
		return "article/articleUpdate";
	}

	/**
	 * 更新文章后跳转 文章创建者先不为登陆的用户，后面在做修改
	 * 
	 * @return
	 */
	@RequestMapping(value = "/articleUpdate/{id}", method = RequestMethod.POST)
	public String articleUpdate(@PathVariable Integer id, ArticleVo articleVo) {// 当传递的参数为空时，不进入post请求中
//		Article article = articleService.findById(id);
//		ArticleContent articleContent = articleContentService.listArticleById(1);
//		article.setUuid(articleVo.getUuid());
//		article.setTitle(articleVo.getTitle());
//		article.setChannelId(articleVo.getChannelId());
//		article.setSubtitle(articleVo.getSubtitle());
//		article.setSource(articleVo.getSource());
//		article.setDescription(articleVo.getDescription());
//		articleContent.setContent(articleVo.getContent());
//		articleContentService.update(articleContent);// 更新文章
//		articleService.update(article);
		return "redirect:/article/unpublicationArticleList";
	}

	/**
	 * 显示文章页面： id暂时设置为1，之后修改
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/articleShow/{id}")
	public String articleShow(@PathVariable String id, Model model) {
		model.addAttribute("article", articleService.findByUuid(id));
//		model.addAttribute("content", articleContentService.listArticleById(7));
		return "article/article";
	}
}
