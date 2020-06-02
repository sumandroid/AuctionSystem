package services;

import domain.models.Auction;
import domain.models.Bid;
import domain.models.Buyer;
import domain.models.User;
import strategies.HighestUniqueBiddingStrategy;
import strategies.ProfitCalculationStrategy;

public class AuctionServiceImpl implements AuctionService {

    private BidService bidService;
    private UserService userService;
    private HighestUniqueBiddingStrategy highestUniqueBiddingStrategy;
    private ProfitCalculationStrategy profitCalculationStrategy;

    public AuctionServiceImpl(BidService bidService, UserService userService,
                              HighestUniqueBiddingStrategy highestUniqueBiddingStrategy,
                              ProfitCalculationStrategy profitCalculationStrategy) {
        this.bidService = bidService;
        this.userService = userService;
        this.highestUniqueBiddingStrategy = highestUniqueBiddingStrategy;
        this.profitCalculationStrategy = profitCalculationStrategy;
    }

    @Override
    public void addBid(Auction auction, String userName, float amount) {
        Buyer buyer = (Buyer) userService.findByName(userName);
        Bid bid = bidService.createBid(buyer, amount);
        auction.getBids().add(bid);
    }

    @Override
    public Buyer findWinner(Auction auction) {
        Bid highestUniqueBid = highestUniqueBiddingStrategy.findHighestUniqueBidder(auction);
        auction.setWinningBid(highestUniqueBid);
        calculateProfit(auction);
        return highestUniqueBid.getBidder();
    }


    private void calculateProfit(Auction auction){
        float profit = profitCalculationStrategy.calculateAuctionProfit(auction);
        auction.setProfit(profit);
    }
}
