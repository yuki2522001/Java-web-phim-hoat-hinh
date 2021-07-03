package edu.poly.sites.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import edu.poly.common.EmailUtility;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

/**
 * Servlet implementation class ForgotpasswordServlet
 */
@WebServlet("/Forgotpassword")
public class ForgotpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgotpasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.preparaAndForwardSite(request, response, PageType.SITE_FORGOTPASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = "hocjavafpt@gmail.com";
		String password = "0906416036";
		String subject = "Your Password has been reset";
		String name = "COMPANY PIONEER";
		String recipient = request.getParameter("email");
		String newPassword = resetCustomerPassword(recipient);

		String content = "Hi, this is your new password: " + newPassword;
		content += "\nNote: for security reason, " + "you must change your password after logging in.";

		String message = "";

		try {
			EmailUtility.sendEmail(email, name, password, recipient, subject, content);
			message = "Your password has been reset. Please check your e-mail.";
		} catch (Exception ex) {
			ex.printStackTrace();
			message = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("message", message);
			PageInfo.preparaAndForwardSite(request, response, PageType.SITE_FORGOTPASSWORD_PAGE);
		}
	}

	public String resetCustomerPassword(String email) {
		UserDao dao = new UserDao();
		User user = dao.findByEmail(email);
		String randomPassword = RandomStringUtils.randomAlphanumeric(10);
		user.setPassword(randomPassword);
		dao.update(user);
		return randomPassword;
	}

}