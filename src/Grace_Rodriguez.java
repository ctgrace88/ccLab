import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

public class Grace_Rodriguez {
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

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("Grace_Rodriguez.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        writer.println("\nThere are " + count + " track 1 records in the memory data\n");

        count = 0;
        while (matcher.find()){
            count++;
            writer.println("<Information in record " + count + ">");
            writer.println("Cardholder's Name: " + matcher.group("name"));
            writer.println("Card Number: " + matcher.group("number"));
            writer.println("Expiration Date: " + matcher.group("month") + "/20" + matcher.group("year"));
            writer.println("CVC Number: " + matcher.group("cvc") + '\n');
        }
        writer.close();
    }
}
