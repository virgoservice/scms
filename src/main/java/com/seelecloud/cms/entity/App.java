/**   
													The Apache License 2.0
												  Copyright (c) 2016 Ramostear 
								                              2016年8月18日 下午2:54:13
								Unless required by applicable law or agreed to in writing, software
								 distributed under the License is distributed on an "AS IS" BASIS,
							  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
								See the License for the specific language governing permissions and
								                 limitations under the License. 
*/
package com.seelecloud.cms.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

/** 
 * @Desc: (站点实体，用来定义这个站点的属性，有父子关系，最多出现一级的父子关系) 
 * @author: 谭朝红 
 * @date: 2016年8月18日 下午2:54:13 
 * @email:ramostear@163.com 
 */
public class App {
	/**
	 * 站点编号
	 */
	private int id;
	/**
	 * 站点名称
	 */
	@NotNull(message="站点名称不能为空")
	private String appName;
	/**
	 * 站点描述
	 */
	@NotNull(message="站点的描述不能为空")
	private String appDescription;
	/**
	 * 站点Logo
	 */
	private String appLogo;
	/**
	 * 站点关键字
	 */
	@NotNull(message="站点的关键词不能为空")
	private String appKeyword;
	/**
	 * 站点版权信息
	 */
	private String appCopyright;
	/**
	 * 站点的访问域名
	 */
	private String appUrl;
	/**
	 * 站点的发布时间
	 */
	private Date createTime;
	
	/**
	 * 站点管理员编号
	 */
	private int appManagerId;
	
	/**
	 * 无参构造函数
	 */
	public App() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public String getAppLogo() {
		return appLogo;
	}

	public void setAppLogo(String appLogo) {
		this.appLogo = appLogo;
	}

	public String getAppKeyword() {
		return appKeyword;
	}

	public void setAppKeyword(String appKeyword) {
		this.appKeyword = appKeyword;
	}

	
	public String getAppCopyright() {
		return appCopyright;
	}

	public void setAppCopyright(String appCopyright) {
		this.appCopyright = appCopyright;
	}

	/*@NotNull(message="站点的访问域名不能为空")*/
	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/*@NotNull(message="站点管理员编号不能为空")*/
	public int getAppManagerId() {
		return appManagerId;
	}

	public void setAppManagerId(int appManagerId) {
		this.appManagerId = appManagerId;
	}
	
}
