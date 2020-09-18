/*
 * Account class with base fields and
 * operations implemented.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Bank {

    private String name;
    private List<Client> VIPClients;
    private List<Client> goldenClients;
    private List<Client> regularClients;
    private List<Account> accounts;
    private long TotalAmountOfMoneyOnAllAccounts;

    /*
     * Bank creates accounts and counts their amount.
     * It provides unique Id.
     */
    private int idAccountCounter;

    /*
     * Bank creates clients and counts their amount.
     * It provides unique Id.
     */
    private int idClientCounter;

    public Bank(String name) {
        this.name = name;
        this.VIPClients = new ArrayList<>();
        this.goldenClients = new ArrayList<>();
        this.regularClients = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.TotalAmountOfMoneyOnAllAccounts = 0;
        this.idAccountCounter = 0;
        this.idClientCounter = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getVIPclients() {
        return VIPClients;
    }

    public List<Client> getGoldenClients() {
        return goldenClients;
    }


    public List<Client> getRegularClients() {
        return regularClients;
    }


    public List<Account> getAccounts() {
        return accounts;
    }


    public long getTotalAmountOfMoneyOnAllAccounts() {
        return TotalAmountOfMoneyOnAllAccounts;
    }

    public void setTotalAmountOfMoneyOnAllAccounts(long totalAmountOfMoneyOnAllAccounts) {
        TotalAmountOfMoneyOnAllAccounts = totalAmountOfMoneyOnAllAccounts;
    }

    public int addNewClient(String name, String phoneNumber, Date birthDate, int gender, LoyaltyLvl loyaltyLvl) {
        if (loyaltyLvl != LoyaltyLvl.Golden
                &&
                loyaltyLvl != LoyaltyLvl.Regular
                &&
                loyaltyLvl != LoyaltyLvl.VIP) {
            new BankException().Warning("Unknown loyalty type. Possible malicious interference");
            return 1;
        }

        Client newClient = new Client(idClientCounter++, name, phoneNumber, birthDate, gender, loyaltyLvl);
        if (clientExists(newClient.getId()) == 0) {
            new BankException().Warning("Incorrect client id. Possible malicious interference");
            return 1;
        }
        if (loyaltyLvl == LoyaltyLvl.Regular) {
            regularClients.add(newClient);
            return 0;
        } else if (loyaltyLvl == LoyaltyLvl.Golden) {
            goldenClients.add(newClient);
            return 0;
        } else {
            VIPClients.add(newClient);
            return 0;
        }
    }

    /* return 0 - ok
     * return 1 - something gone wrong
     */
    public int clientExists(int id) {

        if (id > idClientCounter - 1) {
            return 1;
        }
        for (Client a :
                VIPClients) {
            if (a.getId() == id)
                return 0;
        }
        for (Client a :
                goldenClients) {
            if (a.getId() == id)
                return 0;
        }
        for (Client a :
                regularClients) {
            if (a.getId() == id)
                return 0;
        }
        return 1;
    }
     public int createAccountForClient(Client owner,
                                       AccountPurpose accountPurpose){
         if(accountPurpose == AccountPurpose.Debit){
             Account account = new DebitAccount(owner, this.idAccountCounter++, this);
             accounts.add(account);
             System.out.println(account.getId());
             owner.addAccount(account);
         }
         if(accountPurpose == AccountPurpose.Credit){
             Account account = new CreditAccount(owner, this.idAccountCounter++, this);
             accounts.add(account);
             owner.addAccount(account);
         }
         if(accountPurpose == AccountPurpose.Business){
             Account account = new BusinessAccount(owner, this.idAccountCounter++, this);
             accounts.add(account);
             owner.addAccount(account);
         }
         return 0;
     }

    public int createSavingAccountForClient(Client owner, Date withdrawDate) {

            owner.addAccount(new SavingAccount(owner, idAccountCounter++, this, withdrawDate));
            return 0;
    }

    public List<Client> getListOfClients() {
        List<Client> list = new ArrayList<>();
        list.addAll(VIPClients);
        list.addAll(goldenClients);
        list.addAll(regularClients);
        return list;
    }

    public List<Account> getAccountsOfClient(Client client){
         return client.getAccounts();
    }
    public Account getAccountById(int id){
        if(id > idAccountCounter){
            return null;
        }
        if(accounts.get(id) != null) {
            return accounts.get(id);
        }else {
            return null;
        }
    }

    public Client getClientById(int id){
        for (Client a :
                VIPClients) {
            if (a.getId() == id) {
                return a;
            }
        }
        for (Client a :
                goldenClients) {
            if (a.getId() == id) {
                return a;
            }
        }
        for (Client a :
                regularClients) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;

    }

}