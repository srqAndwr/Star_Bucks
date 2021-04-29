package com.StarBucks.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ����У�����ͼƬ
 */
@Controller
public class VerfimgController{
	@RequestMapping("/Verfimg")
	protected void Verfimg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        // ��ֹ������������ͼ��  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        //֪ͨ�ͻ�����ͼƬ�ķ�ʽ�򿪷��͹�ȥ������
        response.setContentType("image/jpeg");
		
		//1.����java����һ��ͼƬ
		//���ڴ��д���һ��ͼƬ
        final int WIDTH = 80;  
	    final int HIGHT = 34; 
	    final char[] CODE_SEQUENCE = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		// ��֤���ַ�����
		final int CODE_COUNT = 4;
		// �����λ�ò���
		final int FONT_AREA = WIDTH / (CODE_COUNT + 1);
		BufferedImage image=new BufferedImage(WIDTH,HIGHT,BufferedImage.TYPE_INT_RGB);
		//��ͼƬ��д����
		Graphics2D g = image.createGraphics();
		//���ñ������ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0,0,WIDTH,HIGHT);
		//2.��ͼƬ�д�ӡ4��������ַ�
		Random r=new Random();
		//��ӡ����   
        // ���ݸ߿��������壬�������ַ��  plain bold italic  
        Font font = new Font("Fixedsys", Font.ITALIC, HIGHT - 5);  
		g.setFont(font);
		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, WIDTH - 1, HIGHT - 1);
		// �����������������  
        for (int k = 0; k < 8; k++) {  
            int x1 = r.nextInt(WIDTH);  
            int y1 = r.nextInt(HIGHT);  
            int x2 = r.nextInt(40);  
            int y2 = r.nextInt(40);  
            g.drawLine(x1, y1, x1 + x2, y1 + y2);  
        }  
        // ���������  
        int red = 0, green = 0, blue = 0;  
        // �洢���ݵ�buffer  
        StringBuffer strb = new StringBuffer();  
        for (int i = 0; i < CODE_COUNT; i++) {  
            // �õ������  
            String strRand = String.valueOf(CODE_SEQUENCE[r.nextInt(36)]);  
            // �����������ɫ  
            red = r.nextInt(255);  
            green = r.nextInt(255);  
            blue = r.nextInt(255);  
            // ����֤����ͼ��  
            g.setColor(new Color(red, green, blue));  
            g.drawString(strRand, (i ) * FONT_AREA, HIGHT - 10);// x,y������λ��,���տ�ȷ�5������  
            // ƴ������  
            strb.append(strRand);  
        }  
        // ����session�������ɵ�У����ŵ�session��
     	request.getSession().setAttribute("CheckCode", strb.toString().toUpperCase());
		//3.��response���ͼƬ
		ServletOutputStream sos = response.getOutputStream(); 	
		ImageIO.write(image, "jpg", sos);
        sos.close();  
		
	}
}