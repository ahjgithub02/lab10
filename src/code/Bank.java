import java.util.HashMap;
import java.util.Map;

public class Bank
{
    private Map<String, BankAccount> accounts;

    public Bank()
    {
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account)
    {
        if (accounts.containsKey(account.getAccountId()))
        {
            throw new IllegalArgumentException("Account ID already exists");
        }
        accounts.put(account.getAccountId(), account);
    }

    public BankAccount retrieveAccount(String accountId)
    {
        if (!accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("Account not found");
        }
        return accounts.get(accountId);
    }

    public double totalBalanceUsd()
    {
        return accounts.values().stream().mapToDouble(BankAccount::getBalanceUsd).sum();
    }
}

