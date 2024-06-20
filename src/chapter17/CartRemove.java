package chapter17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Page;


@WebServlet(urlPatterns={"/chapter17/cart-remove"})
public class CartRemove extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		PrintWriter out=resp.getWriter();
		Page.header(out);


		//セッションの開始
		HttpSession session=req.getSession();
		//セッションに保存されているデータを削除
		session.removeAttribute("cart");

		out.print("カートを削除しました。");
		Page.footer(out);
	}



}
