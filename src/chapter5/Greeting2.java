package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter5/greeting2"})
public class Greeting2 extends HttpServlet {

	//POSTメソッドが実行されています
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		//表示の設定HTMLUTF-8
		response.setContentType("text/html; charset=UTF-8");
		//インスタンス
		PrintWriter out=response.getWriter();

		//エンコードの設定
		request.setCharacterEncoding("UTF-8");
		//ゲットパラメータ「user」を取得している
		String user=request.getParameter("user");


		Page.header(out);
		out.println("<p>こんにちは、"+user+"さん！</p>");
		Page.footer(out);
	}
}
