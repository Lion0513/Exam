package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/bean"})
public class Bean extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		PrintWriter out =resp.getWriter();
		Page.header(out);

		//Product(Bean)をインスタンス化
		Product p=new Product();

		//Beanに値を設定することで変数に関連性を持たせる
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);

		int id = p.getId();
		String name = p.getName();
		int price = p.getPrice();

		//getInt,getStringでテーブルの項目名を指定することで価を取得
		out.println(p.getId());
		out.println(":");
		out.println(p.getName());
		out.println(":");
		out.println(p.getPrice());

		Page.footer(out);

	}


}
