package test;

import java.io.Serializable;

public class rectangle implements Serializable{
	double height,width;
	public rectangle(double height,double width) {
		this.height=height;
		this.width=width;
						
	}
	public double area() {
		return height*width;
	}
	public double perimeter() {
		return 2*(height+width);
	}
}
