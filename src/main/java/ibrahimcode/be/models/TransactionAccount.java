package ibrahimcode.be.models;

import java.util.Objects;

public class TransactionAccount {

    private int id;
    private double initialCredit;
    private int cardNumber;
    private String typeOfAccount;


    public TransactionAccount() {
    }

    public TransactionAccount(int id, double initialCredit, int cardNumber, String typeOfAccount) {
        this.id = id;
        this.initialCredit = initialCredit;
        this.cardNumber = cardNumber;
        this.typeOfAccount = typeOfAccount; // here is to mention the type of account(Current Account or Saving Account)
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(double initialCredit) {
        this.initialCredit = initialCredit;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }


    // the creditCard number and the id should'nt be double


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionAccount that = (TransactionAccount) o;
        return id == that.id &&
                cardNumber == that.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber);
    }


    // show the info
    @Override
    public String toString() {
        return "TransactionAccount{" +
                "id=" + id +
                ", initialCredit=" + initialCredit +
                ", cardNumber=" + cardNumber +
                ", typeOfAccount='" + typeOfAccount + '\'' +
                '}';
    }
}
