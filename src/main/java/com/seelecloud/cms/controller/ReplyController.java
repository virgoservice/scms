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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.seelecloud.cms.entity.Reply;
import com.seelecloud.cms.service.ReplyService;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年10月31日
 * @Email:
 */
@Controller
@RequestMapping("/comment/reply/")
public class ReplyController {

	@Autowired
	ReplyService replyService;
	
	/**
	 * 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "/repley/ajaxListReplyByComment", method = RequestMethod.GET)
	public List<Reply> listAllReplyByComment(@RequestParam("id")int id) {
		return this.replyService.listByCommentId(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/repley/ajaxListReplyByParent", method = RequestMethod.GET)
	public List<Reply> listAllReplyByParent(@RequestParam("id") int id) {
		return this.replyService.listByParentId(id);
	}

	public String saveReply(@RequestParam("commentId")int commentId, @RequestParam("id")int id) {
		return null;
	}

	public int addAgree() {
		return 1;
	}
}
