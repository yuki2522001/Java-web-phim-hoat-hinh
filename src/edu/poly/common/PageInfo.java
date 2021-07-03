package edu.poly.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute =  new HashedMap();
		static {
			pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management","/admin/users/users.jsp", null));
			pageRoute.put(PageType.REPOERT_MANAGEMENT_PAGE, new PageInfo("Reports Management","/admin/reports/reports.jsp", null));
			pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Videos Management","/admin/videos/videos.jsp", null));
			
			pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home page","/sites/home/home.jsp", null));
			pageRoute.put(PageType.SITE_HOME_PAGE2, new PageInfo("Home page","/sites/home/home2.jsp", null));
			pageRoute.put(PageType.SITE_HOME3, new PageInfo("Home page","/them/home3.jsp", null));
			pageRoute.put(PageType.SITE_HOME4, new PageInfo("Home page","/them/home4.jsp", null));
			pageRoute.put(PageType.SITE_HOME5, new PageInfo("Home page","/them/home5.jsp", null));
			pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Home page","/sites/users/login.jsp", null));		
			pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Home page","/sites/users/registration.jsp", null));		
			pageRoute.put(PageType.SITE_CHANGEPASSWORD_PAGE, new PageInfo("Home page","/sites/users/changepasswod.jsp", null));		
			pageRoute.put(PageType.SITE_FORGOTPASSWORD_PAGE, new PageInfo("Home page","/sites/users/forgotpassword.jsp", null));		
			pageRoute.put(PageType.SITE_DETAILS_PAGE, new PageInfo("Home page","/sites/videos/details.jsp", null));		
			pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Home page","/sites/videos/favorites.jsp", null));			
			pageRoute.put(PageType.SITE_EDITPROFILE_PAGE, new PageInfo("Home page","/sites/users/edit-profile.jsp", null));
			pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("Home page","/sites/videos/share.jsp", null));	
		}
	
		public static void preparaAndForward(HttpServletRequest request, HttpServletResponse response, PageType paType) 
				throws ServletException, IOException {
			PageInfo page = pageRoute.get(paType);
			
			request.setAttribute("page", page);
			
			request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
		}
		public static void preparaAndForwardSite(HttpServletRequest request, HttpServletResponse response, PageType paType) 
				throws ServletException, IOException {
			PageInfo page = pageRoute.get(paType);
			
			request.setAttribute("page", page);
			
			request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);
		}
	
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
}
