/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.entity;

/**
 * @description: 文章正文分段存储
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class ArticleContent {

	/**
	 * 文章id
	 */
	private int id;

	/**
	 * 分段(页)码
	 */
	private int sectionNum;

	/**
	 * 文章正文
	 */
	private String content;

	public ArticleContent() {
	}

	public ArticleContent(int id, int sectionNum, String content) {
		super();
		this.id = id;
		this.sectionNum = sectionNum;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ArticleContent [id=" + id + ", sectionNum=" + sectionNum
				+ ", content=" + content + "]";
	}

}
