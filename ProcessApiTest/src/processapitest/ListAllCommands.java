/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processapitest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

/**
 *
 * @author TCBORKUN
 */
public class ListAllCommands {
    
    public static void main(String[] args) {
            Consumer<String> printCommand = command -> {
             Path path = Paths.get(command);
             System.out.println(path.getFileName());
        };

        ProcessHandle.allProcesses()
           .filter( p -> p.info().command().isPresent() )
           .map( p -> p.info().command().get() )
           .distinct()
           .sorted()
           .forEach(printCommand);
    }
    
}
