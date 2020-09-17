import java.util.Date;

public class SavingAccount extends DebitAccount{
    private Date withdrawDate;

    public Date getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(Date withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    @Override
    public int Withdraw(int amount) {
        return super.Withdraw(amount);
    }

    @Override
    public int Deposit(int amount) {
        return super.Deposit(amount);
    }

    @Override
    public int Transfer(int amount, int Id) {
        return super.Transfer(amount, Id);
    }
}
