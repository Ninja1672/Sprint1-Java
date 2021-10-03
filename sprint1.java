import java.io.*;
import java.util.*;


public class sprint1 {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("This application is to store inventory like data to a file");
        System.out.println("Please provide the File name to create or open: ");
        String fileName = sc.nextLine();
        System.out.println("Attempting to create file name: " + fileName);
        // Try for Creating a file if it doesn't yet exist
        try {
            File test = new File(fileName);
            if (test.createNewFile()){
                System.out.println("File created " + test.getName());
            }
            else {
                System.out.println("That file already exists, opening...\n");
            }
        }
        catch (IOException error){
            System.out.println("An error occured while creating file");
            error.printStackTrace();
        }
        // Try for writing

        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            BufferedWriter buffer = new BufferedWriter(myWriter);
            boolean cont = true;
            
        while (cont) {
            System.out.println("Name of Game: ");
            String gameName = sc.nextLine();
            System.out.println("Platform it is located on: ");
            String platform = sc.nextLine();
            System.out.println("Rating you give to game 1-10: ");
            Integer rating = sc.nextInt();
            buffer.write( gameName + ": " + "is playable on " + platform + " and you rate it a " + rating + " out of 10" + '\n');
            System.out.println("Saved!");
            System.out.println("Would you like to add another game to this list? y/n");
            char answer = sc.next().charAt(0);
            sc.nextLine();
            if (answer != 'y') {
                cont = false;
            }
            buffer.flush();
        }
        buffer.close();
        }
        catch (IOException error){
            System.out.println("An error occured while writing");
            error.printStackTrace();
        }
        
        sc.close();
        System.out.println("Closing Application, Check for " + fileName + " in the same folder as this program.");
        
    }
}
