package ibrahimcode.be.controller;

import ibrahimcode.be.services.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class ShowCustomersInfo {


    private CustomerServiceImpl customerServiceImpl;


    @Autowired
    public void setCustomerServiceImpl(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }




    // show the information of all customers
    @RequestMapping("/showInfo")
    public ModelAndView showCustomersInfo(Model model){
        ModelAndView modelAndView = new ModelAndView();

        model.addAttribute("customerList", customerServiceImpl.showAllCustomers());

        modelAndView.setViewName("/content/showCustomersInfo");

        return modelAndView;

    }





}
