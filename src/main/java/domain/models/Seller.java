package domain.models;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User{

    private List<Auction> auctionList;

    public Seller(String name) {
        super(name);
        this.auctionList = new ArrayList<>();
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }
}
