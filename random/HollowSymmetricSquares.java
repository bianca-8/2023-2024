package random;

import java.awt.*;
import javax.swing.JFrame;

public class HollowSymmetricSquares extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hollow Symmetric Squares");
		Canvas canvas = new HollowSymmetricSquares();
		canvas.setSize(500,500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		final int canX = 500;
		final int canY = 500;
		final double sp = 5;
		int sq = 3;
		int len = 8;
		int x = 10;
		int y = 10;
		int w = 10;
		int sum = 0;

		g.setColor(Color.BLACK);
		this.setBackground(Color.BLACK);

		for (int j = 0; j < sq; j++) {
			// top
			for (int i = 0; i < len; i++) {
				g.setColor(Color.RED);
				g.fillOval((int) (x + i * sp * w), y, w, w);
				sum += 1;
			}

			// bottom
			for (int i = 0; i < len; i++) {
				g.setColor(Color.GREEN);
				g.fillOval((int) (x + i * sp * w), (int) (y + sp * w * len - sp * w), w, w);
				sum += 1;
			}

			// left
			for (int i = 0; i < len; i++) {
				g.setColor(Color.BLUE);
				g.fillOval(x, (int) (y + i * sp * w), w, w);
				sum += 1;
			}

			// right
			for (int i = 0; i < len; i++) {
				g.setColor(Color.YELLOW);
				g.fillOval((int) (x + sp * w * len - sp * w), (int) (y + i * sp * w), w, w);
				sum += 1;
			}

			x += w * sp;
			y += w * sp;
			len -= 2;

		}
		sum -= sq * 4;
		System.out.println(sum);
	}

}