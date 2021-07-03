package edu.poly.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUtils {
//	public static String processUploadFiled(String fieldName, HttpServletRequest request,
//			String storeFolder, String storeFileName) throws IOException, ServletException {
//		Part filePart = request.getPart(fieldName);
//		
//		if(filePart == null || filePart.getSize() == 0) {
//			return "";
//		}
//		if(storeFolder == null) {
//			storeFolder = "uploads";
//		}
//		if(storeFileName == null) {
//			storeFileName = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
//		}else {
//			storeFileName += "." + FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString());
//		}
//		String uploadFolder = request.getServletContext().getRealPath(storeFolder);
//		
//		Path uploadPath = Paths.get(uploadFolder);
//		
//		if(!Files.exists(uploadPath)) {
//			Files.createDirectory(uploadPath);
//		}
//		filePart.write(Paths.get(uploadPath.toString(), storeFileName).toString());
//		return storeFileName;
//	}
	public static String processUploadFiled(String filedName, HttpServletRequest request, String StoredFolder,
			String storedFileName) throws IOException, ServletException {
		Part filePart = request.getPart(filedName);

		if (filePart == null || filePart.getSize() == 0) {
			return "";
		}
		if (StoredFolder == null) {
			StoredFolder = "/uploads";
		}
		if (storedFileName == null) {
			storedFileName = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
		} else {
			storedFileName += "." + FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString());
		}
		String uploadFolder = request.getServletContext().getRealPath(StoredFolder);

		Path uploadPath = Paths.get(uploadFolder);
		if (!Files.exists(uploadPath)) {
			Files.createDirectory(uploadPath);
		}
		filePart.write(Paths.get(uploadPath.toString(), storedFileName).toString());
		return storedFileName;

	}
}
