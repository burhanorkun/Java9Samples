/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamapitest;

import java.util.stream.Stream;

/**
 *
 * @author TCBORKUN
 */
public class IterateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Stream.iterate(1, i->i<=10 ,i -> 2 * i)
                .forEach(System.out::println);
        // output: 1 2 4 8 ...
        
        Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n  ->  n  + 1).limit(10);
        tenNaturalNumbers.forEach(System.out::print);
        
        /*
        Stream.iterate(2L, n  ->  n  + 1)
                .filter(IterateTest::isOdd)
                .limit(5)
                .forEach(System.out::print);

        Stream.iterate(2L, n  ->  n  + 1)
                .filter(IterateTest::isOdd)
                .skip(100)
                .limit(5)
                .forEach(System.out::print);
        */
        
        System.out.println();
    }
    
    public static boolean isOdd(long number) {
        if (number % 2 == 0) {
            return false;
        }
        return true;
    }
    
}
