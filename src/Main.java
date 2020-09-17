public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(LoyaltyLvl.Regular);
        Client client2 = new Client(LoyaltyLvl.Golden);
        Client client3 = new Client(LoyaltyLvl.VIP);
        System.out.println(client1.loyaltyLvl.getFeeNumericValue());
        System.out.println(client1.loyaltyLvl.getFeePercentValue());
    }
}
