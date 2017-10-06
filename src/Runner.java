import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Runner
 * @author SomeTechNoob
 */
public class Runner {
	public static void main(String[] args) {
		ArrayList<Module> modules = new ArrayList<>();
		
		File[] files = readResources();
		if (files == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Uh-oh, I can't find the /resources/ folder.  Make sure it is in the same directory as the program!");
		    System.exit(0);
		} else {
			for (File f : files) modules.add(new PictureModule(f));
			
			new ShopperFrame(modules);
		}
	}
	
	public static File[] readResources() {
		File folder = new File(new File("").getAbsolutePath() + "\\resources");
		File[] files = folder.listFiles();
		return files;
	}
}
