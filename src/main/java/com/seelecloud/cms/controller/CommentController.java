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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seelecloud.cms.entity.Comment;
import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.service.CommentService;
import com.seelecloud.cms.service.ManagerService;
import com.seelecloud.cms.service.ReplyService;
import com.seelecloud.cms.vo.CommentVo;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月26日
 * @Email:
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	@Autowired
	ManagerService managerService;
	@Autowired
	ReplyService replyService;

	@RequestMapping(value = "/commentList", method = RequestMethod.GET)
	public String articleComment(Model model) {
		int total = 0;
		total = this.commentService.getTotal(1);
		List<CommentVo> cvList = null;
		cvList = ajaxListComments(1, 1, 4, 0);
		if (cvList != null) {
			model.addAttribute("commentList", cvList);
		}
		model.addAttribute("total", total);

		return "content/comment";
	}

	/**
	 * 查看更多评论
	 * 
	 * @param id
	 * @param number
	 * @return 用户信息和评论信息
	 */
	@RequestMapping("/ajaxMoreComments")
	@ResponseBody
	public List<CommentVo> ajaxListComments(
			@RequestParam("contentId") int contentId,
			@RequestParam("type") int type,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
			@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {

		List<Comment> commentList = null;

		// 1 list comment
		commentList = this.commentService.selectCommentByPage(contentId,
				pageSize, pageNumber);

		// 2 query user info (name, id , avatar)
		// List<Integer> userIds = new ArrayList<Integer>();

		// TODO 如何优化
		List<CommentVo> cvList = new ArrayList<CommentVo>();
		Manager user = null;
		for (Comment c : commentList) {
			CommentVo cv = new CommentVo();
			if (c != null) {
				user = this.managerService.findById(c.getCreatorId());
				if (user != null) {
					cv.setId(c.getId());
					cv.setType(c.getType());
					cv.setContentId(c.getContentId());
					cv.setAgree(c.getAgree());
					cv.setReplyCount(c.getReplyCount());
					cv.setStatus(c.getStatus());
					cv.setCreatorId(c.getCreatorId());
					cv.setCreateTime(c.getCreateTime());
					cv.setText(c.getText());
					cv.setUserNickName(user.getManagerNickname());
					cv.setAvatar(null);// 默认一个
					cvList.add(cv);
				}
			}
			System.out.println(c.getCreatorId() + user.getManagerNickname());
		}

		// 3 response

		return cvList;
	}

	/**
	 * 列出所有评论,以便管理
	 */
	@RequestMapping("/ajaxAllComments")
	public List<Comment> ajaxAllComments() {
		return null;
	}

	/**
	 * 删除评论
	 */
	@RequestMapping(value = "/ajaxCommentDelete", method = RequestMethod.POST)
	public void deleteComment(@RequestParam("id") int id) {
		// 级联删除当前评论下的所有回复记录
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(id);
		this.replyService.deleteByCommentIds(idList);

		this.commentService.deleteById(id);
	}

	/**
	 * 修改点赞数
	 */
	@RequestMapping(value = "/ajaxCommentAgree", method = RequestMethod.POST)
	public void editCommentAgree(@RequestParam("id") int id) {

		System.out.println("agree id=" + id);
		Comment comment = null;
		comment = this.commentService.findById(id);
		int agree = comment.getAgree() + 1;
		comment.setAgree(agree);
		this.commentService.update(comment);
	}

	/**
	 * 修改状态
	 */
	@RequestMapping(value = "/ajaxCommentStatus", method = RequestMethod.POST)
	public void editCommentStatus(@RequestParam("id") int id, int status) {
		Comment comment = new Comment();
		comment.setId(id);
		comment.setStatus((byte) status);
		this.commentService.update(comment);
	}

	/**
	 * 修改回复数(不提供内容修改), 可能用一个触发器在数据库中自动增加
	 */
	@RequestMapping(value = "/ajaxCommentReplycount", method = RequestMethod.POST)
	public void editCommentReCount(@RequestParam("id") int id) {
		Comment comment = null;
		comment = this.commentService.findById(id);
		int agree = comment.getAgree();
		comment.setAgree(agree);
		this.commentService.update(comment);
	}

	/**
	 * 添加一条新评论, (如果需要通过审核才能发表添加成功)
	 */
	@RequestMapping(value = "/ajaxCommentSave", method = RequestMethod.POST)
	public void saveComment(@RequestParam("contentId") int contentId,
			@RequestParam("type") int type, @RequestParam("text") String text) {
		System.out.println("agree cid=" + contentId + text);

		// get user login info
		int creatorId = 1;

		Comment comment = new Comment(0, 0, 0, 0, 0, (byte) 1, 0, null, null);
		comment.setContentId(contentId);
		comment.setCreatorId(creatorId);
		comment.setCreateTime(new Date());
		comment.setText(text);

		this.commentService.save(comment);
	}

	/**
	 * 获取评论的总数
	 */
	public int getCommentTotal(int type, int contentId) {
		return this.commentService.getTotal(contentId);
	}

	/**
	 * 举报评论, 另外管理
	 */
	@RequestMapping(value = "/ajaxCommentReport", method = RequestMethod.POST)
	public void reportComment(@RequestParam("id") int id) {
	}
}
