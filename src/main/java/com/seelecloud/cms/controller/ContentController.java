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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seelecloud.cms.service.ContentTypeService;

/**
 * @description: 内容管理控制器: 栏目管理, 文章管理, 多媒体资源管理, 资源下载管理
 * @author: vabo
 * @version:
 * @Datetime:2016年10月13日
 * @Email:
 */
@Controller
@RequestMapping("/admin/content")
public class ContentController {
	
	@Autowired
	private ContentTypeService contentTypeService;
	
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
	
	/**
	 * 导航列表
	 * @return
	 */
	@RequestMapping("/channel")
	public String channel(){
		
		return "content/channel";
	}
	
	/**
	 * 添加导航
	 * @return
	 */
	@RequestMapping("/channelSave")
	public String channelSave(){
		
		return "content/channelSave";
	}	
}
