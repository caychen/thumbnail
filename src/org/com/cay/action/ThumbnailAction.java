package org.com.cay.action;

import javax.servlet.http.HttpSession;

import org.com.cay.service.ThumbnailService;
import org.com.cay.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ThumbnailAction {
	
	private UploadService uploadService;
	private ThumbnailService thumbnailService;

	@Autowired
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@Autowired
	public void setThumbnailService(ThumbnailService thumbnailService) {
		this.thumbnailService = thumbnailService;
	}


	@RequestMapping(value = "/thumbnail.action", method = RequestMethod.POST)
	public ModelAndView thumbnail(@RequestParam("image") CommonsMultipartFile file, HttpSession session) throws Exception{
		String uploadPath = "/images";
		String realUploadPath = session.getServletContext().getRealPath(uploadPath);
		//System.out.println(realUploadPath);
		
		String imageUrl = uploadService.uploadImage(file, uploadPath, realUploadPath);
		String thumbImageUrl = thumbnailService.thumbnail(file, uploadPath, realUploadPath);
		
		ModelAndView ret = new ModelAndView();
		ret.addObject("imageUrl", imageUrl);
		ret.addObject("thumbImageUrl", thumbImageUrl);
		
		ret.setViewName("thumbnail");//jsp页面的名称
		
		return ret;
	}
}
