package SystemUtils;

import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import java.io.File;
import java.io.FilenameFilter;

public class OpenDialog extends JFileChooser {
	
	public OpenDialog() {
		super();
	}
	public OpenDialog(String s) {
		super(s);
	}
	
	public void SetFilter(String[] extensions, String[] descriptions) {
		for (int i = 0; i < extensions.length; i++) {
			this.addChoosableFileFilter(new FileFilter(){
	      @Override
	      public boolean accept(File f) {
	      	if (f.getName().toLowerCase().endsWith(extensions[i])) {
	      	  System.out.println("Returning true");
	      	return true;
	      	}
	      	return false;
	      }
			});
		}
	}
}
