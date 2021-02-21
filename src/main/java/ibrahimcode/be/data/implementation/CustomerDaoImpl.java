package ibrahimcode.be.data.implementation;

import ibrahimcode.be.data.CustomerDao;
import ibrahimcode.be.models.Customer;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> customerDB =new ArrayList<>();

    @Override
    public boolean createNewAccount(Customer customer) {
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
            for (Customer customer : customerDB) {
                if (customer.getCustomerID() == id) {
                    return customer;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }



    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerDB);
    }





}
