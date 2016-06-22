package com.egfavre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by user on 6/22/16.
 */
@Controller
public class PurchaseListController {
    @Autowired
    PurchaseRepository purchases;

    @Autowired
    CustomerRepository customers;

    @PostConstruct
    public void init() throws FileNotFoundException {
        if (customers.count()==0){
            File f = new File("customers.csv");
            Scanner fileScanner = new Scanner(f);

            fileScanner.nextLine();
            while(fileScanner.hasNextLine()){
                String customerLine = fileScanner.nextLine();
                String [] columns = customerLine.split(",");
                String name = columns[0];
                String email = columns[1];

                Customer customer = new Customer(name, email);
                customers.save(customer);
            }
        }
        if (purchases.count()==0){
            File nextF = new File("purchases.csv");
            Scanner nextFileScanner = new Scanner(nextF);

            nextFileScanner.nextLine();
            while (nextFileScanner.hasNextLine()){
                String purchaseLine = nextFileScanner.nextLine();
                String [] purchaseFields = purchaseLine.split(",");
                int id = Integer.valueOf(purchaseFields[0]);
                Customer customer = customers.findById(id);
                String date = purchaseFields[1];
                String creditCard = purchaseFields[2];
                int cvv = Integer.valueOf(purchaseFields[3]);
                String category = purchaseFields[4];

                Purchase purchase = new Purchase(customer, date, creditCard, cvv, category);
                purchases.save(purchase);
            }
        }
    }

    @RequestMapping (path = "/", method = RequestMethod.GET)
    public String home (HttpSession session){
        return "home";
    }
}
