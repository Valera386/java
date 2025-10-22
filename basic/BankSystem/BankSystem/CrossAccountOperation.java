package BankSystem;
/**
 * Операция перемещения денежных
 * средств между счетами
 */
public class CrossAccountOperation extends Operation{
    //Счет с которого уходят денежные средства
    private Bank.Account outAccount;
    //Счет на который поступают денежные средства
    private Bank.Account inAccount;
    public CrossAccountOperation(Bank.Account inAccount,Bank.Account
            outAccount,double amount){
        this.inAccount = inAccount;
        this.outAccount = outAccount;
        super.amount = amount;
    }
    public void doWork() throws OperationException{
        double balance = outAccount.getBalance();
        if (balance < amount)
            throw new OperationException("Недостаточно денежных средств  на счете "+outAccount);
        inAccount.setBalance(balance+amount);
        outAccount.setBalance(balance-amount);
    }
}