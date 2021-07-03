package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

/**
 * Servlet implementation class UsersManagementServlet
 */
@WebServlet({ "/UsersManagementServlet", "/UsersManagementServlet/create", "/UsersManagementServlet/update",
		"/UsersManagementServlet/delete", "/UsersManagementServlet/reset", "/UsersManagementServlet/edit" })
public class UsersManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		User user = null;
		if (url.contains("create")) {
			create(request, response);
		}
		if (url.contains("edit")) {
			edit(request, response);
		}
		if (url.contains("delete")) {
			delete(request, response);
			user = new User();
			request.setAttribute("user", user);
		}
		if (url.contains("reset")) {
			reset(request, response);
			user = new User();
			request.setAttribute("user", user);
		}
		findAll(request, response);

		PageInfo.preparaAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			create(request, response);
			request.setAttribute("user", new User());
		}
		if (url.contains("update")) {
			update(request, response);
			request.setAttribute("user", new User());
		}
		if (url.contains("delete")) {
			delete(request, response);
			request.setAttribute("user", new User());
		}
		if (url.contains("reset")) {
			reset(request, response);
			request.setAttribute("user", new User());
		}
		findAll(request, response);
		PageInfo.preparaAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());

			UserDao dao = new UserDao();
			dao.insert(user);

			request.setAttribute("user", user);
			request.setAttribute("message", "Thêm thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.preparaAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) {
		

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			
			UserDao dao = new UserDao();
			dao.delete(username);
			
			request.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = new User();
			
			BeanUtils.populate(user, request.getParameterMap());
			UserDao dao = new UserDao();
			dao.update(user);
			
			request.setAttribute("user", user);
			request.setAttribute("message", "Chỉnh sửa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");

			UserDao dao = new UserDao();
			User user = dao.findById(username);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}

	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDao dao = new UserDao();

			List<User> list = dao.findAll();

			request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
