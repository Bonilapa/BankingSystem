import java.util.Date;

public class CreditAccount extends Account {
    private long dept;

    @Override

    public long getTotalAmountOfMoney() {
        return totalAmountOfMoney - dept;
    }


    public CreditAccount(Client owner, int idCounter, Bank bank) {

        super(owner, idCounter, bank);
        dept = 0;
    }

    /*
     * return 0 - ok
     * return 1 - something gone wrong
     */
    @Override
    public int Withdraw(int amount) {
        if (checkNotNegativeAmount(amount) != 0) {
            return 1;
        }

        long temp = totalAmountOfMoney - (long) amount;

        if (checkOnPositiveBalance(temp) != 0) {
            dept = -temp;
            totalAmountOfMoney = 0;
        } else {
            totalAmountOfMoney = temp;
        }
        System.out.println(amount + " withdrawn");

        operationsList.add("Withdraw " + amount + " Date: " + new Date());
        owner.setAmountOfMoneyOnAllAccounts(owner.getAmountOfMoneyOnAllAccounts() - (long) amount);
        bank.setTotalAmountOfMoneyOnAllAccounts(bank.getTotalAmountOfMoneyOnAllAccounts() - (long) amount);
        return 0;


    }

    /*
     * return 0 - ok
     * return 1 - something gone wrong
     */
    @Override
    public int Deposit(int amount) {

        if (checkNotNegativeAmount(amount) != 0) {
            return 1;
        }
        long temp = totalAmountOfMoney + (long) amount;
        if (dept == 0) {
            totalAmountOfMoney = temp;
        } else if (temp >= dept) {
            dept = 0;
            totalAmountOfMoney = temp - dept;
        } else {
            dept -= temp;
        }

        System.out.println(amount + " deposited");
        operationsList.add("Deposited " + amount + " Date: " + new Date());
        owner.setAmountOfMoneyOnAllAccounts(owner.getAmountOfMoneyOnAllAccounts() + (long) amount);
        bank.setTotalAmountOfMoneyOnAllAccounts(bank.getTotalAmountOfMoneyOnAllAccounts() + (long) amount);

        return 0;

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

        if (checkNotNegativeAmount(amount) != 0) {
            return 1;
        }
        if (bank.clientExists(clientId) == 1) {// is there such client
            return 1;
        }

        if (bank.getAccounts().get(accountId) == null) {// костыль, потому что изначально прелполагалось long для account id
            return 1;
        }// is theer such accout

        long temp = totalAmountOfMoney - (long) amount;

        if (checkOnPositiveBalance(temp) != 0) {
            dept = -temp;
            totalAmountOfMoney = 0;
        } else if (checkOnPositiveBalance(temp) == 0) {//is enough money

            totalAmountOfMoney = temp;
        }


        System.out.println(amount + " transfered to client: " + clientId + " Account: " + accountId);

        operationsList.add(amount + " transfered to client: " + clientId + " Account: " + accountId + " Date: " + new Date());
        owner.setAmountOfMoneyOnAllAccounts(owner.getAmountOfMoneyOnAllAccounts() - (long) amount);
        bank.setTotalAmountOfMoneyOnAllAccounts(bank.getTotalAmountOfMoneyOnAllAccounts() - (long) amount);
        bank.getAccountById(accountId).Deposit(amount);
        return 0;


    }

    public long getDept() {
        return dept;
    }
}
