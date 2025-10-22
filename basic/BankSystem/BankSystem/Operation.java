package BankSystem;
/**
 * Абстрактный класс, который описывает
 * банковскую операцию
 */
public abstract class Operation{
    //Денежные средства в банковской операции
    protected double amount;
    //Выполняет банковскую операцию
    public abstract void doWork( ) throws OperationException;
}
