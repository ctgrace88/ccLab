import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args){

        File dump = new File("memorydump.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(dump);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String contents = scan.next();
        System.out.println(contents);

    }
}
// %[A-Z]\d{1,19}\^(\w*\/*\w*)\^\w*\?
