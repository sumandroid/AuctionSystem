package domain.models;

public class Bid {

    private float amount;
    private Buyer bidder;

    public Bid(float amount, Buyer bidder) {
        this.amount = amount;
        this.bidder = bidder;
    }

    public float getAmount() {
        return amount;
    }

    public Buyer getBidder() {
        return bidder;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
