package ibrahimcode.be.controller;


import ibrahimcode.be.models.Customer;
import ibrahimcode.be.models.TransactionAccount;
import ibrahimcode.be.services.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@RestController
public class NewCurrentAccount {

    private CustomerServiceImpl customerServiceImpl;
    private TransactionAccount transactionAccount;


    @Autowired
    public void setTransactionAccount(TransactionAccount transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    @Autowired
    public void setCustomerServiceImpl(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }




    @PostMapping("/openCurrentAccount")
    public ModelAndView openCurrentAccountForCustomer(@ModelAttribute("customerInfo") Customer customer,
                                   Model model){
        ModelAndView modelAndView = new ModelAndView();
        int customerId = customer.getCustomerID();
        double initialCredit = customer.getTransactionAccount().getInitialCredit();
        double balance = customerServiceImpl.getCustomer(customerId).getBalance();

        if(customerServiceImpl.getCustomer(customerId) != null &&
                customerServiceImpl.getCustomer(customerId).getTransactionAccount().getInitialCredit()!=0){
            model.addAttribute("customerInfo", customerServiceImpl.getCustomer(customerId));
            model.addAttribute("invalid_CurrentAccount_error", true);
            modelAndView.setViewName("/content/openNewCurrentAccount");
        }else if (initialCredit != 0 && balance!=0) {
            // open new current account
            transactionAccount.setId(customerId);
            transactionAccount.setInitialCredit(initialCredit);
            transactionAccount.setTypeOfAccount("Current Account");
            transactionAccount.setCardNumber(generateRandomAccountNumber()); // random Credit Number
            // add the current account the customer who applied for
            customerServiceImpl.getCustomer(customerId).setTransactionAccount(transactionAccount);
            // here we cut the money for customer account the sent to the current account
            double restMoney = (customerServiceImpl.getCustomer(customerId).getBalance() - initialCredit);
            customerServiceImpl.getCustomer(customerId).setBalance(restMoney);
            //show the info of the customer
            model.addAttribute("customerCurrentAccountCreated", customerServiceImpl.getCustomer(customerId));
            modelAndView.setViewName("/content/currentAccountIsCreated");
        }else{

            model.addAttribute("customerInfo", customerServiceImpl.getCustomer(customerId));
            model.addAttribute("invalid_money_error", true);
            modelAndView.setViewName("/content/openNewCurrentAccount");
        }
        return modelAndView;

    }


        //=======================GenerateCardNumberVerySimple==============

    private int generateRandomAccountNumber() {
        Random random = new Random();
        return random.nextInt(9999999);
    }

}
