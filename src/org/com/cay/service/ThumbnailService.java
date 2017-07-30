package org.com.cay.service;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class ThumbnailService {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;
	
	public String thumbnail(CommonsMultipartFile file, String uploadPath, String realUploadPath){
		String des = realUploadPath + File.separator + "thumb_" + file.getOriginalFilename();
		
		try {
			//Thumbnails.of(file.getInputStream()).keepAspectRatio(true);//保持原图，不进行缩略
			Thumbnails.of(file.getInputStream()).size(WIDTH, HEIGHT).toFile(des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}; 
		
		return uploadPath + "/thumb_" + file.getOriginalFilename();
	}
}
