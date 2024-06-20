package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

//ルーティング　URLが入っていると実行される→/chapter5/greeting
@WebServlet(urlPatterns={"/chapter5/greeting"})
public class Greeting extends HttpServlet {

	//GETメソッドが呼ばれた
	public void doGet(
		HttpServletRequest request,HttpServletResponse response
	)throws ServletException, IOException{

		//画面に表示するのはHTML型のUTF-8で表示
		response.setContentType("text/html;charset=UTF-8");
		//画面に表示するためのメソッドをインスタンス
		PrintWriter out=response.getWriter();

		//文字型のエンコードがUTF-8
		request.setCharacterEncoding("UTF-8");
		//リクエストデータのパラメータ[user]の値を取得する
		String user=request.getParameter("user");

		Page.header(out);
		out.println("<p>こんにちは、"+user+"さん！</p>");
		Page.footer(out);

	}
}


