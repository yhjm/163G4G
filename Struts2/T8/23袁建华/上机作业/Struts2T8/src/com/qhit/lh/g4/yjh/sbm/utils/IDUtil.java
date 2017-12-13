/**
 * 
 */
package com.qhit.lh.g4.yjh.sbm.utils;

import java.util.UUID;

/**
 * @author 袁建华
 * 2017年11月17日
 */
public class IDUtil {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
