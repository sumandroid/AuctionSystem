package services;

import domain.models.Bid;
import domain.models.Buyer;
import domain.models.User;

public class BidServiceImpl implements BidService {

    @Override
    public Bid createBid(Buyer buyer, float amount) {
        return new Bid(amount, buyer);
    }
}
