import java.util.Date;
import java.util.List;

public class Client {
    private LoyaltyLvl loyaltyLvl;
    private String name;
    public String phoneNumber;
    public Date BirthDate;
    public int Gender;
    public long AmountOfMoneyOnAllAccounts;
    public int AmountOfAccounts;
    public List<Account> accounts;


    public Client(LoyaltyLvl loyaltyLvl) {
        this.loyaltyLvl = loyaltyLvl;
    }

    public String getName(){
        return name;
    }

    public LoyaltyLvl getLoyaltyLvl(){
        return loyaltyLvl;
    }

}
