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

import com.seelecloud.cms.dao.ReplyDao;
import com.seelecloud.cms.entity.Reply;
import com.seelecloud.cms.service.ReplyService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDao replyDao;

	@Override
	public int save(Reply reply) {
		return this.replyDao.save(reply);
	}

	@Override
	public int update(Reply reply) {
		return this.replyDao.update(reply);
	}

	@Override
	public Reply findById(int id) {
		return this.replyDao.findById(id);
	}

	@Override
	public List<Reply> listByCommentId(int commentId) {
		return this.replyDao.listByCommentId(commentId);
	}

	@Override
	public List<Reply> listByParentId(int parentId) {
		return this.replyDao.listByParentId(parentId);
	}

	@Override
	public int deleteById(int id) {
		return this.replyDao.deleteById(id);
	}

	@Override
	public int deleteByParentIds(List<Integer> parentIds) {
		return this.replyDao.deleteByParentIds(parentIds);
	}

	@Override
	public int deleteByCommentIds(List<Integer> commentIds) {
		return this.replyDao.deleteByCommentIds(commentIds);
	}
}
