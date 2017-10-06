import java.awt.Container;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * PictureModule Class
 * @author SomeTechNoob
 */
public class PictureModule extends Module {
	private JLabel image;
	private JLabel label;
	
	/**
	 * Constructs a PictureModule
	 */
	public PictureModule(File f) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setName(f.getName().substring(0, f.getName().length() - 4));
		
		ImageIcon ico = new ImageIcon(new File("").getAbsolutePath() + "\\resources\\" + f.getName());
		this.image = new JLabel(ico);
		this.label = new JLabel(f.getName().substring(0, f.getName().length() - 4));
		
		Container input = new Container();
		
			input.setLayout(new BoxLayout(input, BoxLayout.X_AXIS));
			input.add(new JLabel("Qty: "));
			input.add(getTextField());
		
		add(label);
		add(image);
		add(input);
	}
}
