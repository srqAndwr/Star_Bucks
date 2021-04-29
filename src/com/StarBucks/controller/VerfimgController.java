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
 * 生成校验码的图片
 */
@Controller
public class VerfimgController{
	@RequestMapping("/Verfimg")
	protected void Verfimg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        // 禁止浏览器缓存随机图像。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        //通知客户机以图片的方式打开发送过去的数据
        response.setContentType("image/jpeg");
		
		//1.利用java生成一张图片
		//在内存中创建一副图片
        final int WIDTH = 80;  
	    final int HIGHT = 34; 
	    final char[] CODE_SEQUENCE = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		// 验证码字符个数
		final int CODE_COUNT = 4;
		// 字体的位置参数
		final int FONT_AREA = WIDTH / (CODE_COUNT + 1);
		BufferedImage image=new BufferedImage(WIDTH,HIGHT,BufferedImage.TYPE_INT_RGB);
		//向图片上写数据
		Graphics2D g = image.createGraphics();
		//设置背景填充色
		g.setColor(Color.WHITE);
		g.fillRect(0,0,WIDTH,HIGHT);
		//2.在图片中打印4个随机的字符
		Random r=new Random();
		//打印数字   
        // 根据高宽设置字体，字体四种风格  plain bold italic  
        Font font = new Font("Fixedsys", Font.ITALIC, HIGHT - 5);  
		g.setFont(font);
		// 画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, WIDTH - 1, HIGHT - 1);
		// 随机产生几条干扰线  
        for (int k = 0; k < 8; k++) {  
            int x1 = r.nextInt(WIDTH);  
            int y1 = r.nextInt(HIGHT);  
            int x2 = r.nextInt(40);  
            int y2 = r.nextInt(40);  
            g.drawLine(x1, y1, x1 + x2, y1 + y2);  
        }  
        // 产生随机码  
        int red = 0, green = 0, blue = 0;  
        // 存储数据的buffer  
        StringBuffer strb = new StringBuffer();  
        for (int i = 0; i < CODE_COUNT; i++) {  
            // 得到随机数  
            String strRand = String.valueOf(CODE_SEQUENCE[r.nextInt(36)]);  
            // 产生随机的颜色  
            red = r.nextInt(255);  
            green = r.nextInt(255);  
            blue = r.nextInt(255);  
            // 将验证码绘成图案  
            g.setColor(new Color(red, green, blue));  
            g.drawString(strRand, (i ) * FONT_AREA, HIGHT - 10);// x,y表坐标位置,按照宽度分5个坐标  
            // 拼接数字  
            strb.append(strRand);  
        }  
        // 设置session，把生成的校验码放到session里
     	request.getSession().setAttribute("CheckCode", strb.toString().toUpperCase());
		//3.在response输出图片
		ServletOutputStream sos = response.getOutputStream(); 	
		ImageIO.write(image, "jpg", sos);
        sos.close();  
		
	}
}