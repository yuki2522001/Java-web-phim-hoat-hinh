package edu.poly.sites.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import edu.poly.common.EmailUtility;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.ShareDao;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.Share;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShareServlet")
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		String videoId = request.getParameter("videoId");

		if (videoId == null) {
			response.sendRedirect("/Homepage");
			return;
		}
		request.setAttribute("videoId", videoId);
		PageInfo.preparaAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String emailAddress = request.getParameter("email");
			String videoId = request.getParameter("videoId");

			if (videoId == null) {
				request.setAttribute("error", "Video Id is null");
			} else {
				Email email = new Email();

				email.setFrom("hocjavafpt@gmail.com");
				email.setFormPassword("0906416036");
				email.setTo(emailAddress);
				email.setSubject("Share Favorite Video");

				StringBuilder sb = new StringBuilder();
				sb.append("Dear Ms/Mr. <br> ");
				sb.append("The video is more interesting ang I want to share with you <br>");
				sb.append("Please click the link")
						.append(String.format("<a href='${videos.description}'> View Video</a><br>", videoId));
				sb.append("Regards<br>");
				sb.append("Administrator");

				email.setContent(sb.toString());
				try {
					edu.poly.domain.EmailShare.sendEmail(email);
				} catch (Exception e) {

					e.printStackTrace();
				}

				ShareDao dao = new ShareDao();
				Share share = new Share();
				share.setEmails(emailAddress);
				share.setSharedDate(new Date());

				String username = SessionUtils.getLoginUsername(request);
				User user = new User();
				user.setUsername(username);

				share.setUser(user);
				Video video = new Video();
				video.setVideoId(videoId);
				share.setVideo(video);

				dao.insert(share);
				request.setAttribute("message", "Video link has been sent");

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparaAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
	}

}
