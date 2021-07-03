package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteUser;
import edu.poly.domain.Send;
import edu.poly.model.Video;

/**
 * Servlet implementation class ReportsManagementServlet
 */
@WebServlet("/ReportsManagementServlet")
public class ReportsManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reportFavoriteByVideos(request, response);
		reportFavoriteUsers(request, response);
		reportFavoriteShare(request, response);
		PageInfo.preparaAndForward(request, response, PageType.REPOERT_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void reportFavoriteByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteReport> list = dao.reportFavriteByVideo();

			request.setAttribute("favList", list);
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void reportFavoriteUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

		String videoUserId = request.getParameter("videoUserId");
		
		VideoDao vdao = new VideoDao();
		List<Video> vlist = vdao.findAll();
		
		if (videoUserId == null && vlist.size()>0) {
			videoUserId = vlist.get(0).getVideoId();
		}
		
		FavoriteDao dao = new FavoriteDao();
		List<FavoriteUser> list = dao.findUserByVideoID(videoUserId);
		
		request.setAttribute("videoUserId", videoUserId);
		request.setAttribute("vidlist", vlist);
		request.setAttribute("favUsers", list);
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Error: " + e.getMessage());
			}
	}

	protected void reportFavoriteShare(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

		String videoShareId = request.getParameter("videoShareId");
		
		VideoDao vdao = new VideoDao();
		List<Video> slist = vdao.findAll();
		
		if (videoShareId == null && slist.size()>0) {
			videoShareId = slist.get(0).getVideoId();
		}
		
		FavoriteDao dao = new FavoriteDao();
		List<Send> list = dao.reportShareFriendsByVideos(videoShareId);
		
		request.setAttribute("videoShareId", videoShareId);
		request.setAttribute("sidlist", slist);
		request.setAttribute("favShare", list);
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Error: " + e.getMessage());
			}
	}
}
