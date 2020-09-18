public enum LoyaltyLvl {
    Regular(2),
    Golden(1),
    VIP(0),
    ;
    private double transferFee;

    private LoyaltyLvl(double transferFee){
        this.transferFee = transferFee;
    }
    public void setFee(double transferFee) {
        this.transferFee = transferFee;
    }
    public double getFee(){ return transferFee;}

    public double getFeePercentValue(){
        return transferFee / 100;
    }
    public double getFeeNumericValue(){
        return transferFee;
    }
}