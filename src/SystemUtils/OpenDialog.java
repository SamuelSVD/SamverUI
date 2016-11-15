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
			this.addChoosableFileFilter(new Filter(extensions[i], descriptions[i]));
		}
	}

	public class Filter extends FileFilter {
		private String extension, description;
		public Filter(String extension, String description) {
			this.extension = extension;
			this.description = description;
		}
		@Override
		public boolean accept(File arg0) {			
			return arg0.isDirectory() || arg0.getName().endsWith(extension);
		}

		@Override
		public String getDescription() {
			return description;
		}
		
	}
}

