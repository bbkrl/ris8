package org.example;

import org.example.service.StringService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StringService service = context.getBean("stringBean", StringService.class);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter substring: ");
        String substr = scanner.nextLine();
        System.out.println(service.findSubstr(substr));

        context.close();
    }
}
