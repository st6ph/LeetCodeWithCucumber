package feature.fizzbuzz.bean;

public class FizzBuzzResultBean {

	private int index;
	
	private String value;
	
	public FizzBuzzResultBean(int index, String value) {
		super();
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
