package chapter22;

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

@WebServlet(urlPatterns={"/chapter22/insert"})
public class Insert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);
		try{
			// getParameterメソッドを利用してJSPの中で入力された値を取得
			String name=req.getParameter("name");
			// getParameterメソッドを利用してJSPの中で入力された値を取得
			int price= Integer.parseInt( req.getParameter("price"));

			// ProductDAO のインスタンス
			ProductDAO dao = new ProductDAO();

			Product p = new Product();
			p.setName(name);
			p.setPrice(price);

			// インサート処理の実行
			int line = dao.insert(p);

			if(line>0){
				// JSPをforwardする仕組み
				// JSPに画面表示は全て任せる
				// サーブレット側でデータ処理を行なう
				req.getRequestDispatcher("insert_success.jsp").forward(req, resp);

			}else{
				out.println("追加できませんでした");

			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);

	}

}
