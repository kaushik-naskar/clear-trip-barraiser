package com.barraiser.cleartrip;

import com.barraiser.cleartrip.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CleartripApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(CleartripApplication.class, args);
    }



    private final CommandExecutor executor;

    private final Scanner scanner;



    public CleartripApplication(CommandExecutor executor) {
        this.executor = executor;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {

        while (true){
            System.out.print("\n>");
            String cmd = scanner.nextLine();
            executor.execute(cmd);
        }
    }
}
