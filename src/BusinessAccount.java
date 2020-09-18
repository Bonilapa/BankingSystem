import java.util.Date;

public class BusinessAccount extends DebitAccount {
    public BusinessAccount(Client owner, int idCounter, Bank bank) {
        super(owner, idCounter, bank);
    }

    @Override
    public int Transfer(int amount, int clientId, int accountId) {

        if(checkNotNegativeAmount(amount) != 0){
            return 1;
        }

        long temp = totalAmountOfMoney - (long)(amount * owner.getLoyaltyLvl().getFee());

        if(checkOnPositiveBalance(temp) == 0) {//is enough money

            totalAmountOfMoney = temp;
            if (bank.clientExists(clientId) == 1) {// is there such client
                return 1;
            }

            if (bank.getAccounts().get(accountId) == null) {// костыль, потому что изначально прелполагалось long для account id
                return 1;
            }// is theer such accout

            System.out.println(amount + " transfered to client: " + clientId + " Account: " + accountId);

            operationsList.add(amount + " transfered to client: " + clientId + " Account: " + accountId + " Date: " + new Date());
            owner.setAmountOfMoneyOnAllAccounts(owner.getAmountOfMoneyOnAllAccounts() - (long) amount);
            bank.setTotalAmountOfMoneyOnAllAccounts(bank.getTotalAmountOfMoneyOnAllAccounts() - (long) amount);
            bank.getAccountById(accountId).Deposit(amount);
            return 0;

        }else{
            System.out.println("Account balance is too low");

            return 1;
        }

    }

}
