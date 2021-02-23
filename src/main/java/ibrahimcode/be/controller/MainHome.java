package ibrahimcode.be.controller;

import ibrahimcode.be.models.Admin;
import ibrahimcode.be.models.Customer;
import ibrahimcode.be.services.implementation.AdminServiceImpl;
import ibrahimcode.be.services.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainHome {

    private AdminServiceImpl adminServiceImpl;
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    public void setAdminServiceImpl(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }


    @Autowired
    public void setCustomerServiceImpl(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }


    @RequestMapping("/")
    public ModelAndView index(Model model){
        ModelAndView modelAndView = new ModelAndView();

        customerServiceImpl.addCustomers(addCustomers()); // Add customers ;)
        adminServiceImpl.addAdmin(adminInfo());// Add admin Info ;)

        model.addAttribute("customerList",customerServiceImpl.showAllCustomers());

        modelAndView.setViewName("index");
        return modelAndView;
    }


    @PostMapping("/admin")
    public ModelAndView loginAdmin(@ModelAttribute("adminLogin") Admin admin,
                                   Model model){
        ModelAndView modelAndView = new ModelAndView();
        String username = admin.getUsername();
        String password = admin.getPassword();

        if(adminServiceImpl.checkAdminLogin(username,password)){

        modelAndView.setViewName("redirect:/customer_Service");
            return modelAndView;
        }
            model.addAttribute("invalid_user_error", true);
            modelAndView.setViewName("index");
        return modelAndView;
    }


    @GetMapping("/customer_Service")
    public ModelAndView customerServicePage(@ModelAttribute("login") Admin admin,
                                    Model model){
        ModelAndView modelAndView = new ModelAndView();
        // show the page of customer service :
        // welcome with name of admin
        // show the TextBox for searching the customer by ID

//        model.addAttribute("Welcome",admin.getName()); // show the name of the admin

        modelAndView.setViewName("/content/customerService");
        return modelAndView;

    }



    //private methods for add customers to be already exists customer
    private List<Customer> addCustomers(){
        Customer customer1 = new Customer();
        customer1.setCustomerID(1);
        customer1.setName("ibrahim");
        customer1.setSurname("Alolofi");
        customer1.setBalance(2150);

        Customer customer2 = new Customer();
        customer2.setCustomerID(2);
        customer2.setName("Bart");
        customer2.setSurname("javaEE11");
        customer2.setBalance(0);

        Customer customer3 = new Customer();
        customer3.setCustomerID(3);
        customer3.setName("Kevin");
        customer3.setSurname("java11Dev");
        customer3.setBalance(1990);

        Customer customer4 = new Customer();
        customer4.setCustomerID(4);
        customer4.setName("Sam");
        customer4.setSurname("java11EEDev");
        customer4.setBalance(1760);


        // create a list in order to add all the persons
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);

        return customerList;
    }

    //private methods for add admin
    private Admin adminInfo(){

        Admin admin = new Admin();
        admin.setName("ibrahimbow");
        admin.setUsername("bbg");
        admin.setPassword("bbg");

        return admin;
    }


}
