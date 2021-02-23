package ibrahimcode.be;

import ibrahimcode.be.configuration.CustomersConfig;
import ibrahimcode.be.models.Admin;
import ibrahimcode.be.models.Customer;
import ibrahimcode.be.models.TransactionAccount;
import ibrahimcode.be.services.AdminService;
import ibrahimcode.be.services.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

@SpringBootApplication
public class BankApp {

    public static void main(String[] args) {

        try (ConfigurableApplicationContext applicationContext =
                     new AnnotationConfigApplicationContext(CustomersConfig.class)) {

            SpringApplication.run(BankApp.class, args); // run the springboot

            // here we can use SpringMVC @Beans
            AdminService adminServiceImpl = applicationContext.getBean("mockAdminService", AdminService.class);

            Admin admin = applicationContext.getBean("admin", Admin.class);
            admin.setName("ibrahimbow");
            admin.setUsername("bbg");
            admin.setPassword("bbg");

            adminServiceImpl.addAdmin(admin);

            System.out.println("username:" + admin.getUsername() + "\n" + "password:" + admin.getPassword());

            //================================== ADD Customers ==========================================

            CustomerService customerImpl = applicationContext.getBean("mockService", CustomerService.class);

            // Here  we make the objects of customer to be able to add the customer info
            Customer customer1 = applicationContext.getBean("customer", Customer.class);
            customer1.setName("ibrahim");
            customer1.setSurname("Alolofi");
            customer1.setBalance(2150);


            // we add only one object
            //customerImpl.addCustomer(customer1);

            Customer customer2 = applicationContext.getBean("customer", Customer.class);
            customer2.setName("Bart");
            customer2.setSurname("javaEE11");
            customer2.setBalance(1550);

            Customer customer3 = applicationContext.getBean("customer", Customer.class);
            customer3.setName("Kevin");
            customer3.setSurname("java11Dev");
            customer3.setBalance(1990);

            Customer customer4 = applicationContext.getBean("customer", Customer.class);
            customer4.setName("Sam");
            customer4.setSurname("java11EEDev");
            customer4.setBalance(1760);


            // create a list in order to add all the persons
            List<Customer> customerList = (List<Customer>) applicationContext.getBean("customerList");
            customerList.add(customer1);
            customerList.add(customer2);
            customerList.add(customer3);
            customerList.add(customer4);

            // Add a list of customers into list
            System.out.println("\n\n");
            customerImpl.addCustomers(customerList);

            //======================================================================================
            TransactionAccount transactionAccount = applicationContext.getBean("transactionAccount",TransactionAccount.class);

            int id = 2;
            int initialCredit = 100;

            if (customerImpl.getCustomer(id) != null) {
                if (initialCredit != 0) {
                    // open new current account
                    transactionAccount.setId(id);
                    transactionAccount.setInitialCredit(initialCredit);
                    transactionAccount.setTypeOfAccount("Current Account");
                    transactionAccount.setCardNumber(53215);

                    customerImpl.getCustomer(id).setTransactionAccount(transactionAccount);

                    // here we cut the money for customer account
                    double restMoney = (initialCredit - customerList.get(id).getBalance());
                    customerList.get(id).setBalance(restMoney);
                }else {
                    System.out.println("this initial credit is not not");
                }
            } else {
                System.out.println("this is null");
            }

            System.out.println(customerImpl.showAllCustomers());
            //======================================================================================

            //show one element from the list by Id
            System.out.println("the customer 2 : " + customerImpl.getCustomer(2));

            //print all elements in the list
            System.out.println(customerImpl.showAllCustomers());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


