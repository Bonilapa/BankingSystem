import java.util.ArrayList;
import java.util.List;

/*
 * Base class with base fields and
 * operations declared.
 */
public abstract class Account {

    protected int Id;
    protected Client owner;
    protected Bank bank;
    protected List<String> operationsList;

    /*
    * The name is according to the task,
    * but the variable is just an amount of money
    * on this account.
    */
    protected long totalAmountOfMoney;

    /**/
    public abstract int Withdraw(int amount);

    public abstract int Deposit(int amount);

    public abstract int Transfer(int amount, int clientId, int accountId);

    public Account(Client owner, int idCounter, Bank bank) {


        this.Id = idCounter;
        this.owner = owner;
        this.totalAmountOfMoney = 0;    //initial 0 money on account
        this.bank = bank;
        operationsList = new ArrayList<>();
    }


    public long getId() {
        return Id;
    }

    public Client getOwner() {
        return owner;
    }

    public long getTotalAmountOfMoney() {
        return totalAmountOfMoney;
    }


    /*
     * return 0 - ok
     * return 1 - something gone wrong
     */
    public int checkOnPositiveBalance(long amount){

        if(amount >= 0) {

            return 0;

        }else {
            return 1;
        }
    }

    /*
     * Method checks input amount of money on negative number
     *
     * return 0 - ok
     * return 1 - something gone wrong
     */
    protected int checkNotNegativeAmount(int amount){
        if(amount < 0){
            new BankException().Warning("A withdraw for negative amount. Malicious interference is possible");
            return 1;
        }else{
            return 0;
        }
    }

}
