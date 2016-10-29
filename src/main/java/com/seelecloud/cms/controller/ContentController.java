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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seelecloud.cms.entity.Channel;
import com.seelecloud.cms.service.ChannelService;
import com.seelecloud.cms.service.ContentTypeService;

/**
 * @description: 内容管理控制器: 栏目管理, 文章管理, 多媒体资源管理, 资源下载管理
 * @author: 张瑞
 * @version:
 * @Datetime:2016年10月28日
 * @Email: 2411685663@qq.com
 */
@Controller
@RequestMapping("/admin/content")
public class ContentController {
	
	@Autowired
	private ContentTypeService contentTypeService;
	@Autowired
	private ChannelService channelService;
	
	/**
	 * 文章列表
	 * @return
	 */
	@RequestMapping("/articleList")
	public String articleList(){
		
		return "content/articleList";
	}
	
	/**
	 * 添加文章
	 * @return
	 */
	@RequestMapping("/articleSave")
	public String articleSave(){
		
		return "content/articleSave";
	}
	
	/***********************************栏目管理***********************************************/
	
	/**
	 * 栏目列表
	 * @return
	 */
	@RequestMapping(value="/channel", method = RequestMethod.GET)
	public String channel(Model model){		
		return "content/channel";
	}
	
	/**
	 * 栏目树：获取id,parentId,Name
	 * 异步ajax
	 * @return
	 */
	@RequestMapping("/ajaxchannel")
	@ResponseBody
	public List<Channel> ajaxchannel(){
		List<Channel> mvList = channelService.listChannelByTree();
		return mvList;
	}
	
	/**
	 * 点击任意栏目,列出该栏目下的子栏目
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping("/channel/{pid}")
	public String listChannelByParent(@PathVariable Integer pid,Model model){
		Channel pc = null;
		if (pid == -1) {//根栏目
			pc = new Channel();
			pc.setTitle(Channel.ROOT_NAME);
		}
		pc = channelService.findChannelById(pid);
		model.addAttribute("pc", pc); //获取当前操作栏目名称
		model.addAttribute("channels", channelService.listChannelByParent(pid));
		return "content/channel_child";
	}
	
	
	/**
	 * 添加栏目
	 * @return
	 */
	@RequestMapping("/channelSave")
	public String channelSave(){
		
		return "content/channelSave";
	}	
}
