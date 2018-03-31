import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SlotMachineFrame extends JFrame implements ISlotMachine {

	private JButton button = new JButton("Play");
	private JLabel label = new JLabel("Click Play");
	private SlotMachinePanel panel = new SlotMachinePanel();

	public SlotMachineFrame(int w, int h) {

		this.setSize(w, h);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		button.setPreferredSize(new Dimension(w / 7, h));
		add(button, BorderLayout.WEST);
		ActionPlay play = new ActionPlay();
		button.addActionListener(play);

		label.setHorizontalAlignment(JLabel.CENTER);
		label.setPreferredSize(new Dimension(w, h / 30));
		add(label, BorderLayout.SOUTH);

		add(panel);

		this.setVisible(true);
	}

	class ActionPlay implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			play();
		}
	}

	@Override
	public void play() {
		panel.play();

		if (panel.getShapeAtIndex(0).equals(panel.getShapeAtIndex(1))
				&& panel.getShapeAtIndex(1).equals(panel.getShapeAtIndex(2))) {
			label.setText("YOU WON !!");
		} else {
			label.setText("YOU LOST !!");
		}
	}

	@Override
	public Shape getShapeAtIndex(int index) {
		return null;
	}

}
