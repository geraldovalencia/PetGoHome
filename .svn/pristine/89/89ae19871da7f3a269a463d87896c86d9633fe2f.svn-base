package br.com.petGoHome.QrCode;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CriarThumbnail {
	
	public static void createThumbnail(String orig, String thumb, int maxDim) { 
		try { 

		Image inImage = new ImageIcon(orig).getImage(); 
		double scale = (double)maxDim/(double)inImage.getWidth(null); 

		int scaledW = (int)(scale*inImage.getWidth(null)); 
		int scaledH = (int)(scale*inImage.getHeight(null)); 
		BufferedImage outImage = new BufferedImage(scaledW, scaledH, BufferedImage.TYPE_INT_RGB); 
		AffineTransform tx = new AffineTransform(); 

		if (scale < 1.0d) { 
		tx.scale(scale, scale); 
		} 

		Graphics2D g2d = outImage.createGraphics(); 
		g2d.drawImage(inImage, tx, null); 
		g2d.dispose(); 

		OutputStream os = new FileOutputStream(thumb); 
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os); 
		encoder.encode(outImage); 
		os.close(); 
		} catch (IOException e) { 
		System.out.println("Erro: "+e.getMessage()); 
		e.printStackTrace(); 
		} 
		} 

}
