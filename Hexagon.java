public class Hexagon extends Shape {
	private int a;
	
	public Hexagon(int a) {
		this.a = a;
	}
	
	@Override
	public double findArea() {
		return 2.598*a*a;
	}

}
