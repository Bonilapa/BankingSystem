import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BankManager {
    Bank bank;

    public BankManager(Bank bank) {
        this.bank = bank;
    }

    public int addNewClient(String name, String phoneNumber, Date birthDate, int gender, LoyaltyLvl loyaltyLvl){

        return bank.addNewClient(name, phoneNumber, birthDate, gender, loyaltyLvl);
    }

    public int createAccountForClient(Client client, AccountPurpose accountPurpose){
        if(bank.clientExists(client.getId()) == 0){
            bank.createAccountForClient(client, accountPurpose);
            return 0;
        }else{
            return 1;
        }
    }

    public int createSavingAccountForClient(Client client, Date withdrawDate){
        if(bank.clientExists(client.getId()) == 0){
            bank.createSavingAccountForClient(client, withdrawDate);
            return 0;
        }else{
            return 1;
        }
    }

    public List<Client> listAllClients() {
        return bank.getListOfClients();
    }
    public void showAllClients() {

        for (Client a :
                bank.getListOfClients()) {
            System.out.println(a.getId()+" "+a.getName()+" "+a.getPhoneNumber()+" "+a.getBirthDate()
            + " " + a.getLoyaltyLvl() +" "+ a.getGender() + " " + a.getAmountOfAccounts() + " " + a.getAmountOfMoneyOnAllAccounts());
        }
    }

    public void showAllAccounts(){
        for (Account a:
             bank.getAccounts()) {
            System.out.println(a.Id + " " + a.owner.getName() + " " + a.totalAmountOfMoney);
        }
    }
    public List<Account> listAllAccounts(Account account){

        return bank.getAccounts();
    }
    public List<Account> listClientAccounts(Client client){

        return bank.getAccounts();
    }
    public void listOperationsOfAccount(Account account){

    }
}
