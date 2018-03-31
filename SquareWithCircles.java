import java.awt.Color;
import java.awt.Graphics;

public class SquareWithCircles extends Shape {

	private int width;
	private int xTopLeft;
	private int yTopLeft;
	private int radius;

	public SquareWithCircles(Color color) {
		super(color);

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		// MainSquare
		g.drawRect(xTopLeft, yTopLeft, width, width);
		// LeftCircle
		g.fillOval(xTopLeft - radius / 2, yTopLeft + width / 6, radius, radius);
		// RightCircle
		g.fillOval(xTopLeft + radius, yTopLeft + width / 6, radius, radius);

	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setX(int x) {
		this.xTopLeft = x;
	}

	public void setY(int y) {
		this.yTopLeft = y;
	}

}
