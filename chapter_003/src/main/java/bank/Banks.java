package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banks {
    Map<User, List<Account>> banks = new HashMap<>();

    public void addUser(User user) {
        banks.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        banks.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : banks.entrySet()) {
            if ((entry.getKey().passport).equals(passport)) {
                entry.getValue().add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : banks.entrySet()) {
            if ((entry.getKey().passport).equals(passport)) {
                entry.getValue().remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : banks.entrySet()) {
            if ((entry.getKey().passport).equals(passport)) {
                list = entry.getValue();
                break;
            }
        }
        return list;
    }

    public Account findAccount(String passport, String requisite) {
        List<Account> list = new ArrayList<>(this.getUserAccounts(passport));
        Account result = null;
        for (Account entry : list) {
            if ((entry.requisites).equals(requisite)) {
                result = entry;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account src = this.findAccount(srcPassport, srcRequisite);
        Account dst = this.findAccount(dstPassport, dstRequisite);
        if ((src != null) && (dst != null)) {
            result = src.transfer(dst, amount);
        }
        return result;
    }
}
