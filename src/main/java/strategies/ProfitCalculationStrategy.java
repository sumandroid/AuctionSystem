package strategies;

import domain.models.Auction;

public interface ProfitCalculationStrategy {

    float calculateAuctionProfit(Auction auction);

}
