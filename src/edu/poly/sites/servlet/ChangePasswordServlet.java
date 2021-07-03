package edu.poly.sites.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginUsername(request);
		
		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		try {
			UserDao dao = new UserDao();
			
			User user = dao.findById(username);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo.preparaAndForwardSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		try {
			String username = SessionUtils.getLoginUsername(request);
			UserDao dao = new UserDao();
			User oldUser = dao.findById(username);
			if(oldUser.getPassword().equals(password)) {
				user.setUsername(oldUser.getUsername());
				user.setAdmin(oldUser.getAdmin());
				user.setPassword(password2);
				user.setFullname(oldUser.getFullname());
				user.setEmail(oldUser.getEmail());
				dao.update(user);
				
				request.setAttribute("message", "Change password successfully");
				request.setAttribute("user", user);
			}else {
				request.setAttribute("message", "Old password does not match the current password");
				request.getRequestDispatcher("sites/users/changepassword.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.preparaAndForwardSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}
}
