package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import tool.Page;


@WebServlet(urlPatterns={"/chapter17/cart-add"})
public class CartAdd extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		PrintWriter out=resp.getWriter();
		Page.header(out);

		String name=req.getParameter("name");
		int price=Integer.parseInt(req.getParameter("price"));

		//セッションのスタート（開始）
		HttpSession session=req.getSession();

		//セッションに既に同じ変数が存在しないか確認してインスタンス実行
		List<Product> cart=(List<Product>)session.getAttribute("cart");
		if (cart==null) {
			cart=new ArrayList<Product>();
		}

		Product p=new Product();
		p.setName(name);
		p.setPrice(price);
		cart.add(p);

		//setAttributeを使ってセッションに入力情報を保存
		session.setAttribute("cart", cart);

		out.println("カートに商品を追加しました。");
		Page.footer(out);

	}





}

