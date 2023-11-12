package othersFunctions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FunctionsFiles {
	public static void writeInFile(String fileName, List<?> object)
	{
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(object);
			os.flush();
			os.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	  
	

	
	public static void readFromFile(String fileName)
	{
		try {
		
			ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(fileName)));
		 List<?> list= (List<?>)ois.readObject();
		 list.forEach(System.out::println);
		ois.close();
		}
		
		catch (IOException | ClassNotFoundException e) {		
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
}
