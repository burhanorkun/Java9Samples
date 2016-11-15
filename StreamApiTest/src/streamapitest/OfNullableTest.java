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
public class OfNullableTest {
    
    public static void main(String[] args) {
        
        long test = Stream.of(1,2,3,4,5,6,null,8).count();
        System.out.println("test:"+test); //8 

        //long test = Stream.of(null).count();    //error
        //System.out.println("test:"+test); //8   

        
        long one = Stream.ofNullable("42").count();
        long zero = Stream.ofNullable(null).count();

        System.out.println("one:"+one); //1
        System.out.println("zero:"+zero);  //0
    }
}

