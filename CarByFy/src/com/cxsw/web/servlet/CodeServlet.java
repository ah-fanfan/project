package com.cxsw.web.servlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/code")
public class CodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int charNum = 4;
		int width = 20 * 4;
		int height = 28;

		// 1. ����һ���ڴ�ͼƬ
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 2.��û�ͼ����?
		Graphics graphics = bufferedImage.getGraphics();

		// 3�����Ʊ�����ɫ
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width, height);

		// 4������ͼƬ�߿�
		graphics.setColor(Color.GRAY);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 5�������֤������?
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("����", Font.BOLD, 22));
		
		// ������4���ַ�
		String s = "ABCDEFGHGKLMNPQRSTUVWXYZ23456789";
		Random random = new Random();
		
		// session��Ҫ�õ�
		String msg = "";
		
		int x = 5;
		for (int i = 0; i < charNum; i++) {
			int index = random.nextInt(32);
			String content = String.valueOf(s.charAt(index));
			
			msg += content;
			graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			graphics.drawString(content, x, 22);
			x += 20;
		}

		// 6�����Ƹ�����
		graphics.setColor(Color.GRAY);
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(width);

			int y1 = random.nextInt(height);
			int y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}

		// �ͷ���Դ
		graphics.dispose();

		// ͼƬ���? ImageIO
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		HttpSession session = request.getSession();
	//	System.out.println(msg+"99999999999999999999999");
		session.setAttribute("YZM", msg);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
	}

}
