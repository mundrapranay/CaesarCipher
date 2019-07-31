package encryptdecrypt;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        int key = 0;
        String mode = "";
        String inputFile = "";
        String outputFile = "";
        for (int i = 0; i < args.length; i+=2) {
            String argumentType = args[i];
            if (argumentType.equals("-mode")) {
                mode = args[i+1];
            } else if (argumentType.equals("-key")) {
                key = Integer.parseInt(args[i+1]);
            } else if (argumentType.equals("-in")) {
                inputFile = args[i+1];
            } else if (argumentType.equals("-out")) {
                outputFile = args[i+1];
            }
        }
        PrintStream output = new PrintStream(new File(outputFile));
        helper(key,mode,inputFile,output);
    }

    private static void helper (int key, String mode, String inputFile, PrintStream output) throws FileNotFoundException{
        Scanner input = new Scanner(new File(inputFile));
        while (input.hasNext()) {
            String message = input.nextLine();
            if (mode.equals("enc")) {
                output.print(caesarCipher(message, key));
            } else if (mode.equals("dec")) {
                output.print(caesarCipher(message, -key));
            }
        }
    }
    private static String caesarCipher(String message, int key) {
        String enc = "";
        char ch;
        for (int i = 0; i < message.length(); i++) {
            ch = message.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + key);
                enc += ch;
            } else {
                ch = (char) (ch + key);
                enc += ch;
            }
        }
        return enc;
    }
}
