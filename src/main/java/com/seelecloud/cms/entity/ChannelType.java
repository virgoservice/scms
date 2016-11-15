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
 * @description: 栏目分类类型: 如文章,多媒体文件(Audio,Media,Picture),专题等
 * @author: vabo
 * @version:
 * @Datetime:2016年11月15日
 * @Email:
 */
public class ChannelType {
	
	/**
	 * 类型的编号
	 */
	private int id;

	/**
	 * 类型名称
	 */
	private String name;

	/**
	 * 说明
	 */
	private String description;

	public ChannelType() {
	}

	public ChannelType(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ContentType [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
}
