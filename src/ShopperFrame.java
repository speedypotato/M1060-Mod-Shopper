import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Main Frame
 * @author SomeTechNoob
 */
public class ShopperFrame extends JFrame {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private ArrayList<Module> moduleList;
	private int rows, cols;
	
	/**
	 * Constructs a ShopperFrame
	 * @param moduleList List of Modules to add
	 */
	public ShopperFrame(ArrayList<Module> moduleList) {
		setTitle("SomeTechNoob's M1060 Mod Shopper");
		this.moduleList = new ArrayList<>();
		
		Container mContainer = new Container();
		
			this.cols = (int)Math.ceil(Math.sqrt(moduleList.size() + 1));
			this.rows = cols;
			mContainer.setLayout(new GridLayout(rows, cols));
			
			for (Module m : moduleList) {
				m.setBorder(BorderFactory.createLineBorder(Color.black));
				this.moduleList.add(m);
				mContainer.add(m);
			}
					
			JButton done = new JButton("EXPORT");
			done.addActionListener((al) -> export());
			mContainer.add(done);
			
		add(new JScrollPane(mContainer));
		setPreferredSize(new Dimension(1280, 1100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/**
	 * Export func
	 */
	private void export() {
		String list = "";
		for (Module m : moduleList) {
			if (!m.getTextField().getText().equals("") && m.getTextField().getText() != null) {
				try {
					if (Integer.parseInt(m.getTextField().getText()) != 0)
						list += Integer.parseInt(m.getTextField().getText()) + "x " + m.getName() + "\n";
				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(), "Uh-oh, " + m.getName() + "'s qty box has something odd in it.");
					return;
				}
			}
		}
		if (list.length() < 1) {
			JOptionPane.showMessageDialog(new JFrame(), "Uh-oh, you haven't added any M1060 mods.");
			return;
		}
		new ExportFrame(list);
	}
	
	public class ExportFrame extends JFrame {
		public ExportFrame(String s) {
			s += "Zip Code: ";
			setTitle("COPY & PASTE & PM TO SOMETECHNOOB");
			JTextArea jta = new JTextArea(s);
			jta.setEditable(false);
			add(jta);
			pack();
			setLocationRelativeTo(null);
			setMinimumSize(new Dimension(425, 200));
			setVisible(true);

			JOptionPane.showMessageDialog(new JFrame(), "Send a PM to SomeTechNoob with this copied and pasted.  Don't forget to enter your zip code for a shipping estimate!");
		}
	}
}
