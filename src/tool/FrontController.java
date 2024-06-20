package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *.action <- URLの末尾に".action"が付いたら必ず実行される
@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp
			) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();



		try {
			//Srvletのある場所を取得
			String path=req.getServletPath().substring(1);
			//実際に実行するアクションを呼ぶ準備
			String name=path.replace(".a", "A").replace('/', '.');
			Action action = (Action)Class.forName(name).
					getDeclaredConstructor().newInstance();
			//抽象クラスを呼び出し <= アクション（Javaクラス）の実行
			String url=action.execute(req, resp);

			req.getRequestDispatcher(url).forward(req, resp);

		}catch (Exception e) {
			e.printStackTrace(out);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);

	}




}
