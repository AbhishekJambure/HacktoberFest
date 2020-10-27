
public class Rectanlge extends Shape {

	private int l, b;
	
	public Rectanlge(int l, int b) {
		this.l = l;
		this.b = b;
	}
	@Override
	public double findArea() {
		// TODO Auto-generated method stub
		return l*b;
	}

}
