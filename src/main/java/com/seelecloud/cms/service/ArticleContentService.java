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

import com.seelecloud.cms.entity.ArticleContent;

/**
 * @description: 根据文章id查找, 更新文章正文内容
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public interface ArticleContentService {

	/**
	 * 新增一段文章内容
	 * @param articleContent
	 */
	public void save(ArticleContent articleContent);

	/**
	 * 根据对象更新文章所有内容
	 * 
	 * @param articleContent
	 */
	public void update(ArticleContent articleContent);

	/**
	 * 根据id删除文章所有内容
	 * 
	 * @param uuid
	 */
	public void deleteByUuid(@Param("uuid") String uuid);

	/**
	 * 根据文章uuid，查找所有正文片段
	 * 
	 * @param uuid
	 * @return
	 */
	public List<ArticleContent> listArticleAllContent(@Param("uuid") String uuid);

	/**
	 * 根据片段编号查找指定片段内容
	 * 
	 * @param uuid
	 * @param sectionNum
	 * @return
	 */
	public ArticleContent findArticleSection(@Param("uuid") String uuid,
			@Param("sectionNum") int sectionNum);

}
