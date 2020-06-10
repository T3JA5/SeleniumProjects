package reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReportCreation {

	public static void copyFolder(File src, File dest)
			throws IOException{

		if(src.isDirectory()){
			//if directory not exists, create it
			if(!dest.exists()){
				dest.mkdir();
				System.out.println("Files copied from "+ src + " to " + dest);
			}
			//list all the directory contents
			String files[] = src.list();

			for (String file : files)
			{
				// file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				copyFolder(srcFile,destFile);
			}

		}else
		{
			// copy the files
			@SuppressWarnings("resource")
			InputStream in = new FileInputStream(src);
			@SuppressWarnings("resource")
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			//copy the file content in bytes
			while ((length = in.read(buffer)) > 0){
				out.write(buffer, 0, length);
			}
		}

	}
}
