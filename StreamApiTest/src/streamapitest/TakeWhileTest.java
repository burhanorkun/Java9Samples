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
public class TakeWhileTest {
    
    public static void main(String[] args) {
        
        Stream<Integer> stream = Stream.iterate(1, i-> i<=10, i -> i+1);
        stream.takeWhile(i -> i<=4)
                .forEach(System.out::println);
        
        Stream.of("T", "U", "R", "K", "C","E","L","L","","A","V","E","A")
                .takeWhile(s -> !s.isEmpty())
                .forEach(System.out::print);
        
    }
}
