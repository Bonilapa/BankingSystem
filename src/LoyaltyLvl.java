public enum LoyaltyLvl {
    Regular(2),
    Golden(1),
    VIP(0),
    ;
    private int fee;

    private LoyaltyLvl(int fee){
        this.fee = fee;
    }
    public void setFee(int fee) {
        this.fee = fee;
    }

    public double getFeePercentValue(){
        return (double) fee / 100;
    }
    public int getFeeNumerucValue(){
        return fee;
    }
}
