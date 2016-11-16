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
 * @description: 栏目内容, 每个栏目所包含的元素
 * @author: vabo
 * @version:
 * @Datetime:2016年10月24日
 * @Email:
 */
public class ChannelContent {

	/**
	 * 栏目id, 通过id与多个内容建立联系
	 */
	private int id; // 栏目id
	private int type; // 内容的类型
	private int contentId; // 与type 惟一标识一个内容记录

	public ChannelContent() {
		super();
	}

	public ChannelContent(int id, int type, int contentId) {
		super();
		this.id = id;
		this.type = type;
		this.contentId = contentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	@Override
	public String toString() {
		return "ChannelContent [id=" + id + ", type=" + type + ", contentId="
				+ contentId + "]";
	}

}
