package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedImage image = new BufferedImage(150, 70, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = (Graphics2D) image.getGraphics();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, 150, 70);
		graphics2d.setColor(Color.red);
		graphics2d.drawRect(0, 0, 150 - 1, 70 - 1);

		graphics2d.setColor(Color.BLACK);
		graphics2d.setFont(new Font("宋体", Font.BOLD, 25));
		graphics2d.drawString("hello", 10, 30);

		ImageIO.write(image, "JPEG", new FileOutputStream("D:/a.jpg"));

	}
}
