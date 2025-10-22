package BankSystem;
/**
 * Операция перемещения денежных
 * средств по счету
 */
public class AccountOperation extends Operation{
    //Счет учавствующий в операции
    private Bank.Account account;
    public AccountOperation(Bank.Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }
    public void doWork() throws OperationException {
        double balance = account.getBalance();
        double result = balance + amount ;
        if (result < 0)
            throw new OperationException("Недостаточно денежных средств на счете "+account);
        account.setBalance(result);
    }
}