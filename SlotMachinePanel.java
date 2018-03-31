import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SlotMachinePanel extends JPanel implements ISlotMachine {

	private final static double SLOT_MACHINE_WIDTH_FRACTION = 0.8;
	private final static int RADIUS_DIVISOR = 6;
	private final static double SLOT_MACHINE_HEIGHT_DIVISOR = 1.4;
	private final static double RATIO = 2.6;
	private final int NUM_OF_SLOTS = 3;
	
	private Square mainMachineCell = new Square(Color.black);
	private Square rightCell = new Square(Color.black);
	private Square leftCell = new Square(Color.black);
	private Square midCell = new Square(Color.black);

	private Shape shape1;
	private Shape shape2;
	private Shape shape3;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int panelWidth = getWidth();
		int panelHeight = getHeight();

		// get the shortest length when resized
		int minPanelLength = Math.min(panelWidth, panelHeight);

		double slotMachineWidth = minPanelLength * SLOT_MACHINE_WIDTH_FRACTION;

		int xCenter = panelWidth / 2;
		int yCenter = panelHeight / 2;

		// set the squares for the slot machine skeleton
		setSquares((int) slotMachineWidth, xCenter, yCenter);

		g.setColor(Color.black);

		mainMachineCell.draw(g);
		leftCell.draw(g);
		rightCell.draw(g);
		midCell.draw(g);

		// drawing shapes
		
		try {
			
			shape1.draw(g);
			
			shape2.draw(g);
			
			shape3.draw(g);
			
			
			setShape(shape1, leftCell);
			setShape(shape2, midCell);
			setShape(shape3, rightCell);
			
			
				
		} catch (NullPointerException e) {

		}
		repaint();
	}

	private void setSquares(int slotMachinLength, int xCenter, int yCenter) {

		mainMachineCell.setWidth(slotMachinLength);
		mainMachineCell.setTopLeftX(xCenter - (slotMachinLength / 2));
		int mainBottomY = yCenter - slotMachinLength / 2;
		mainMachineCell.setTopLeftY((int) (mainBottomY / SLOT_MACHINE_HEIGHT_DIVISOR));

		// left cell
		int leftCellX = (int) (xCenter - slotMachinLength / RATIO);
		int CellY = (int) (yCenter - slotMachinLength / RATIO);

		leftCell.setWidth((int) (mainMachineCell.getWidth() / (RATIO * 2)));
		leftCell.setTopLeftX(leftCellX);
		leftCell.setTopLeftY((int) (CellY / SLOT_MACHINE_HEIGHT_DIVISOR));

		// mid cell
		int midCellX = (int) (xCenter - slotMachinLength / (RATIO * 4));

		midCell.setWidth((int) (mainMachineCell.getWidth() / (RATIO * 2)));
		midCell.setTopLeftX(midCellX);
		midCell.setTopLeftY((int) (CellY / SLOT_MACHINE_HEIGHT_DIVISOR));

		// right cell
		int rightCellX = (int) (xCenter + slotMachinLength / (RATIO * 2));

		rightCell.setWidth((int) (mainMachineCell.getWidth() / (RATIO * 2)));
		rightCell.setTopLeftX(rightCellX);
		rightCell.setTopLeftY((int) (CellY / SLOT_MACHINE_HEIGHT_DIVISOR));

	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	public Shape createShape(int index, Square cell) {

		switch (index) {
		case 0:
			FilledCircle fc = new FilledCircle(Color.RED);
			setFilledCircle(fc, cell);
			return fc;

		case 1:
			SquareWithCircles swc = new SquareWithCircles(Color.BLACK);
			setSquareWithCircles(swc, cell);
			return swc;

		case 2:
			PizzaShape ps = new PizzaShape(Color.orange);
			setPizza(ps, cell);
			return ps;

		}

		return null;

	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	private void setFilledCircle(FilledCircle fc, Square cell) {
		int radius = cell.getWidth() / RADIUS_DIVISOR;
		fc.setRadius(radius);
		fc.setX(cell.getCenterX() - radius);
		fc.setY(cell.getCenterY() - radius);
	}

	/**
	 * sets a PizzaShape size to fit the center of a cell
	 */
	private void setPizza(PizzaShape ps, Square cell) {
		int radius = cell.getWidth() / RADIUS_DIVISOR;
		ps.setRadius(radius);
		ps.setX(cell.getCenterX() - radius);
		ps.setY(cell.getCenterY() - radius);
	}

	/**
	 * sets a SquareWithCircles size to fit the center of a cell
	 */
	private void setSquareWithCircles(SquareWithCircles swc, Square cell) {
		int radius = cell.getWidth() / RADIUS_DIVISOR;
		int width = cell.getWidth() / 4;
		swc.setRadius(radius);
		swc.setWidth(width);
		swc.setX(cell.getCenterX() - width / 2);
		swc.setY(cell.getCenterY() - width / 2);
	}
	
	/**
	 * sets a Shape 
	 */
	public void setShape(Shape shape, Square cell){
		if(shape.getClass() == FilledCircle.class)
			setFilledCircle((FilledCircle) shape, cell);
		if(shape.getClass() == SquareWithCircles.class)
			setSquareWithCircles( (SquareWithCircles) shape, cell);
		if(shape.getClass() == PizzaShape.class)
			setPizza((PizzaShape) shape, cell);
	}
	/**
	 * action "play" Button
	 */
	public void play() {
		
		// creating random number
		Random r = new Random();
		int n = r.nextInt(NUM_OF_SLOTS);
		
		shape1 = createShape(n, leftCell);
		n = r.nextInt(NUM_OF_SLOTS);
		shape2 = createShape(n, midCell);
		n = r.nextInt(NUM_OF_SLOTS);
		shape3 = createShape(n, rightCell);
	}
	
	/**
	 * gets a Shape 
	 */
	public Shape getShapeAtIndex(int index) {
		if(index == 0){
			return shape1;
		}
		if(index == 1){
			return shape2;
		}
		if(index == 2){
			return shape3;
		}
		return null;
	}
	
	}

	
