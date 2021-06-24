public class ClassName {

	private int amount;
	private String name;


	public ClassName() {
		constructAmount();
		constructName();
	}

	private void constructAmount() {
		this.amount = 0;
	}


	private void constructName() {
		this.name = "Name";
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
