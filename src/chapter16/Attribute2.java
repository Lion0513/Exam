package chapter16;

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

@WebServlet(urlPatterns={"/chapter16/attribute2"})
public class Attribute2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		try{
			//DB内のデータにアクセスする為DAOを使う
			//アクセスするテーブル名がPRODUCTなのでprojectDAOをインスタンスする
			ProductDAO dao=new ProductDAO();
			//検索の結果をList型（ProductのList）で取得する
			//DB検索はseach()メソッドを使う
			List<Product> list=dao.serach("");

			//Request.setAttribute（）メソッドを使ってjspにProduct型のオブジェクトのリスト"list"をわたせるようにする
			req.setAttribute("list", list);

			//attribute.jspをつかってフォワード（実行）する
			req.getRequestDispatcher("attribute2.jsp")
			.forward(req, resp);
		} catch (Exception e){
			e.printStackTrace(out);
		}
	}

}
