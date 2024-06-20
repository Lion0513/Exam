package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/search"})
public class Search extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		Page.header(out);
		//tryを使って例外処理をしている
		//DB接続を行う場合、例外処理の可能性が高まるので必須
		try{
			//JSPで入力された値を取得->変数：keywordに格納
			String keyword=req.getParameter("keyword");

			//ProsuctDAOのインスタンス
			ProductDAO dao=new ProductDAO();
			//seachメソッドの実行でDBからデータを取得
			//引数に入力値を入れることで入力した値をもとにデータを取得
			List<Product> list=dao.serach(keyword);

			for (Product p : list){
				//ループ文を使って画面にデータを表示させる
				//変数にデータを格納する



				out.println(p.getId());
				out.println(":");
				out.println(p.getName());
				out.println(":");
				out.println(p.getPrice());
				out.println("<br>");
			}

		} catch (Exception e) {
			e.printStackTrace(out);

		}
		Page.footer(out);
	}


}
