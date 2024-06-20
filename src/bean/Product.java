package bean;

public class Product implements java.io.Serializable {

	private int id;
	private String name;
	private int price;


	//ゲッターとセッターの設定（自動生成）
	public int getId() {
		return id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}

}
