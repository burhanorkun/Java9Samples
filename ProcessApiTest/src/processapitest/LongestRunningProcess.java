/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processapitest;

import java.time.format.DateTimeFormatter;
import java.lang.ProcessHandle.Info;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
/**
 *
 * @author TCBORKUN
 */
public class LongestRunningProcess {
    public static void main(String[] args) {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        Consumer<String> printUser = user -> {
            System.out.println("User: " + user);
        };
        Consumer<String> printCmd = cmd -> {
            System.out.println("Command: " + cmd);
        };
        Consumer<String> printCmdLine = cmdln -> {
            System.out.println("Command line: " + cmdln);
        };
        Consumer<String[]> printArgs = arguments -> {
            System.out.println("Arguments: " + Arrays.toString(arguments));
        };
        Consumer<Instant> printInstant = inst -> {
            System.out.println("Start time: " + formatter.format(inst));
        };
        Consumer<Duration> printCpu = duration -> {
            System.out.println("CPU time (millisec): " + duration.toMillis());
        };
        Consumer<Info> printInfo
                = info -> {
                    info.user().ifPresent(printUser);
                    info.command().ifPresent(printCmd);
                    info.commandLine().ifPresent(printCmdLine);
                    info.arguments().ifPresent(printArgs);
                    info.startInstant().ifPresent(printInstant);
                    info.totalCpuDuration().ifPresent(printCpu);
                    System.out.println();
                };        
        Instant now= Instant.now();
        Optional<Info> processInfo= 
                ProcessHandle.allProcesses()
                    .map( p -> p.info() )
                    .filter(info -> info.startInstant().isPresent())
                    .max( (p,q) -> q.startInstant().orElse(now)
                        .compareTo(p.startInstant().orElse(now)));
        processInfo.ifPresent(printInfo);
    }
}
