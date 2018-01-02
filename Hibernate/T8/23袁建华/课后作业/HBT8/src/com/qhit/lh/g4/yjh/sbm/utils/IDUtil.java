/**
 * 
 */
package com.qhit.lh.g4.yjh.sbm.utils;

import java.util.UUID;

public class IDUtil {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
