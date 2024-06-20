package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

// ルーティング
@WebServlet(urlPatterns={"/chapter6/select"})
public class Select extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		//出力の形を「html」に指定
		//文字コードを「UTF-8」に指定
		response.setContentType("text/html; charset=UTF-8");
		//インスタンス
		PrintWriter out=response.getWriter();

		//受け取る文字をUTF-8エンコード
		request.setCharacterEncoding("UTF-8");
		//フォームに入力された値を取得
		//すべて文字型で受け取り
		String count=request.getParameter("count");
		String payment=request.getParameter("payment");
		String review=request.getParameter("review");
		String mail=request.getParameter("mail");

		//HTMLで出力
		Page.header(out);
		out.println("<p>"+count+"個の商品をカートに入れました。</p>");
		out.println("<p>お支払い方法を"+payment+"に設定しました。</p>");
		out.println("<p>ご感想ありがとうございます。</p>");
		out.println("<p>「"+review+"」</p>");

		//チェックボックス「mail」の値で分岐して表示する
		if (mail!=null) {
			out.println("<p>メールをお送りします。</p>");
		} else {
			out.println("<p>メールはお送りしません。</p>");
		}
		Page.footer(out);
	}
}