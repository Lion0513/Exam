package chapter22;

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

@WebServlet(urlPatterns={"/chapter22/search"})
public class Search extends HttpServlet {
	@Override
	//	POSTでの実行（値の引き渡し）
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);
		try{
			// getParameterメソッドを利用してJSPの中で入力された値を取得
			String keyword=req.getParameter("keyword");
			// ProductDAO のインスタンス
			ProductDAO dao = new ProductDAO();
			List<Product> list;
			// keyword の有無で呼び出すメソッドを変更
			if(keyword == null || keyword == ""){
				// allメソッドの実行で DBからデータを取得
				list = dao.all();

			}else{
				// seachメソッドの実行で DBからデータを取得
				// 引数に入力値を入れる事で入力した値を元にデータを取得
				list = dao.serach(keyword);
			}
			// Request.setAttribute()メソッドを使って
			// JSP にStudent型オブジェクトのリスト"list"を渡せるようにする
			req.setAttribute("list", list);

			// "attribute2.jsp"をフォワード(実行) する
			req.getRequestDispatcher("output.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
