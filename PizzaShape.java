import java.awt.Color;
import java.awt.Graphics;

public class PizzaShape extends Shape {
	private int radius;
	private int x;
	private int y;

	private final static int CIRCLE_DEGREE = 360;
	private final static int ONE_SLICE = 35;
	private final static int ONE_SPACE = 10;

	public PizzaShape(Color color) {
		super(color);

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		for (int i = 0; i < CIRCLE_DEGREE; i += ONE_SLICE) {
			g.fillArc(x, y, radius * 2, radius * 2, i, ONE_SLICE);
			i += ONE_SPACE;
		}

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
