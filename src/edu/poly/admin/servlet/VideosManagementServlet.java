package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.UploadUtils;
import edu.poly.dao.UserDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class VideosManagementServlet
 */
@MultipartConfig
@WebServlet({ "/Admin/VideosManagement", "/Admin/VideosManagement/create", "/Admin/VideosManagement/update",
		"/Admin/VideosManagement/delete", "/Admin/VideosManagement/reset", "/Admin/VideosManagement/edit" })
public class VideosManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) { 
			edit(request, response);
			return;
		
		} else if (url.contains("delete")) {
			delete(request, response);	
			return;

		} else if (url.contains("reset")) {
			reset(request, response);	
			return;
			
		} /*
			 * else if (url.contains("create")) { create(request, response); }
			 */
		
		Video video = new Video();
		video.setPoster("images/do.png");
		
		findAll(request, response);
		request.setAttribute("video", video);
		PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
            return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}
		findAll(request, response);
		PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		video.setPoster("images/do.png");
		request.setAttribute("video", video);
		findAll(request, response);
		PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoId = request.getParameter("videoId");
		if (videoId == null) {
			request.setAttribute("error", "Video id is required");
			PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);		
			return;
		}
		try {

			VideoDao dao = new VideoDao();
			Video video = dao.findById(videoId);
			
			if(video == null) {
				request.setAttribute("error", "Video id not found");
				PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);		
				return;
			}
			dao.delete(videoId);
			request.setAttribute("message", "Xóa thành công");
			request.setAttribute("video", new Video());
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);		

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {		
			BeanUtils.populate(video, request.getParameterMap());

			VideoDao dao = new VideoDao();
     		Video oldVideo = dao.findById(video.getVideoId());
		
			if (request.getPart("cover").getSize()==0) {
				video.setPoster(oldVideo.getPoster());
			}else {
				video.setPoster("uploads/" + UploadUtils.processUploadFiled("cover", request, 					
						"/uploads", video.getVideoId()));
			}
			dao.update(video);

			request.setAttribute("video", video);
			request.setAttribute("message", "Chỉnh sửa thành công");
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);		

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoId = request.getParameter("videoId");
		if (videoId == null) {
			request.setAttribute("error", "Video id is required");
			PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);		
			return;
		}
		try {
			
			VideoDao dao = new VideoDao();
			Video video = dao.findById(videoId);
			request.setAttribute("video", video);
			findAll(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();

		try {
			BeanUtils.populate(video, request.getParameterMap());
			video.setPoster("uploads/" + UploadUtils.processUploadFiled("cover", request, 
					"/uploads", video.getVideoId()));
			
			VideoDao dao = new VideoDao();
			dao.insert(video);

			request.setAttribute("video", video);
			request.setAttribute("message", "Thêm thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		findAll(request, response);
		PageInfo.preparaAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();

			List<Video> list = dao.findAll();

			request.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
