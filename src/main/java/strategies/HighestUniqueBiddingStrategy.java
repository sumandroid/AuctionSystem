package strategies;

import domain.models.Auction;
import domain.models.Bid;

public interface HighestUniqueBiddingStrategy {

    Bid findHighestUniqueBidder(Auction auction);
}
