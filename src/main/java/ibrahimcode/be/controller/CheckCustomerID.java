package ibrahimcode.be.controller;

import ibrahimcode.be.models.Customer;
import ibrahimcode.be.services.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CheckCustomerID {

    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    public void setCustomerServiceImpl(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }



    @GetMapping("/customerServicePage")
    public ModelAndView checkCustomer(Model model){
        ModelAndView modelAndView = new ModelAndView();

        model.addAttribute("customerCheck",new Customer());
        modelAndView.setViewName("/content/checkCustomer");
        return modelAndView;

    }


    // Check customer Id if it is exists or not ?
    @PostMapping("/checkCustomerID")
    public ModelAndView checkCustomerID(@ModelAttribute("customerCheck") Customer customer,
                                   Model model){
        ModelAndView modelAndView = new ModelAndView();

        int customer_id =  customer.getCustomerID();

            if (customerServiceImpl.getCustomer(customer_id)!=null) {
                model.addAttribute("customerInfo", customerServiceImpl.getCustomer(customer_id));
                modelAndView.setViewName("/content/openNewCurrentAccount");
                return modelAndView;
            }
                model.addAttribute("invalid_user_error", true);
                modelAndView.setViewName("/content/checkCustomer");
                return modelAndView;
    }



}
