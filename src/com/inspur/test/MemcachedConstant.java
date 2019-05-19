
package com.inspur.test;

public class MemcachedConstant {
	
	/**
	 * UMS中的KEY,
	 * Value值:Map中map.put(user_id, 
	 * user_number 		+ "," + 
	 * user_password 	+ "," + 
	 * user_nickname 	+ "," + 
	 * user_status 		+ "," +
	 * user_boxmac)
	 */
	public static String ums_getiptvuserinfo_nopasswordlogin_pagesmark_userid  =  "ums_getIptvUserInfo_noPassWordLogin_pagesmark_";

	
	/**
	 * UMS中的KEY
	 * 	Value值:Map中map.put(userid,
	 *	nullToSpace(vo.getUser_number()) 		       + "," + 
	 *	nullToSpace(vo.getUser_nickname()) 		       + "," + 
	 *	nullToSpace(vo.getUser_boxmac()) 		       + "," + 
	 *	nullToSpace(vo.getUser_password()) 		       + "," + 
	 *	nullToSpace(vo.getUser_freezestatus()) 	       + "," + 
	 *	nullToSpace(vo.getUser_isdel()) 		       + "," + 
	 *	nullToSpace(vo.getUser_status()) 		       + "," + 
	 *	nullToSpace(vo.getUser_lastactip()) 	       + "," + 
	 *	nullToSpace(vo.getUser_boxcode()) 		       + "," + 
	 *	nullToSpace(vo.getGroup_number()) 		       + "," + 
	 *	nullToSpace(vo.getUnicastflg()) 		       + "," + 
	 *	nullToSpace(vo.getBoxprovider()) 		       + "," + 
	 *	nullToSpace(vo.getUser_licensingwindowstart()) + "," + 
	 *	nullToSpace(vo.getUser_licensingwindowend()))
	 */
	public static String ums_iptvuserfori6serviceimpl_searchbyuserid_userid = "ums_IptvUserFori6ServiceImpl_searchByUserId_";
	
}
