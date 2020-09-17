public enum LoyaltyLvl {
    Regular(2),
    Golden(1),
    VIP(0),
    ;
    private int transferFee;

    private LoyaltyLvl(int transferFee){
        this.transferFee = transferFee;
    }
    public void setFee(int transferFee) {
        this.transferFee = transferFee;
    }

    public double getFeePercentValue(){
        return (double) transferFee / 100;
    }
    public int getFeeNumericValue(){
        return transferFee;
    }
}
