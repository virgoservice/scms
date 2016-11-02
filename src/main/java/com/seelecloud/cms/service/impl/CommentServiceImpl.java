/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seelecloud.cms.dao.CommentDao;
import com.seelecloud.cms.entity.Comment;
import com.seelecloud.cms.service.CommentService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;

	@Override
	public List<Comment> selectCommentByPage(int contentId, int pageSize,
			int pageNumber) {
		return this.commentDao.listCommentByPage(contentId, pageSize,
				pageNumber);
	}

	@Override
	public Comment findById(int id) {
		return this.commentDao.findById(id);
	}

	@Override
	public int save(Comment comment) {
		return this.commentDao.save(comment);
	}

	@Override
	public int update(Comment comment) {
		return this.commentDao.update(comment);
	}

	@Override
	public int deleteById(int id) {
		return this.commentDao.deleteById(id);
	}

	@Override
	public int deleteCommentByContentId(int contentId) {
		return 0;
	}

	@Override
	public int getTotal(int contentId) {
		return this.commentDao.getTotal(contentId);
	}
}
