/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月19日 下午3:40:46
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.vo;

import com.seelecloud.cms.consts.GeneratorSystemConst;

/** 
 * @Desc: (分页处理对象) 
 * @author: 谭朝红 
 * @date: 2016年8月19日 下午3:40:46 
 * @email:ramostear@163.com 
 */
public class Pager{
	
	
	/*String path = "d://files"+File.separator;*/

	/**
	 * 分页大小
	 */
	private int pageSize = GeneratorSystemConst.DEFALUT_PAGE_SIZE;
	/**
	 * 起始页
	 */
	private int offset = 1;
	/**
	 * 总页数
	 */
	private int totalPage = 0;
	/**
	 * 总记录数
	 */
	private int totalCount =0;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSiz(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = (this.offset-1)*this.pageSize;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = (this.totalCount/this.pageSize)+((this.totalCount%this.pageSize==0)?0:1);
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
