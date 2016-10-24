/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.shirotest;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 
 * @author: vabo
 * @version:
 * @Datetime:2016年10月17日
 * @Email:
 */
public class ShiroTest {

	private static final transient Logger log = LoggerFactory.getLogger(ShiroTest.class);
	
	public static void main(String[] args) {

	    log.info("My First Apache Shiro Application");

		@SuppressWarnings("resource")
	    ApplicationContext context = new ClassPathXmlApplicationContext(
	    			new String[]{"classpath:/spring.xml",
	    					"classpath:/spring-mybatis.xml",
	    					"classpath:/spring-shiro.xml"});
	    
//	    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//	    SecurityManager securityManager = factory.getInstance();
	    SecurityManager securityManager = (SecurityManager)context.getBean("securityManager");
	    SecurityUtils.setSecurityManager(securityManager);

        // get the currently executing user:
        Subject currentUser = SecurityUtils.getSubject();

//        Session session = currentUser.getSession(true);
//        
//        session.setAttribute("administrator", "123456");
//        String value = (String) session.getAttribute("administrator");
//        if (value.equals("123456")) {
//            log.info("Retrieved the correct value! [" + value + "]");
//        }

        // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("administrator", "123456");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }
        else{
        	log.info("user has authc!");
        }

        if(currentUser.isAuthenticated()){
        	log.info("authc");
        }
        else{
        	log.info("no authc");
        }
        
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
        if (currentUser.hasRole("超级管理员")) {
            log.info("role has authz!");
        } else {
            log.info("no role !");
        }

        currentUser.logout();
        
	    System.exit(0);
	}
}
