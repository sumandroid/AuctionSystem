package strategies;

import domain.models.Auction;
import domain.models.Bid;
import domain.models.Buyer;
import utils.BidComparator;

import java.util.*;

public class HighestUniqueBiddingStrategyImpl implements HighestUniqueBiddingStrategy {

    @Override
    public Bid findHighestUniqueBidder(Auction auction) throws RuntimeException {
        List<Bid> biddings = auction.getBids();
        if (biddings.size() == 0) throw new IllegalStateException("No biddings found");
        biddings.sort(new BidComparator());
        Bid highestBid = null;
        float highestBidAmount = Float.MIN_VALUE;
        Set<Float> seenAmounts = new HashSet<>();
        for (Bid bid : biddings) {
            if (!seenAmounts.contains(bid.getAmount())) {
                if(bid.getAmount() > highestBidAmount){
                    highestBid = bid;
                    highestBidAmount = bid.getAmount();
                    seenAmounts.add(bid.getAmount());
                }
            } else {
                if(highestBidAmount == bid.getAmount()){
                    highestBidAmount = Float.MIN_VALUE;
                    highestBid = null;
                }
            }
        }
        return highestBid;
    }

}
