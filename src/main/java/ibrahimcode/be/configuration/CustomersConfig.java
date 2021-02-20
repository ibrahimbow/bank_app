package ibrahimcode.be.configuration;

import ibrahimcode.be.data.implementation.CustomerDaoImpl;
import ibrahimcode.be.models.Customer;
import ibrahimcode.be.services.implementation.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
public class CustomersConfig {


    @Bean
    @Scope("prototype")  //  not only for only single instant run
    public Customer customer(){
        return new Customer();
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
    public CustomerServiceImpl mackService(){
        return new CustomerServiceImpl();
    }


}
