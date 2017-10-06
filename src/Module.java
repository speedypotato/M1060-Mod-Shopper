import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * Module SuperClass
 * @author SomeTechNoob
 */
public class Module extends JComponent {
	private JTextField tf;
	
	/**
	 * Constructs a basic Module initialized to 0
	 */
	public Module() {
		this.tf = new JTextField();
		this.tf.setText("0");
	}
	
	/**
	 * Constructs a Module
	 * @param s Starting string for JTextField
	 */
	public Module(String s) {
		this.tf = new JTextField();
		this.tf.setText(s);
	}
	
	/**
	 * Gets data from JTextField
	 * @return String from JTextField
	 */
	public String getText() {
		return tf.getText();
	}
	
	/**
	 * Returns the JTextField
	 * @return jtextfield
	 */
	public JTextField getTextField() {
		return tf;
	}
}
