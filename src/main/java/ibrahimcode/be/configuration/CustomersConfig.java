package ibrahimcode.be.configuration;

import ibrahimcode.be.data.implementation.AdminDaoImpl;
import ibrahimcode.be.data.implementation.CustomerDaoImpl;
import ibrahimcode.be.models.Admin;
import ibrahimcode.be.models.Customer;
import ibrahimcode.be.models.TransactionAccount;
import ibrahimcode.be.services.implementation.AdminServiceImpl;
import ibrahimcode.be.services.implementation.CustomerServiceImpl;
import org.springframework.context.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
public class CustomersConfig {


    static int id = 0;

    @Bean
    @Scope("prototype")  //  not only for only single instant run
    public Customer customer(){
        id++;
        return new Customer(id);
    }

    @Bean
    @Scope("prototype")
    public TransactionAccount transactionAccount(){
        return new TransactionAccount();
    }


    @Bean
    @Scope("prototype")
    public Admin admin(){
        return new Admin();
    }



    @Bean
    public List<Customer> customerList(){
        return new ArrayList<>();
    }



    @Bean
    public CustomerDaoImpl mockDao(){
        return new CustomerDaoImpl();
    }

    @Bean
    public CustomerServiceImpl mockService(){
        return new CustomerServiceImpl();
    }

    @Bean
    public AdminDaoImpl mockDoaAdmin(){
        return new AdminDaoImpl();
    }
    @Bean
    public AdminServiceImpl mockAdminService(){
        return new AdminServiceImpl();
    }

}


