package kim.eren.oca_8_certificate.lambda.mmullerbook.entity;

public class Item {

	private int articleNo;
	private int quantity;
	private int amount;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int articleNo, int quantity, int amount) {
		super();
		this.articleNo = articleNo;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
