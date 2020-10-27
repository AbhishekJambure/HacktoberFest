import java.util.Scanner;

public class TestShape {
	
	public static void display(Shape arr[]) {
		for(Shape s : arr) {
			if(s instanceof Circle) {
				System.out.println("Area of Circle :- "+s.findArea());
			}
			else if(s instanceof Triangle) {
				System.out.println("Area of Triangle :- "+s.findArea());
			}
			else if(s instanceof Hexagon) {
				System.out.println("Area of Hexagon :- "+s.findArea());
			}
			else if(s instanceof Rectanlge) {
				System.out.println("Area of Rectangle :- "+s.findArea());
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter no. of shapes : ");
		int sizeOfShape = scanner.nextInt();
		Shape s[] = new Shape[sizeOfShape];
		
		System.out.println("Enter circle radius : ");
		float radius = scanner.nextFloat();
		s[0] = new Circle(radius);
		
		System.out.println("Enter triangle height and base : ");
		int height = scanner.nextInt();
		int base = scanner.nextInt();
		s[1] = new Triangle(height, base);
		
		System.out.println("Enter hexagon side : ");
		int side = scanner.nextInt();
		s[2] = new Hexagon(side);
		
		System.out.println("Enter rectangle length and breadth : ");
		int length = scanner.nextInt();
		int breadth = scanner.nextInt();
		s[3] = new Rectanlge(length, breadth);
		
		display(s);
		
		scanner.close();
	}
}