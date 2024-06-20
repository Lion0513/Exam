package chapter16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;


@WebServlet(urlPatterns={"/chapter16/attribute"})
public class Attribute extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//bean.Product型のオブジェクトのインスタンス
		Product p=new Product();
		//Product型のオブジェクトにsetメソッドを使って値を設定
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);

		//Request.setAttribute（）メソッドを使ってjspにProduct型のオブジェクトpをわたせるようにする
		req.setAttribute("product", p);

		//attribute.jspをつかってフォワード（実行）する
		req.getRequestDispatcher("attribute.jsp")
		.forward(req, resp);


	}

}
