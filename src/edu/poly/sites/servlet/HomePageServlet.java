package edu.poly.sites.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.UserDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.Favorite;
import edu.poly.model.Video;

/**
 * Servlet implementation class HomePageServletm
 */
@MultipartConfig
@WebServlet("/Homepage")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String numberPage = request.getParameter("pagenumber");
		if(numberPage==null) {
			numberPage = "1";
			try {
				VideoDao dao = new VideoDao();
				FavoriteDao Favdao = new FavoriteDao();
				List<Favorite> Favlist = Favdao.getFavByUser(SessionUtils.getLoginedUsername(request));
				List<Video> list = dao.listget8Video(numberPage);
				request.setAttribute("checkLike", Favlist);
				request.setAttribute("videos", list);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
		} else {
			try {
				VideoDao dao = new VideoDao();
				FavoriteDao Favdao = new FavoriteDao();
				List<Favorite> Favlist = Favdao.getFavByUser(SessionUtils.getLoginedUsername(request));
				List<Video> list = dao.listget8Video(numberPage);
				request.setAttribute("checkLike", Favlist);
				request.setAttribute("videos", list);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
		}
		UserDao dao = new UserDao();
		String username = SessionUtils.getLoginedUsername(request);
		if(username!=null) {
			request.setAttribute("name", dao.findById(username).getFullname());
		}		
		request.setAttribute("number", numberPage);
		PageInfo.preparaAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
