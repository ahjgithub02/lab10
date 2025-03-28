public class BankAccount
{
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber,
                       double balance)
    {
        validateAccountNumber(accountNumber); //apperantly the result for this is ignored
        validateBalance(balance);

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountId()
    {
        return accountNumber;
    }

    public double getBalanceUsd()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount)
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

    public void transferToBank(BankAccount recipient,
                               String senderId,
                               double amount) {
        if (!this.accountNumber.equals(senderId))
        {
            throw new IllegalArgumentException("Sender account ID does not match");
        }
        this.withdraw(amount);
        recipient.deposit(amount);
    }

    public static boolean validateAccountNumber(String accountNumber)
    {
        return accountNumber != null && !accountNumber.isBlank(); //this is never used
    }

    public static void validateBalance(double balance)
    {
        if (balance < 0)
        {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
    }
}
