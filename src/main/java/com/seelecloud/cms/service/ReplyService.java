/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seelecloud.cms.entity.Reply;

/**
 * @description: 评论下的回复, 有方法 查询 新增 删除 更新状态 更新回复数量 更新点赞
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public interface ReplyService {

	/**
	 * 保存新增回复记录
	 * 
	 * @param reply
	 * @return
	 */
	public int save(Reply reply);

	/**
	 * 根据id更新指定的回复记录
	 * 
	 * @param reply
	 * @return
	 */
	public int update(Reply reply);

	/**
	 * 根据id查找一条指定回复记录
	 * 
	 * @param id
	 * @return
	 */
	public Reply findById(@Param("id") int id);

	/**
	 * 列出当前评论下的所有回复记录
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Reply> listByCommentId(@Param("commentId") int commentId);

	/**
	 * 列出当前回复节点下的所有回复记录
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Reply> listByParentId(@Param("parentId") int parentId);

	/**
	 * 根据id删除指定回复记录
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(@Param("id") int id);

	/**
	 * 删除指定回复节点下的所有回复记录
	 * 
	 * @param parentIds
	 *            要删除的回复组
	 * @return
	 */
	public int deleteByParentIds(@Param("parentIds") List<Integer> parentIds);

	/**
	 * 删除评论下的所有回复记录
	 * 
	 * @param commentIds
	 * @return
	 */
	public int deleteByCommentIds(@Param("commentIds") List<Integer> commentIds);
}
