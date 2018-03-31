import java.awt.Color;

public abstract class Shape implements iDrawnShape {

	private Color color;

	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	@Override
	public boolean equals(Object o) {
		Shape shape = (Shape) o;

		if (shape.getClass().getName().equals(this.getClass().getName()) && shape.color.equals(this.color)) {
			return true;
		}

		return false;

	}
}
