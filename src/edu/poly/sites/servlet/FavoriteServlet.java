package edu.poly.sites.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.UserDao;
import edu.poly.model.Favorite;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet({"/Favorite", "/Favorite/Unlike"})
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavoriteDao dao = new FavoriteDao();
		String url = request.getRequestURL().toString();
		String username = SessionUtils.getLoginedUsername(request);
		if(username==null) {
			request.getRequestDispatcher("Login").forward(request, response);
			return;
		}
		if(url.contains("Unlike")) {
			int videoId = Integer.parseInt(request.getParameter("videoId"));
			dao.delete(videoId);
		}
		List<Favorite> list = new ArrayList<>();
		list = dao.getFavByUser(username);
		request.setAttribute("favList", list);
		UserDao Udao = new UserDao();
		request.setAttribute("name", Udao.findById(username).getFullname());
		PageInfo.preparaAndForwardSite(request, response, PageType.SITE_FAVORITE_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
