package Task.Task;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class Task {

	
	
	
	
	public static void print(FTPClient ftp, FTPFile[] dir) throws IOException{
		
		  for(FTPFile file: dir)
		  {
		   if(file.isDirectory())
		   {
		    System.out.println(file.getName());
		    ftp.changeWorkingDirectory(file.getName());
		    FTPFile[] ftpfiles_1 = ftp.listFiles();
		    print(ftp, ftpfiles_1);
		   }
		   else
		   {
		    System.out.println(file.getName());
		   }
		  }
		  ftp.changeToParentDirectory();
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws SocketException, IOException {
		
		
		
		String dir = "ftp.mozilla.org";
		 FTPClient client = new FTPClient();
	        client.connect(dir);
	        client.enterLocalPassiveMode();
	        client.login("anonymous", "");
	     
	        
	        FTPFile[] Dirs = client.listFiles("");
	        
	        print(client,Dirs);
	        
	     
	        
	           
	        
	        client.logout();
	        client.disconnect();
	        
	} 
	
}