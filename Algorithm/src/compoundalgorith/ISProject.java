/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compoundalgorith;
import java.util.Scanner;
/**
 *
 * @author deema
 */
public class ISProject {

/*
Mathematically give each letter a number abcdefghijklmnopqrstuvwxyz
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
*/


//Return shift key
public static int getShiftKey(String key) 
{
int SK = key.charAt(0);
SK = SK - 65;
System.out.println("The shiftKey : " + SK); return SK;
}


//for print menu with options 
static void Menu() {
System.out.println("For Encrypt please Enter 1 :");
System.out.println("..............................");    
System.out.println("For decrypt please Enter 2 :"); 
System.out.println(".............................."); 
System.out.println("For cancel please Enter 3 :"); 
}

//Shift Key Encryption
public static String SKEncryption(String Ptext, int k)
 { 
    String result ="";
for (int i = 0; i < Ptext.length(); i++) {
char ch1 = (char) (((int) Ptext.charAt(i) +
k - 65) % 26 + 65); result+=ch1;
}
return result; 
 }

//Shift Key Decryption
public static String SKDecryption(String Ctext1, int k) 
{
String result="";
for (int i=0; i<Ctext1.length(); i++) {
char ch = (char)( ((((int) Ctext1.charAt(i) -k - 65) % 26)+26)%26 + 65);
 result+=ch; 
}
return result; 
}


//One Time Pad Encryption
public static String OTPEncryption(String Ctext2, final String k)
 { String res = "";
for (int i = 0, j = 0; i < Ctext2.length(); i++) { 
    char ch2 = Ctext2.charAt(i);
if (ch2 < 'A' || ch2 > 'Z')
continue;
res += (char) ((ch2 + k.charAt(j) - 2 * 'A') % 26 + 'A'); 
j = ++j % k.length();
}
return res; 
 }


//One Time Pad Decryption
public static String OTPDecryption(String text, final String k)
        {
String res = "";
text = text.toUpperCase();
for (int i = 0, j = 0; i < text.length(); i++) {
char c = text.charAt(i); if (c < 'A' || c > 'Z')
continue;
res += (char) ((c - k.charAt(j) + 26) % 26 + 'A'); j = ++j % k.length();
}
return res; 
        }


public static void main(String[] args) { 
   
Scanner input = new Scanner(System.in); 
String in;

int SK;

Menu(); //Return Menu method

while (!(in = input.nextLine()).equals("3"))
{ 
//Start conditional statment 
    if (in.equals("1")) {
System.out.println("Please enter the plaintext : "); 
String Ptext = input.nextLine();
Ptext = Ptext.toUpperCase(); 
System.out.println("Please enter the string key : ");
String mainKey = input.nextLine();
mainKey = mainKey.toUpperCase();

SK = getShiftKey(mainKey);
//Returning the cipher text
String Ctext2 = String.valueOf(SKEncryption(Ptext, SK));
System.out.println("The First Encryption Is : " + Ctext2);
String finalCiphertext =OTPEncryption(Ctext2, mainKey);
System.out.println("The Second Encryption Is : " + finalCiphertext);
} //Start else
    else if (in.equals("2")) { 
        
System.out.println("Please enter the ciphertext : "); 
String Ctext1 = input.nextLine(); 
Ctext1 = Ctext1.toUpperCase(); 
System.out.println("Please enter the string key : ");
String Key = input.nextLine();
Key = Key.toUpperCase();
SK = getShiftKey(Key);
String Ptext1 = OTPDecryption(Ctext1, Key); 
System.out.println("The First Decryption Is: " + Ptext1);
String finalPlaintext = SKDecryption(Ptext1, SK); 
System.out.println("The Second Decryption Is: " + finalPlaintext);
//End else
} //End conditional statment 
Menu(); 
}
}
}
