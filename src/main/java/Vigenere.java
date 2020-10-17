import java.util.Scanner;
//work in progress - NOT SURE HOW TO PROCEED
public class Vigenere {

    public static String decryptVigenere(String message, String key)
    {
        String encrypt_message = message;
        String new_string = "";
        int key_index = 0;
        for(int counter = 0; counter<encrypt_message.length(); counter++){
            char n = encrypt_message.charAt(counter);
            if (n >= 'A' && n <= 'z'){
                int x = (n - key.charAt(key_index) + 26 ) % 26;
                x += 'A';
                key_index++;
                if(key_index >= key.length()){
                    key_index = 0;
                }
                new_string += (char) (x);
            } else{
                new_string += n;
            }
        }
        return new_string;
    }
    public static String encryptVigenere(String message, String key) {
        String encrypt_message = message;
        String new_string = "";
        int key_index = 0;
        for(int counter = 0; counter<encrypt_message.length(); counter++){
            char n = encrypt_message.charAt(counter);
            if (n >= 'A' && n <= 'z'){
                int x = (n + key.charAt(key_index)) % 26;
                x += 'A';
                key_index++;
                if(key_index >= key.length()){
                    key_index = 0;
                }
                new_string += (char) (x);
            } else{
                new_string += n;
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
             System.out.println("Please enter the key for your message: ");
             String key = scan.nextLine().trim().toUpperCase();
             System.out.println("Here is your encrypted message: ");
             System.out.println(encryptVigenere(message, key));
         }
         else if (command.equals("decrypt")) {
             System.out.println("Please enter your message to be decrypted: ");
             String message = scan.nextLine();
             System.out.println("Please enter the key for your message: ");
             String key = scan.nextLine().trim().toUpperCase();
             System.out.println("Here is your decrypted message: ");
             System.out.println(decryptVigenere(message, key));
         }
        else {
             System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
         }

        scan.close();
    }
}
