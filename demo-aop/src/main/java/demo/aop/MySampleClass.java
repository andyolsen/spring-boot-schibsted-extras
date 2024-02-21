package demo.aop;

public class MySampleClass implements MySampleInterface {

	private String a;
	private int b;
	
	public void setMessage(String a) {
		this.a = a;
	}
	
	public void setNumber(int b) {
		this.b = b;
	}
	
	public void display() {
		System.out.printf("a=%s, b=%d\n", a, b);
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}
