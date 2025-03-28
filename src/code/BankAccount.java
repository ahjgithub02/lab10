/**
 * Represents a bank account with an account number and balance.
 *
 * @author Daryan Worya
 * @author Andrew Hwang
 * @author Yang Li
 * @version 1.0
 */
public class BankAccount
{
    private final String accountNumber;
    private double balance;

    /**
     * Constructs a new BankAccount with the specified account number and initial balance.
     *
     * @param accountNumber the unique account number for this bank account.
     * @param balance the initial balance for this bank account.
     */
    public BankAccount(final String accountNumber,
                       final double balance)
    {
        validateAccountNumber(accountNumber); // apparently the result for this is ignored
        validateBalance(balance);

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Returns the account ID of this bank account.
     *
     * @return the account number.
     */
    public String getAccountId()
    {
        return accountNumber;
    }

    /**
     * Returns the current balance in USD.
     *
     * @return the balance in USD.
     */
    public double getBalanceUsd()
    {
        return balance;
    }

    /**
     * Deposits the specified amount into this bank account.
     *
     * @param amount the amount to deposit.
     * @throws IllegalArgumentException if the deposit amount is not positive.
     */
    public void deposit(final double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    /**
     * Withdraws the specified amount from this bank account.
     *
     * @param amount the amount to withdraw.
     * @throws IllegalArgumentException if the withdrawal amount is not positive or exceeds the current balance.
     */
    public void withdraw(final double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance)
        {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    /**
     * Transfers the specified amount from this account to the recipient account.
     *
     * @param recipient the BankAccount to receive the transfer.
     * @param senderId the sender's account ID, which must match this account's ID.
     * @param amount the amount to transfer.
     * @throws IllegalArgumentException if the sender account ID does not match this account's ID.
     */
    public void transferToBank(final BankAccount recipient,
                               final String senderId,
                               final double amount)
    {
        if (!this.accountNumber.equals(senderId))
        {
            throw new IllegalArgumentException("Sender account ID does not match");
        }
        this.withdraw(amount);
        recipient.deposit(amount);
    }

    /**
     * Validates the account number.
     *
     * @param accountNumber the account number to validate.
     * @return {@code true} if the account number is not null and not blank, otherwise {@code false}.
     */
    public static boolean validateAccountNumber(final String accountNumber)
    {
        return accountNumber != null && !accountNumber.isBlank(); // this is never used
    }

    /**
     * Validates that the initial balance is not negative.
     *
     * @param balance the balance to validate.
     * @throws IllegalArgumentException if the balance is negative.
     */
    public static void validateBalance(double balance)
    {
        if (balance < 0)
        {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
    }
}
