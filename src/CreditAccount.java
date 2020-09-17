public class CreditAccount extends DebitAccount{
    private int dept;

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

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }
}
