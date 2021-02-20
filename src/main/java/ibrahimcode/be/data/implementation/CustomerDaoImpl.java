package ibrahimcode.be.data.implementation;

import ibrahimcode.be.data.CustomerDao;
import ibrahimcode.be.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> customerDB;

    @Autowired
    public void setCustomerList(List<Customer> customerDB) {
        this.customerDB = customerDB;
    }


    @Override
    public boolean createNewCurrentAccount(Customer customer) {
        if (!this.customerDB.contains(customer)) {
            this.customerDB.add(customer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Customer getCustomerInfo(int id) {
        try {
            if (customerDB.get(id) != null) {
                return customerDB.get(id);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }


    @Override
    public boolean openNewCurrentAccount(int id, double initialCredit) {

        if (getCustomerInfo(id) != null) {
            if (initialCredit != 0) {
                // open new current account
                customerDB.get(id).getTransactionAccount().setId(id); // make the same if for both ;)
                customerDB.get(id).getTransactionAccount().setCardNumber(generateRandomAccountNumber());
                customerDB.get(id).getTransactionAccount().setInitialCredit(initialCredit);
                customerDB.get(id).getTransactionAccount().setTypeOfAccount("Current Account");

                // here we cut the money for customer account
                double restMoney = (initialCredit - customerDB.get(id).getBalance());
                customerDB.get(id).setBalance(restMoney);

                return true;
            } else {
                // you already have current account
                System.out.println("the customer has no money");
                return false;
            }
        } else {
            System.out.println(" the Customer is not exists");
            return false;
        }
    }


    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerDB);
    }



    //=======================GenerateCardNumberVerySimple==============


    private int generateRandomAccountNumber() {
        Random random = new Random();
        return random.nextInt(9999999);
    }
}
