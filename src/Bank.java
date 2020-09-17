import java.util.List;

public class Bank {

    private String name;
    private List<Client> VIPclients;
    private List<Client> Goldenlients;
    private List<Client> RegularClients;
    private List<Account> accounts;
    private long TotalAmountOfMoneyOnAllAccounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getVIPclients() {
        return VIPclients;
    }

    public void setVIPclients(List<Client> VIPclients) {
        this.VIPclients = VIPclients;
    }

    public List<Client> getGoldenlients() {
        return Goldenlients;
    }

    public void setGoldenlients(List<Client> goldenlients) {
        Goldenlients = goldenlients;
    }

    public List<Client> getRegularClients() {
        return RegularClients;
    }

    public void setRegularClients(List<Client> regularClients) {
        RegularClients = regularClients;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public long getTotalAmountOfMoneyOnAllAccounts() {
        return TotalAmountOfMoneyOnAllAccounts;
    }

    public void setTotalAmountOfMoneyOnAllAccounts(long totalAmountOfMoneyOnAllAccounts) {
        TotalAmountOfMoneyOnAllAccounts = totalAmountOfMoneyOnAllAccounts;
    }
}