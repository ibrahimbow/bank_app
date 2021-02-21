package ibrahimcode.be.services.implementation;

import ibrahimcode.be.data.TransactionAccountDao;
import ibrahimcode.be.models.TransactionAccount;
import ibrahimcode.be.services.TransactionAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionAccountServiceImpl implements TransactionAccountService {


    private TransactionAccountDao transactionAccountDao;

    @Autowired
    public void setTransactionAccountDao(TransactionAccountDao transactionAccountDao) {
        this.transactionAccountDao = transactionAccountDao;
    }


    @Override
    public void addTransactionAccount(TransactionAccount transactionAccount) {

        this.transactionAccountDao.addCurrentAccount(transactionAccount);
    }
}
