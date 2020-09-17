import java.util.Date;
import java.util.List;

public class Client {
    public LoyaltyLvl loyaltyLvl;
    public String Name;
    public String phoneNumber;
    public Date BirthDate;
    public int Gender;
    public long AmountOfMoneyOnAllAccounts;
    public int AmountOfAccounts;
    public List<Account> accounts;


    public Client(LoyaltyLvl loyaltyLvl) {
        this.loyaltyLvl = loyaltyLvl;
    }

}
