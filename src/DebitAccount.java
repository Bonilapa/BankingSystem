import java.util.Date;

/*
 * Class implements basic bank operations
 * for regular Debit accounts.
 * Also it is a inheritance base
 * for account child classes that
 * need not to be re-implemented
 */
public class DebitAccount extends Account{

    public DebitAccount(Client owner, int idCounter, Bank bank){

        super(owner, idCounter, bank);
    }

    /*
     * return 0 - ok
     * return 1 - something gone wrong
     */
    @Override
    public int Withdraw(int amount) {
        if(checkNotNegativeAmount(amount) != 0){
            return 1;
        }

        long temp = totalAmountOfMoney - (long)amount;

        if(checkOnPositiveBalance(temp) == 0) {

            totalAmountOfMoney = temp;
            System.out.println(amount + " withdrawn");

            operationsList.add("Withdraw " + amount + " Date: " + new Date());
            owner.setAmountOfMoneyOnAllAccounts(owner.getAmountOfMoneyOnAllAccounts() - (long)amount);
            bank.setTotalAmountOfMoneyOnAllAccounts(bank.getTotalAmountOfMoneyOnAllAccounts() - (long)amount);
            return 0;

        }else{

            System.out.println("Account balance is too low");

            return 1;
        }
    }

    /*
     * return 0 - ok
     * return 1 - something gone wrong
     */
    @Override
    public int Deposit(int amount) {

        if(checkNotNegativeAmount(amount) != 0){
            return 1;
        }
        long temp = totalAmountOfMoney + (long)amount;

        if(checkOnPositiveBalance(temp) == 0) {

            totalAmountOfMoney = temp;
            System.out.println(amount + " deposited");
            operationsList.add("Deposited " + amount + " Date: " + new Date());
            owner.setAmountOfMoneyOnAllAccounts(owner.getAmountOfMoneyOnAllAccounts() + (long)amount);
            bank.setTotalAmountOfMoneyOnAllAccounts(bank.getTotalAmountOfMoneyOnAllAccounts() + (long)amount);

            return 0;

        }else {

            System.out.println("Account balance is too large. Please create a new account to store more money");
            return 1;
        }
    }
    /*
     * Bank manager in its implementation check
     * a destination account on ability to get
     * this amount of money. After success check
     * uses Withdraw() method of source and deposit()
     * of destination.
     *
     * return 0 - ok
     * return 1 - something gone wrong
     */
    @Override
    public int Transfer(int amount, int clientId, int accountId) {

        if(checkNotNegativeAmount(amount) != 0){
            return 1;
        }

        long temp = totalAmountOfMoney - (long)amount;

        if(checkOnPositiveBalance(temp) == 0) {//is enough money

            if (bank.clientExists(clientId) == 1) {// is there such client
                return 1;
            }

            if (bank.getAccounts().get(accountId) == null) {// костыль, потому что изначально прелполагалось long для account id
                return 1;
            }// is theer such accout

            totalAmountOfMoney = temp;
            bank.getAccountById(accountId).Deposit(amount);
            System.out.println(amount + " transfered to client: " + clientId + " Account: " + accountId);

            operationsList.add(amount + " transfered to client: " + clientId + " Account: " + accountId + " Date: " + new Date());
            owner.setAmountOfMoneyOnAllAccounts(owner.getAmountOfMoneyOnAllAccounts() - (long) amount);
            bank.setTotalAmountOfMoneyOnAllAccounts(bank.getTotalAmountOfMoneyOnAllAccounts() - (long) amount);
            return 0;

        }else{
            System.out.println("Account balance is too low");

            return 1;
        }

    }
}
