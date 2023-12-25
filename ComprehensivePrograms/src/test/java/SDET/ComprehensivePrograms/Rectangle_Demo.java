package SDET.ComprehensivePrograms;

public class Rectangle_Demo {

	float length, width, area, perimeter;

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}
	
	public void getArea() {
		area = length*width;
		System.out.println("Area is :"+area);
		
	}
	public void getPerimeter() {
		perimeter = 2*(length+width);
		System.out.println("Perimeter is :"+perimeter);
	}
	
	public static void main(String[] args) {
		
		Rectangle_Demo val = new Rectangle_Demo();
		val.setLength(3.5f);
		val.setWidth(2.5f);
		val.getArea();
		val.getPerimeter();
		
	}
}
