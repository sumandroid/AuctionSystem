package domain.models;

import java.util.ArrayList;
import java.util.List;

public class Auction {

    private String name;
    private List<Item> itemList;
    private List<Buyer> buyers;
    private Bid winningBid;
    private List<Bid> bids;
    private float profit;
    private float participationFees;

    public String getName() {
        return name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public Bid getWinningBid() {
        return winningBid;
    }

    public void setWinningBid(Bid bid) {
        this.winningBid = bid;
    }

    public void addBuyer(Buyer buyer){
        buyers.add(buyer);
    }

    public List<Bid> getBids() {
        return bids;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public float getParticipationFees() {
        return participationFees;
    }

    public Auction(String name, float participationFees) {
        this.name = name;
        this.participationFees = participationFees;
        this.itemList = new ArrayList<>();
        this.buyers = new ArrayList<>();
        this.bids = new ArrayList<>();
    }
}
