package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//パス
//コンテキストパス：http://localhost:8080/book
//コンテキストパスからの相対パス:/chapter3/hello
//↓404エラーが発生したら確認する場所
@WebServlet(urlPatterns={"/chapter3/hello"})
//public class ファイル名と同じ(大文字小文字判定あり)
//javaのClass名は先頭大文字(アッパーキャメルケース）
public class Hello extends HttpServlet{

	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException{

		//HTMLへの書き出しを行うための定義
		PrintWriter out=response.getWriter();
		//↓HTMLの記述(HTMLを作成する関数)
		out.println("Hello!");
		//現在時刻の取得＋ブラウザに表示
		out.println(new java.util.Date());
	}

}


