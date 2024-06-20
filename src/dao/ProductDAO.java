package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

// DBのProductテーブルに接続するクラス ProductDAO
// DAOクラスを継承(extends) する事でDBに接続ができる
public class ProductDAO extends DAO {
	public List<Product> all() throws Exception{
		// ArrayListのインスタンス（Product型を定義）
		List<Product> list = new ArrayList<>();
		// DAO のgetConnectionメソッドを使ってDBと接続
		Connection con = getConnection();
		// 実際に実行するSQLを設定 プレースホルダを使って後からSQLを変換
		PreparedStatement st = con.prepareStatement(
				"select * from PRODUCT"
				);
		// SQLを実行して 実行した結果を 変数:rs に格納
		ResultSet rs = st.executeQuery();
		// ループ文を使って rs の中身を1行ごとに処理
		while( rs.next() ){
			// Product(Bean)をインスタンス化
			Product p=new Product();
			// Beanに値を設定する
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			// addメソッドを使って 設定したBeanを Listに追加
			list.add(p);
		}
		// SQLの設定を終了（開放）する
		st.close();
		// DBとの接続を切断する
		con.close();
		// Beanのリストを戻り値として返す
		return list;

	}
	// Product型(bean.Product) の List を返す serachメソッド
	public List<Product> serach(String keyword) throws Exception{
		// ArrayListのインスタンス（Product型を定義）
		List<Product> list = new ArrayList<>();
		// DAO のgetConnectionメソッドを使ってDBと接続
		Connection con = getConnection();
		// 実際に実行するSQLを設定 プレースホルダを使って後からSQLを変換
		PreparedStatement st = con.prepareStatement(
				"select * from PRODUCT where NAME like ? "
				);
		// プレースホルダの値を 引数:keyword に変換
		st.setString(1, "%" + keyword + "%");
		// SQLを実行して 実行した結果を 変数:rs に格納
		ResultSet rs = st.executeQuery();
		// ループ文を使って rs の中身を1行ごとに処理
		while( rs.next() ){
			// Product(Bean)をインスタンス化
			Product p=new Product();
			// Beanに値を設定する
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			// addメソッドを使って 設定したBeanを Listに追加
			list.add(p);
		}
		// SQLの設定を終了（開放）する
		st.close();
		// DBとの接続を切断する
		con.close();
		// Beanのリストを戻り値として返す
		return list;

	}

	// Productテーブルにデータを追加するときに使うメソッド
	// 既に一度ProductDAOを実行している
	public int insert(Product product) throws Exception{
		// DAOのgetConnectionメソッドを使ってDBと接続
		Connection con = getConnection();
		// 実行するSQLを設定
		PreparedStatement st = con.prepareStatement(
				// INSRT文を用意してデータベースにデータを登録できるようにする
				// ?（プレースホルダ）を検索文字列を置き換えできるようにする
				"insert into PRODUCT values(null, ?, ?)"
				);
		// プレースホルダを変数に変換
		// Been.Product のゲッターを使って値を変換
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		// SQLの実行 実行結果は更新行が返ってくる
		int line = st.executeUpdate();
		// SQLの設定を終了（開放）する
		st.close();
		// DBとの接続を切断する
		con.close();
		// 更新行を実行結果として返す
		return line;
	}

}
