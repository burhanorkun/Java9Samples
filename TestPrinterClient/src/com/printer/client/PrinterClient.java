/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.printer.client;

import com.printer.Printer;
import com.printer.util.Util;

/**
 *
 * @author TCBORKUN
 */
public class PrinterClient {
    
    public static void main(String[] args){
        Printer printer = new Printer();
        printer.print("DB ye gönder");
        printer.print("DB ye gönderildi");
        
        new Util().yazdir("Util icindeyiz");
    }
}
