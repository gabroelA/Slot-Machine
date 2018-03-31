import java.awt.Color;
import java.awt.Graphics;

public class FilledCircle extends Shape {

	private int radius;
	private int x;
	private int y;

	public FilledCircle(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(getColor());
		g.fillOval(x, y, radius * 2, radius * 2);

	}

	public void setRadius(int radius) {
		this.radius = radius;

	}

	public void setX(int x) {
		this.x = x;

	}

	public void setY(int y) {
		this.y = y;

	}

}
