package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/insert"})
public class Insert extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();

			String name=request.getParameter("name");
			//Integer.parseIntメソッドを利用して文字列をINTにする
			int price=Integer.parseInt(request.getParameter("price"));

			PreparedStatement st=con.prepareStatement(
				//INSRT文を用意してデータベースにデータを登録できるようにする
				"insert into product values(null, ?, ?)");
			st.setString(1, name);
			st.setInt(2, price);

			//登録件数、更新件数を取得
			int line=st.executeUpdate();

			if (line>0) {
				request.getRequestDispatcher("insert_success.jsp").forward(request, response);
				out.println("追加に成功しました。");
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
