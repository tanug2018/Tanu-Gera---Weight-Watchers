import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Question1 {

	public static void main(String[] args) {
		 	String wrongPath = "/src/Non-existing.txt";
	        String path = "src/Dictionary.txt";
	        System.out.println("- - Checking File Existence - -");
	        doesFileExist(path);
	      //  filePrinter(wrongPath); // throws exception
	        filePrinter(path);
	    }

	    public static void filePrinter(String filePath){
	        Path path = Paths.get(filePath);
	        String data = null;
	        String[] str;
	        try {
	            byte[] fileBytes = Files.readAllBytes(path);
	            data = new String(fileBytes);

	            str = data.split("( – )|, |\\n");
	            System.out.println("---- Printing File in desired format ---- ");
	            for(String s : str)
	                System.out.println(s);
	        } catch (IOException e) {
	            System.out.println("Invalid File Path or File Missing exception: "+ e);
	        }

	    }


	    public static void doesFileExist(String filePath) {
	        Path path = Paths.get(filePath);
	        boolean exist = Files.exists(path) & Files.isRegularFile(path);
	        if (exist) {
	            System.out.println("File exist at path - " + filePath);
	        } else {
	            System.out.println("File doesn't exists at path ---- " + filePath);
	        }
	    }

	

	}


