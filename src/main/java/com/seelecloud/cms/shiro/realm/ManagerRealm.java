/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seelecloud.cms.entity.Role;
import com.seelecloud.cms.entity.Manager;
import com.seelecloud.cms.service.ManagerService;
import com.seelecloud.cms.service.RoleService;

/**
 * @description:
 * @author: vabo
 * @version:
 * @Datetime:2016年10月18日
 * @Email:
 */
@Component("managerRealm")
public class ManagerRealm extends AuthorizingRealm {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private RoleService roleService;

	/**
	 * 授权方法，在配有缓存的情况下，只加载一次。
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		System.out.println("doAuthz");
        if (principals == null) {  
            throw new AuthorizationException("Principal对象不能为空");  
        }  
		
		String managerName = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 获取用户信息的所有资料，如权限角色等.
		// info.setStringPermissions(权限集合);
		// info.setRoles(角色集合);
		// authorizationInfo.setStringPermissions(managerService.findPermissions(managerName));
		if(managerName!=null){
			System.out.println("\nmanager name:" + managerName);
		}
		
		Manager manager = this.managerService.findByName(managerName);
		int roleId = manager.getRoleId();
		
		Role role = roleService.findById(roleId);
		if(role ==null){
			System.out.println("\nrole is null");
		}
		else{			
			System.out.println("\nrole name:" + role.getRoleName());
		}
		
		Set<String> roleNameSet = new HashSet<String>();
		roleNameSet.add(role.getRoleName());
		authorizationInfo.setRoles(roleNameSet);

		return authorizationInfo;
	}

	/**
	 * 登陆认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		System.out.println("doAuthc");
		String managerName = (String) token.getPrincipal();
		if(managerName!=null){
			System.out.println("\nmanager name:" + managerName);
		}
		Manager manager = managerService.findByName(managerName);

		if (manager == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		else{
			System.out.println("\nmanager id:" + manager.getId() + manager.getStatus());
		}

		if (Boolean.FALSE.equals(manager.getStatus())) {
			throw new LockedAccountException(); // 0是不可用, 帐号锁定
		}

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				manager.getManagerName(), // 用户名
				manager.getPassword(), // 密码
				// ByteSource.Util.bytes(manager.getCredentialsSalt()),//salt=username+salt
				getName() // realm name
		);

		return authenticationInfo;
	}

}
