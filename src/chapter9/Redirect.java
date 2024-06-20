package chapter9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/chapter9/redirect"})
public class Redirect extends HttpServlet {

	public void doGet (
			HttpServletRequest request,HttpServletResponse response
			) throws ServletException,IOException{
		//リダイレクト実行：http://tomcat.apache.org/
		//リダイレクトをやる理由　処理の結果によって見せたいページを制限する
				response.sendRedirect("http://tomcat.apache.org/");


	}

}
