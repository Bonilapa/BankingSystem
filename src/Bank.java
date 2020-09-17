import java.util.List;

public class Bank {
    
    private String name;
    private List<Client> clients;
    private List<Account> accounts;
    private long TotalAmountOfMoneyOnAllAccounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
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