/*
ID: sbanerjee13
PROGRAM: PASSWORDCHECK
DATE: 1/21/2019
README CHECK: Status/copyright message placeholder :)
 */

import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args){
        try {

            Scanner in = new Scanner(new File("passwords.txt"));
            Scanner sc = new Scanner(System.in);

            int n = in.nextInt();
            int counter = 0;
            in.nextLine();
            String[] passwords = new String[n];

            for(int i = 0; i < n; i++){
                passwords[i] = in.nextLine();
            }

            System.out.println("Enter a password from the passwords.txt list:");
            String password = sc.nextLine();
            String guess = passwords[0];
            String response;
            String conversion;
            char[] replace = new char[n];

            char[] pLetter = new char[n];

            for(int i = 0; i < n; i++){
                pLetter[i] = passwords[i].charAt(0);
            }

            while(!guess.equals(password)){
                System.out.println(question(pLetter[0]));
                response = sc.nextLine();
                if(response.equals("n")){

                    System.out.println("\n> Response Recorded < \n");
                    conversion = new String(pLetter);
                    replace = removeChar(conversion, pLetter[0]).toCharArray();

                    for(int i = 0; i < replace.length; i++){
                        pLetter[i] = replace[i];
                    }
                }

                if(response.equals("y")){
                    System.out.println(pLetter[0]);
                    for(int i = 0; i < passwords.length; i++){
                        if(pLetter[0] == passwords[i].charAt(0)){
                            guess = passwords[i];
                        }
                    }
                    //System.out.println(pLetter[0]);
                }

                counter++;
            }

            System.out.println("I think that your password is " + guess + "!");
            //System.out.println(question(i));


        }catch(IOException e){
            System.out.println("Error reading from scanner!");
        }
    }

    public static String question(char i){
        String result = ("Does the password start with the letter " + i + "?");

        return result;
    }

    public static String removeChar(String str, char c){
        int j, count = 0, n = str.length();
        String end = "";
        char []t = str.toCharArray();
        for (int i = j = 0; i < n; i++)
        {
            if (t[i] != c)
                t[j++] = t[i];
            else
                count++;
        }

        while(count > 0)
        {
            t[j++] = '\0';
            count--;
        }

        end = new String(t);

        return end;

        //removeResult = new String(t);
    }

}
