package edu.poly.sites.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class LikeVideoServlet
 */
@WebServlet("/LikeVideoServlet")
public class LikeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		String videoId = request.getParameter("videoId");
		String username = SessionUtils.getLoginedUsername(request);		
		if(videoId==null) {
			response.sendRedirect(videoId);
			return;
		}
		FavoriteDao dao = new FavoriteDao();
		Favorite favorite = new Favorite();
		Video video = new Video();	
		try {
			favorite = dao.getFavorite(username, videoId);
			dao.delete(favorite.getFavoritedId());
			request.setAttribute("message", "Video is removed from favorites !");
			request.getRequestDispatcher("/Homepage").forward(request, response);
			return;
		} catch (Exception e) {			
		}
		try {
			video.setVideoId(videoId);
			favorite.setVideo(video);
			
			User user = new User();
			user.setUsername(username);
			favorite.setUser(user);
			
			favorite.setLikedDate(new Date());
			
			dao.insert(favorite);
			
			request.setAttribute("message", "Video is added to Favorite !");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/Homepage").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.preparaAndForwardSite(request, response, PageType.SITE_FAVORITE_PAGE);
	}

}
