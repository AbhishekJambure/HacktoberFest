
public class Triangle extends Shape {
	private int b, h;
	
	public Triangle(int b, int h) {
		this.b = b;
		this.h = h;
	}
	
	public double findArea() {
		return 0.5*b*h;
	}

}
