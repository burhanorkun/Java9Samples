/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processapitest;

import java.io.IOException;
import java.util.function.Consumer;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author TCBORKUN
 */
public class FındPidNo {

    /**
     * @param args the command line arguments
     */
    private static final int PID = 0;
    private static final int HOST = 1;
   
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            ProcessBuilder command = new ProcessBuilder().command("calc");
            Process process = command.start();
            Long pid = process.getPid();
            System.out.println("calc pid: "+ pid);
            
            System.err.println("Current PID: " + ProcessHandle.current().getPid());
            
            long numberOfProcesses = ProcessHandle.allProcesses().count();
            System.out.println("Number of processes: " + numberOfProcesses);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        

        
    }
    
}
