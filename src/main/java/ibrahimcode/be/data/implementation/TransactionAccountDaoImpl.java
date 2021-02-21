package ibrahimcode.be.data.implementation;

import ibrahimcode.be.data.TransactionAccountDao;
import ibrahimcode.be.models.TransactionAccount;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class TransactionAccountDaoImpl  implements TransactionAccountDao {

    private List<TransactionAccount> transactionAccounts = new ArrayList<>();

    @Override
    public void addCurrentAccount(TransactionAccount transactionAccount) {
        this.transactionAccounts.add(transactionAccount);
    }
}
