public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(LoyaltyLvl.Regular);
        Client client2 = new Client(LoyaltyLvl.Golden);
        Client client3 = new Client(LoyaltyLvl.VIP);
        System.out.println(client1.loyaltyLvl.getFeeNumerucValue());
        System.out.println(client1.loyaltyLvl.getFeePercentValue());
        System.out.println(client2.loyaltyLvl.getFeeNumerucValue());
        System.out.println(client2.loyaltyLvl.getFeePercentValue());
        System.out.println(client3.loyaltyLvl.getFeeNumerucValue());
        System.out.println(client3.loyaltyLvl.getFeePercentValue());
    }
}
