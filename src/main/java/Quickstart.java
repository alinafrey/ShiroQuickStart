///*
// * Licensed to the Apache Software Foundation (ASF) under one
// * or more contributor license agreements.  See the NOTICE file
// * distributed with this work for additional information
// * regarding copyright ownership.  The ASF licenses this file
// * to you under the Apache License, Version 2.0 (the
// * "License"); you may not use this file except in compliance
// * with the License.  You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing,
// * software distributed under the License is distributed on an
// * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// * KIND, either express or implied.  See the License for the
// * specific language governing permissions and limitations
// * under the License.
// */
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.ini.IniSecurityManagerFactory;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.lang.util.Factory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
///**
// * Simple Quickstart application showing how to use Shiro's API.
// *
// * @since 0.9 RC2
// */
//public class Quickstart {
//
//    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);
//
//
//    public static void main(String[] args) {
//
//        // The easiest way to create a Shiro SecurityManager with configured
//        // realms, users, roles and permissions is to use the simple INI config.
//        // We'll do that by using a factory that can ingest a .ini file and
//        // return a SecurityManager instance:
//
//        // Use the shiro.ini file at the root of the classpath
//        // (file: and url: prefixes load from files and urls respectively):
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        SecurityManager securityManager = factory.getInstance();
//
//        // for this simple example quickstart, make the SecurityManager
//        // accessible as a JVM singleton.  Most applications wouldn't do this
//        // and instead rely on their container configuration or web.xml for
//        // webapps.  That is outside the scope of this simple quickstart, so
//        // we'll just do the bare minimum so you can continue to get a feel
//        // for things.
//        SecurityUtils.setSecurityManager(securityManager);
//
//        // Now that a simple Shiro environment is set up, let's see what you can do:
//
//        // get the currently executing user:
//        Subject currentUser = SecurityUtils.getSubject();
//
//        // Do some stuff with a Session (no need for a web or EJB container!!!)
//        Session session = currentUser.getSession();
//        session.setAttribute("someKey", "aValue");
//        String value = (String) session.getAttribute("someKey");
//        if (value.equals("aValue")) {
//            log.info("Retrieved the correct value! [" + value + "]");
//        }
//
//        // let's login the current user so we can check against roles and permissions:
//        if (!currentUser.isAuthenticated()) {
//            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
//            token.setRememberMe(true);
//            try {
//                currentUser.login(token);
//            } catch (UnknownAccountException uae) {
//                log.info("There is no user with username of " + token.getPrincipal());
//            } catch (IncorrectCredentialsException ice) {
//                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
//            } catch (LockedAccountException lae) {
//                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
//                        "Please contact your administrator to unlock it.");
//            }
//            // ... catch more exceptions here (maybe custom ones specific to your application?
//            catch (AuthenticationException ae) {
//                //unexpected condition?  error?
//            }
//        }
//
//        //say who they are:
//        //print their identifying principal (in this case, a username):
//        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
//
//        //test a role:
//        if (currentUser.hasRole("schwartz")) {
//            log.info("May the Schwartz be with you!");
//        } else {
//            log.info("Hello, mere mortal.");
//        }
//
//        //test a typed permission (not instance-level)
//        if (currentUser.isPermitted("lightsaber:wield")) {
//            log.info("You may use a lightsaber ring.  Use it wisely.");
//        } else {
//            log.info("Sorry, lightsaber rings are for schwartz masters only.");
//        }
//
//        //a (very powerful) Instance Level permission:
//        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
//            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
//                    "Here are the keys - have fun!");
//        } else {
//            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
//        }
//
//        //all done - log out!
//        currentUser.logout();
//
//        System.exit(0);
//    }
//}

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);
//    private static final transient Logger log = LogManager.getLogger(Quickstart.class);

    public static void main(String[] args) {
    	log.debug("");
        log.debug("");
        log.debug("");
        log.debug("My First Apache Shiro Application");
        
        log.info("");
        log.info("");
        log.info("");
        log.info("Accessing shiro.ini");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        
        Subject currentUser = SecurityUtils.getSubject();
        
        if(currentUser != null) {
        
	        log.info("");
	        log.info("");
	        log.info("");
	        log.info("Getting session.");
	        Session session = currentUser.getSession();
	        log.info("");
	        log.info("");
	        log.info("");
	        log.info("Session ID: " + session.getId());
	        
	        if ( !currentUser.isAuthenticated() ) {
	            //collect user principals and credentials in a gui specific manner
	            //such as username/password html form, X509 certificate, OpenID, etc.
	            //We'll use the username/password example here since it is the most common.
	        	
	        	String username = "lonestarr";
	        	String password = "vespa";
	            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	
	            //this is all you have to do to support 'remember me' (no config - built in!):
	            token.setRememberMe(true);          
	            
	
	            try {
	            	log.info("");
	    	        log.info("");
	    	        log.info("");
	    	        log.info("Before login.");
	                currentUser.login( token );
	                //if no exception, that's it, we're done!
	                
	                log.info("");
	    	        log.info("");
	    	        log.info("");
	                log.info( "User [" + currentUser.getPrincipal() + "] logged in successfully." );
	                
	                log.info("");
	    	        log.info("");
	    	        log.info("");
	                log.info( "Logging out." );
	                currentUser.logout();

	                
	            } catch ( UnknownAccountException uae ) {
	                //username wasn't in the system, show them an error message?
	            } catch ( IncorrectCredentialsException ice ) {
	                //password didn't match, try again?
	            } catch ( LockedAccountException lae ) {
	                //account for that username is locked - can't login.  Show them a message?                          
	            } catch ( AuthenticationException ae ) {
	                //unexpected condition - error?
	            }
	        }
        
        
        	
        }
        
        System.exit(0);
    }
}