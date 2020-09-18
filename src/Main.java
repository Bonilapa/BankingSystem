import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Alpha");
        BankManager bankManager = new BankManager(bank);
        bankManager.addNewClient("reg", "14444", new Date(), 1, LoyaltyLvl.Regular );
        bankManager.addNewClient("gol2", "66666", new Date(), 1, LoyaltyLvl.Golden );
        bankManager.addNewClient("vip", "55555", new Date(), 1, LoyaltyLvl.VIP );
        bankManager.addNewClient("gol4", "33333", new Date(), 1, LoyaltyLvl.Golden );
        bankManager.showAllClients();

        bankManager.createAccountForClient(bank.getClientById(0), AccountPurpose.Debit);
        bankManager.createAccountForClient(bank.getClientById(1), AccountPurpose.Business);
        bankManager.createAccountForClient(bank.getClientById(0), AccountPurpose.Credit);
        bankManager.createAccountForClient(bank.getClientById(0), AccountPurpose.Credit);
        bankManager.createAccountForClient(bank.getClientById(2), AccountPurpose.Business);
        bankManager.createAccountForClient(bank.getClientById(3), AccountPurpose.Debit);
        bankManager.createAccountForClient(bank.getClientById(1), AccountPurpose.Debit);

        bankManager.showAllAccounts();

        bankManager.createSavingAccountForClient(bank.getClientById(2), new Date());
        bank.getAccountById(2).Deposit(200);
        bank.getAccountById(2).Deposit(200);
        bank.getAccountById(2).Transfer(10000, 1, 1);
        System.out.println(bank.getAccountById(2).getTotalAmountOfMoney());
    }
}
