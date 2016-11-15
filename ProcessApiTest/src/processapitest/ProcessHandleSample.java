/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processapitest;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author TCBORKUN
 */
public class ProcessHandleSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //ProcessHandle.Info info = ProcessHandle.info();
        try {
            ProcessBuilder command = new ProcessBuilder().command("calc");
            Process process = command.start();
            Long pid = process.getPid();
            System.out.println("calc pid: "+ pid); 
            
            
            //handle method-1
            ProcessHandle handle1 = process.toHandle();
            ProcessHandle.Info info1 = handle1.info();
            
            Optional<String> command1 = info1.command();
            command1.ifPresent(System.out::println);
            Optional<String[]> arguments = info1.arguments();
            arguments.ifPresent(System.out::println);
            Optional<Instant> startInstant = info1.startInstant();
            startInstant.ifPresent((a)->{System.out.println("Start Instant : "+a); });
            Optional<Duration> totalCpuDuration = info1.totalCpuDuration();
            totalCpuDuration.ifPresent((a)->{System.out.println("Total Duration(milis) : "+a.toMillis()); });
            Optional<String> user = info1.user();
            user.ifPresent(System.out::println);
            
            //handle method-2
            /*  
            ProcessHandle handle2 = ProcessHandle.current();
            Long pid2 = ProcessHandle.current().getPid();
            ProcessHandle.Info info2 = handle2.info();
            Optional<String> command2 = info2.command();
            command2.ifPresent(System.out::println);
            System.out.println("PID2 : "+ pid2);
            */
            
            //handle method-3
            /*
            Optional<ProcessHandle> handle3 = ProcessHandle.of(11616);
            ProcessHandle.Info info3;
            info3 = handle3.get().info();
            Optional<String> command3 = info3.command();
            command3.ifPresent((a)-> {System.out.println("ProcessHandle.of(?) command :"+a);} );
            */
            
            //handle method-4
            //Stream<ProcessHandle> handle4 = ProcessHandle.allProcesses();
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
