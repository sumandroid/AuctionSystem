package strategies;

import domain.models.Auction;
import domain.models.Bid;
import utils.BidComparator;

import java.util.List;

public class ProfitCalculationStrategyImpl implements ProfitCalculationStrategy {

    private static final float PARTICIPATION_FEES_PERCENTAGE = 20f;

    @Override
    public float calculateAuctionProfit(Auction auction) {
        Bid winningBid = auction.getWinningBid();
        if(winningBid == null) throw new IllegalStateException("No winning bet present to calculate profit");
        float profitFromParticipationFees = (PARTICIPATION_FEES_PERCENTAGE / 100)
                * (auction.getParticipationFees() * auction.getBuyers().size());
        List<Bid> biddings = auction.getBids();
        if(biddings.size() == 0) throw  new IllegalStateException("no auction found to calculate profit");
        biddings.sort(new BidComparator());
        float highestAndLowestBidAverage = (biddings.get(0).getAmount() +
                biddings.get(biddings.size() - 1).getAmount()) / 2.0f;
        return winningBid.getAmount() + profitFromParticipationFees - highestAndLowestBidAverage;
    }
}
