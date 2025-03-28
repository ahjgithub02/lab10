import java.util.HashMap;
import java.util.Map;

/**
 * Represents a bank that manages multiple bank accounts.
 */
public class Bank {
    private final Map<String, BankAccount> accounts;

    /**
     * Constructs a new Bank instance.
     */
    public Bank() {
        accounts = new HashMap<>();
    }

    /**
     * Adds a new bank account to the bank.
     *
     * @param account the bank account to be added.
     * @throws IllegalArgumentException if an account with the same ID already exists.
     */
    public void addAccount(final BankAccount account) {
        if (accounts.containsKey(account.getAccountId())) {
            throw new IllegalArgumentException("Account ID already exists");
        }
        accounts.put(account.getAccountId(), account);
    }

    /**
     * Retrieves the bank account with the specified account ID.
     *
     * @param accountId the unique identifier of the bank account.
     * @return the bank account associated with the given ID.
     * @throws IllegalArgumentException if no account is found for the given ID.
     */
    public BankAccount retrieveAccount(final String accountId) {
        if (!accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("Account not found");
        }
        return accounts.get(accountId);
    }

    /**
     * Calculates the total balance of all bank accounts in USD.
     *
     * @return the sum of the USD balances of all accounts.
     */
    public double totalBalanceUsd() {
        return accounts.values().stream().mapToDouble(BankAccount::getBalanceUsd).sum();
    }
}
