import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {
    private LoyaltyLvl loyaltyLvl;
    private int id;
    private String name;
    private String phoneNumber;
    private Date birthDate;
    private int gender;
    private long amountOfMoneyOnAllAccounts;    //recalculates every money operation
    private int amountOfAccounts;
    private List<Account> accounts;

    public Client(int id,
                  String name,
                  String phoneNumber,
                  Date birthDate,
                  int gender,
                  LoyaltyLvl loyaltyLvl) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.loyaltyLvl = loyaltyLvl;
        this.amountOfMoneyOnAllAccounts = 0;
        this.amountOfAccounts = 0;
        this.accounts = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public LoyaltyLvl getLoyaltyLvl() {
        return loyaltyLvl;
    }

    public void setLoyaltyLvl(LoyaltyLvl loyaltyLvl) {
        this.loyaltyLvl = loyaltyLvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getGender() {
        return gender;
    }

    /*
     * we are progressive society
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getAmountOfMoneyOnAllAccounts() {
        return amountOfMoneyOnAllAccounts;
    }
    /*
     * According to the task
     * client must have this property,
     * even if its recalculation is really redundant
     */
    public void setAmountOfMoneyOnAllAccounts(long amountOfMoneyOnAllAccounts) {
        this.amountOfMoneyOnAllAccounts = amountOfMoneyOnAllAccounts;
    }

    public int getAmountOfAccounts() {
        return accounts.size();
    }

    public int accountExists(long id){
        for (Account a:
             accounts) {
            if(a.getId() == id){
                return 0;
            }
        }

        return 1; //no matches found
    }
    public int addAccount(Account account){

        accounts.add(account);
        return 0;
    }
    public List<Account> getAccounts(){
        return accounts;
    }
}
