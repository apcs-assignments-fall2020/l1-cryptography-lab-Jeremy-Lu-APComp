import java.util.Scanner;

public class Caesar {
    public static char toEncrypt (char ch) {
        char n = ch;
        if (n >= 'A' && n <= 'z'){
        n = (char) (n + 3); //by a factor of 3
        }
        return n;
}
    public static char toDecrypt (char ch) {
        char n = ch;
        if (n >= 'A' && n <= 'z'){
        n = (char) (n - 3); //by a factor of 3
        }
        return n;
}
    public static String encryptCaesar(String message) {
        String encrypt_message = message;
        String new_string = "";
        for(int counter = 0; counter<encrypt_message.length(); counter++){
            new_string += toEncrypt(encrypt_message.charAt(counter));
        }
        return new_string;
    }

    public static String decryptCaesar(String message) {
        String encrypt_message = message;
        String new_string = "";
        for(int counter = 0; counter<encrypt_message.length(); counter++){
            new_string += toDecrypt(encrypt_message.charAt(counter));
        }
        return new_string;
    }
    public static String decryptCaesarKey(String message, int key){
        String new_string = "";
        key = key%26;
        for (int i =0; i < message.length(); i++){
            char ch = message.charAt(i);
            if((ch >= 65 && ch <= 65 + (key-1))||(ch >= 97 && ch <= 97 +  (key-1))){
                new_string += (char)(ch+(26-key));
            }
            else{
                new_string += (char)(ch-key);
            }
        }
        return new_string;
    }
    public static String encryptCaesarKey(String message, int key){
        String new_string = "";
        key = key%26;
        for (int i =0; i < message.length(); i++){
            char ch = message.charAt(i);
            if((ch >= 65 && ch <= 65 + (key+1))||(ch >= 97 && ch <= 97 +  (key+1))){
                new_string += (char)(ch+(26+key));
            }
            else{
                new_string += (char)(ch-key);
            }
        }
        return new_string;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Key: ");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
            System.out.println(encryptCaesarKey(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Key: ");
            int key = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
            System.out.println(encryptCaesarKey(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
