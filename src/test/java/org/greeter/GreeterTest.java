package org.greeter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class GreeterTest {
    private static Greeter greeter;
    private static String alice;
    private static String alex;
    private static String zero;
    private static String five;
    private static String six;
    private static String eleven;
    private static String twelve;
    private static String eighteen;
    private static String seventeen;
    private static String twentyOne;


    @BeforeAll
    public static void init(){
        greeter = new Greeter();
        alex = greeter.returnName("alex");
        alice = greeter.returnName("alice");
        zero = greeter.getTimeOfDay(0);
        five = greeter.getTimeOfDay(5);
        six = greeter.getTimeOfDay(6);
        eleven = greeter.getTimeOfDay(11);
        twelve = greeter.getTimeOfDay(12);
        seventeen = greeter.getTimeOfDay(17);
        eighteen = greeter.getTimeOfDay(18);
        twentyOne = greeter.getTimeOfDay(21);
    }


    @Test
    public void greetShouldReturnHelloWithName() {
        String helloAlice = twelve + alice;
        String helloAlex = seventeen + alex;

        assertEquals("Hello Alice", helloAlice);
        assertEquals("Hello Alex", helloAlex);
    }

    @Test
    public void greetWithEmptyName() {
        String empty = greeter.returnName("");
        String space = greeter.returnName(" ");

        assertEquals("Invalid name with digit or special symbol.", greeter.greet(empty));
        assertEquals("Invalid name with digit or special symbol.", greeter.greet(space));
    }

    @Test
    public void greetShouldTrimInput() {
        alice = greeter.returnName("   alice");
        String helloAlice = twelve + alice;

        alex = greeter.returnName("alex   ");
        String helloAlex = seventeen + alex;

        assertEquals("Hello Alice", helloAlice);
        assertEquals("Hello Alex", helloAlex);
    }

    @Test
    public void greetShouldCapitalizeFirstLetter() {
        alice = greeter.returnName("aLICE");
        String helloAlice = twelve + alice;

        alex = greeter.returnName("ALEX");
        String helloAlex = seventeen + alex;

        String jack = greeter.returnName("JaCK");
        String helloJack = twelve + jack;

        assertEquals("Hello ALICE", helloAlice);
        assertEquals("Hello ALEX", helloAlex);
        assertEquals("Hello JaCK", helloJack);
    }

    @Test
    public void greetShouldReturnGoodMorningBetween6And12() {
        String aliceMorning = six + alice;
        String alexMorning = eleven + alex;

        assertEquals("Good morning Alice", aliceMorning);
        assertEquals("Good morning Alex", alexMorning);
    }

    @Test
    public void greetShouldReturnGoodEveningBetween18And22() {
        String aliceEvening = eighteen + alice;
        String alexEvening = twentyOne + alex;

        assertEquals("Good evening Alice", aliceEvening);
        assertEquals("Good evening Alex", alexEvening);
    }

    @Test
    public void greetShouldReturnGoodNightBetween22And6() {
        String aliceNight = zero + alice;
        String alexNight = five + alex;

        assertEquals("Good night Alice", aliceNight);
        assertEquals("Good night Alex", alexNight);
    }

    @Test
    public void givenDigitInName_thenThrowException(){
        String nameError = greeter.returnName("tom1");
        assertEquals("Invalid name with digit or special symbol.", nameError);

        String symbolError = greeter.returnName("tom!");
        assertEquals("Invalid name with digit or special symbol.", symbolError);
    }

    @Test
    public void trimName() {
        alice = greeter.returnName(" alice ");
        String aliceNight = zero + alice;

        alex = greeter.returnName("alex  ");
        String alexNight = zero + alex;

        String neymarJr = greeter.returnName("   neymar jr");
        String neymarJrNight = zero + neymarJr;

        assertEquals("Good night Alice", aliceNight);
        assertEquals("Good night Alex", alexNight);
        assertEquals("Good night Neymar jr", neymarJrNight);
    }

}
