package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/insert"})
public class Insert extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		//例外処理
		try {
			String name=request.getParameter("name");

			int price=Integer.parseInt(request.getParameter("price"));

			//Productのインスタンス
			Product p=new Product();
			//セッターを使ってProductクラスのフィールドを定義
			p.setName(name);
			p.setPrice(price);

			//Productのインスタンス
			ProductDAO dao=new ProductDAO();
			//ProductDAO.insert()メソッドを実行->更新データ件数を取得
			int line=dao.insert(p);

			//更新データの件数が0件より多かった場合、更新成功
			if (line>0) {
				out.println("追加に成功しました。");
			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
