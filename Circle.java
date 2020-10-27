
public class Circle extends Shape {
	private float r;
	private final float PI = 3.14f;
	public Circle(float r) {
		this.r = r;
	}
	
	public double findArea() {
		return PI*r*r;
	}
	
	
}