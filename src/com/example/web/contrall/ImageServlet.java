package com.example.web.contrall;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ImageServlet", urlPatterns = "/ImageServlet")
public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = -799945919134851655L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 这个方法会实现验证码的生成
        BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB); // 创建图像缓冲
        Graphics g = bi.getGraphics(); // 通过缓冲区创建一个画布
        Color c = new Color(200, 255, 255);
        // 根据背景画一个矩形
        g.setColor(c);  // 为画布创建一个背景颜色
        g.fillRect(0, 0, 68, 22);   // fileRect:填充指定的矩形

        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray(); // 转化成字符型数组
        Random r = new Random();
        int len = ch.length;
        int index;      // index用于存放随机数
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            index  = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));   // 设置配色
            g.drawString(ch[index] + "", (i * 15) + 3, 18); // 画数字及数字的位置
            sb.append(ch[index]);
        }
        request.getSession().setAttribute("piccode", sb.toString());    // 将数字保留在session中，以便后用
        System.out.println(sb);
        ImageIO.write(bi, "PNG", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
