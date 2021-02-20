package ibrahimcode.be.models;

import java.util.Objects;

public class Customer {

    private int customerID;
    private String name;
    private String surname;
    private double balance;
    private TransactionAccount transactionAccount;

    public Customer() {
    }

    public Customer(int customerID) {
        this.customerID = customerID;
    }

    public Customer(int customerID, String name, String surname, double balance) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public Customer(int customerID, String name, String surname, double balance, TransactionAccount transactionAccount) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.transactionAccount = transactionAccount;
    }


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public TransactionAccount getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(TransactionAccount transactionAccount) {
        this.transactionAccount = transactionAccount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerID == customer.customerID &&
                Double.compare(customer.balance, balance) == 0 &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(transactionAccount, customer.transactionAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, name, surname, transactionAccount);
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", transactionAccount=" + transactionAccount +
                '}';
    }
}
