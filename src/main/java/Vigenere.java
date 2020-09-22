import java.util.Scanner;
//work in progress - NOT SURE HOW TO PROCEED
public class Vigenere {
    char msg[] = //{characters of message}
	char key[] = //{characters of key}
    int msg_Length = msg.length;
	char newKey[] = char[msg_Length];
	char encrypted_message[] = char[msg_Length];
	char decrypted_message[] = char[msg_Length];
		
    public static String encryptVigenere(String message, String key) {
    for(i = 0; i < msg_Length; ++i){
		encrypted_message[i] = (char)(((msg[i] + newKey[i]) % 26) + 'A');
    }
    }

    public static String decryptVigenere(String message, String key) {
        for(i = 0; i < msg_Length; ++i){
			decrypted_message[i] = (char)((((decrypted_message[i] - newKey[i]) + 26) % 26) + 'A');
        }
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
