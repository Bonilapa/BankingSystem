public abstract class Account {
    protected long totalAmountOfMoney;
    public abstract int Withdraw(int amount);
    public abstract int Deposit(int amount);
    public abstract int Transfer(int amount, int Id);
}
