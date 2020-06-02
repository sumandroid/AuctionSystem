package utils;

import domain.models.Bid;

import java.util.Comparator;

public class BidComparator implements Comparator<Bid> {

    @Override
    public int compare(Bid o1, Bid o2) {
        return Float.compare(o2.getAmount(), o1.getAmount());
    }
}
