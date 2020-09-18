import java.util.Date;

public class SavingAccount extends DebitAccount {

    private Date withdrawDate;

    public Date getWithdrawDate() {
        return withdrawDate;
    }

    public SavingAccount(Client owner, int idCounter, Bank bank, Date withdrawDate) {
        super(owner, idCounter, bank);
        this.withdrawDate = withdrawDate;
    }

    /*
     * return 0 - ok
     * return 1 - something gone wrong
     */
    @Override
    public int Withdraw(int amount) {
        if(checkWithdrawDate(new Date()) == 0){

            return super.Withdraw(amount);
        }else{
            System.out.println("The withdraw date have not come yet");
            return 1;
        }
    }

    /*
     * return 0 - ok
     * return 1 - something gone wrong
     */
    private int checkWithdrawDate(Date date){
        if(date.compareTo(withdrawDate) >= 0){
            return 0;
        }
        return 1;
    }

    @Override
    public int Deposit(int amount) {
        return super.Deposit(amount);
    }

    @Override
    public int Transfer(int amount, int clientId, int accountId) {
        return super.Transfer(amount, clientId, accountId);
    }
}
