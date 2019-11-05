package com.test;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		VerifyCode code = new VerifyCode();
		BufferedImage image = code.getImage();
		System.out.println(code.getText());
		VerifyCode.output(image, new FileOutputStream("D:/b.jpg"));
		
	}
}
