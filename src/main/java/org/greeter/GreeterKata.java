package org.greeter;

import java.time.LocalTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class GreeterKata
{
    public static void main( String[] args )
    {
        Greeter greeter = new Greeter();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.next();
            if("exit".equalsIgnoreCase(input)){
                System.out.println("GoodBye!!");
                System.exit(0);
            } else {
                System.out.println(greeter.greet(input));
            }

        }
    }
}
