package services;

import domain.models.Auction;
import domain.models.Bid;
import domain.models.Buyer;

public interface AuctionService {

    void addBid(Auction auction, String userName, float amount);

    Buyer findWinner(Auction auction);
}
