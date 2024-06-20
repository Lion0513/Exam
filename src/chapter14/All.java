package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/all"})
public class All extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");//contxet.xml name属性を紐づける

			// DataSourceのgetConnectionメソッドを使ってDBと接続
			Connection con=ds.getConnection();

			//DBに向けて送るSQLを記述
			PreparedStatement st=con.prepareStatement(
			"select * from product");
			//SQLの実行　結果をResultSet型のrsに格納
			ResultSet rs=st.executeQuery();


			//SQLの結果を全て表示する(ループ文)
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String price = rs.getString("price");
				//getInt,getStringでテーブルの項目名を指定することで値を取得
				out.println(id);
				out.println("：");
				out.println(name);
				out.println("：");
				out.println(price);
				out.println("<br>");
			}

			//SQLの設定を終了(解放)する
			st.close();
			//DBの接続を切断する
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
