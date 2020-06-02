package services;

import domain.models.Bid;
import domain.models.Buyer;
import domain.models.User;

public interface BidService {

    Bid createBid(Buyer user, float amount);
}
