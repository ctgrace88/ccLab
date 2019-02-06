import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

public class Driver {
    public static void main(String[] args){

        File dump = new File("memorydump.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(dump);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        scan.useDelimiter("\\Z");
        String contents = scan.next();

        Pattern pattern = Pattern.compile("%[A-Z]" + "(?<number>\\d{1,19})" + "\\^" + "(?<name>.{2,26})"
                                       + "\\^" + "(?<year>\\d\\d)" + "(?<month>\\d\\d)" + "(?<cvc>\\d\\d\\d)"
                                       + "\\d*\\?");

        Matcher matcher = pattern.matcher(contents);
        int count = 0;
        while (matcher.find()){
            count++;
        }

        matcher = pattern.matcher(contents);

        System.out.println("\nThere are " + count + " track 1 records in the memory data\n");

        count = 0;
        while (matcher.find()){
            count++;
            System.out.println("<Information in record " + count + ">");
            System.out.println("Cardholder's Name: " + matcher.group("name"));
            System.out.println("Card Number: " + matcher.group("number"));
            System.out.println("Expiration Date: " + matcher.group("month") + "/20" + matcher.group("year"));
            System.out.println("CVC Number: " + matcher.group("cvc") + '\n');
        }
    }
}
