public class DebitAccount extends Account{

    public DebitAccount(Client owner, long idCounter){

        super(owner, idCounter);
    }

    @Override
    public int Withdraw(int amount) {

        long temp = totalAmountOfMoney + (long)amount;

        if(temp >= 0) {

            totalAmountOfMoney = temp;
            System.out.println(amount + " withdrawn");

            return 0;

        }else{

            System.out.println("Account balance is too low");

            return 1;
        }
    }

    @Override
    public int Deposit(int amount) {
        long temp = totalAmountOfMoney + (long)amount;

        if(temp >= 0) {

            totalAmountOfMoney = temp;
        }
        return 0;
    }

    @Override
    public int Transfer(int amount, int Id) {
        return 0;
    }
}
