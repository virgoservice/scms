/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.dao;

import java.util.List;

import com.seelecloud.cms.entity.ArticleContent;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public interface ArticleContentDao {

	public void save(ArticleContent articleContent);

	public int deleteByUuid(String uuid);

	public void update(ArticleContent articleContent);

	public ArticleContent findArticleSection(String uuid, int sectionNum);

	public List<ArticleContent> listArticleAllContent(String uuid);

}
