package org.com.cay.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ThumbnailAWTService {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;

	@SuppressWarnings("static-access")
	public String thumbnail(CommonsMultipartFile file, String uploadPath,
			String realUploadPath) {
		OutputStream os = null;

		try {
			String des = realUploadPath + File.separator
					+ file.getOriginalFilename();
			os = new FileOutputStream(des);

			Image image = ImageIO.read(file.getInputStream());
			int width = image.getWidth(null);// 原图宽带
			int height = image.getHeight(null);// 原图高度

			int rate1 = width / WIDTH;
			int rate2 = height / HEIGHT;

			int rate = rate1 > rate2 ? rate1 : rate2;

			int newWidth = width / rate;
			int newHeight = height / rate;

			BufferedImage bufferedImage = new BufferedImage(newWidth,
					newHeight, BufferedImage.TYPE_INT_BGR);

			bufferedImage.getGraphics().drawImage(
					image.getScaledInstance(newWidth, newHeight,
							image.SCALE_SMOOTH), 0, 0, null);

			String imageType = file.getContentType().substring(
					file.getContentType().indexOf("/") + 1);
			ImageIO.write(bufferedImage, imageType, os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return uploadPath + "/" + file.getOriginalFilename();
	}
}
