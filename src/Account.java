/*
 * Base class with base fields and operations
 */
public abstract class Account {

    protected static long idCounter = 0;    //bank only for 8 bln accounts

    protected long Id;
    protected Client owner;

    /*
    * The name is according to the task,
    * but the variable is just an amount of money
    * on this account.
    */
    protected long totalAmountOfMoney;

    /**/
    public abstract int Withdraw(int amount);

    public abstract int Deposit(int amount);

    public abstract int Transfer(int amount, int Id);

    public Account(Client owner) {

        if(idCounter < 0) {
            throw new RuntimeException(
                    "IdCounter was incorrectly changed. Malicious interference."
            );
        }
        this.owner = owner;
        this.totalAmountOfMoney = 0;    //initial 0 money on account
    }

    public static long getIdCounter() {
        return idCounter;
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

    public void setTotalAmountOfMoney(long totalAmountOfMoney) {
        this.totalAmountOfMoney = totalAmountOfMoney;
    }
}
