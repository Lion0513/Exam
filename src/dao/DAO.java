package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DAO {
	//全てのインスタンスで利用するため
	//staticフィールドとして定義（グローバル変数）
	static DataSource ds;

	//データベースへ接続する処理をgetConnectionという名前のメソッドにまとめている
	public  Connection getConnection() throws Exception {
		//データソースを確認して未接続のみ接続を実行
		if (ds==null){
			//データソースを取得するためのインスタンス
			InitialContext ic=new InitialContext();
			//context.xmlのjdbc/bookで定義した接続情報でDBに接続
			ds=(DataSource)ic.lookup("java:/comp/env/jdbc/book");
		}
		//接続情報を戻り値として返す
		return ds.getConnection();
	}

}
