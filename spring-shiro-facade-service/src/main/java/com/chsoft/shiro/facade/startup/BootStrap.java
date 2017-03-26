// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Init.java

package com.chsoft.shiro.facade.startup;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BootStrap{
	
	public static void main(String args[]){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
			"spring-servlet.xml","spring-dao.xml","spring-dubbo.xml"
		});
		context.start();
		
		synchronized (BootStrap.class) {
            while (true) {
                try {
                	BootStrap.class.wait();
                } catch (Throwable e) {
                }
            }
        }
	}
}
