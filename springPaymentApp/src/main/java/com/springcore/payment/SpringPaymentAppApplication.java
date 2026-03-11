package com.springcore.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import java.util.*;

//import com.springcore.demo.SpringAppApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringPaymentAppApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(SpringPaymentAppApplication.class, args);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        Payment payment = context.getBean(Payment.class);
        payment.paymentMethod(amount);
    }
}
