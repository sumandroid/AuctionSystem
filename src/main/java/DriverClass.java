import domain.models.Auction;
import domain.models.Buyer;
import domain.models.Seller;
import repositories.UserRepository;
import services.*;
import strategies.HighestUniqueBiddingStrategy;
import strategies.HighestUniqueBiddingStrategyImpl;
import strategies.ProfitCalculationStrategy;
import strategies.ProfitCalculationStrategyImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverClass {

    public static void main(String[] args) {
        System.out.println("*******welcome to auction system");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Enter 1 to create seller\n");
        stringBuilder.append("Enter 2 to create buyer\n");
        stringBuilder.append("Enter 3 to create auction\n");
        stringBuilder.append("Enter 4 to start bidding\n");
        System.out.println(stringBuilder.toString());
        Scanner scanner = new Scanner(System.in);
        Seller seller = null;
        List<Buyer> buyers = new ArrayList<>();
        Auction auction = null;
        BidService bidService = new BidServiceImpl();
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserServiceImpl(userRepository);
        HighestUniqueBiddingStrategy highestUniqueBiddingStrategy = new HighestUniqueBiddingStrategyImpl();
        ProfitCalculationStrategy profitCalculationStrategy = new ProfitCalculationStrategyImpl();
        AuctionService auctionService = new AuctionServiceImpl(bidService, userService, highestUniqueBiddingStrategy, profitCalculationStrategy);
        while (true) {
            System.out.println("enter choice");
            try {
                Integer choice = Integer.valueOf(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter name of seller");
                        String sellerName = scanner.nextLine();
                        seller = new Seller(sellerName);
                        userRepository.save(seller);
                        break;
                    case 2:
                        System.out.println("Enter name of buyer");
                        String buyerName = scanner.nextLine();
                        Buyer buyer = new Buyer(buyerName);
                        buyers.add(buyer);
                        userRepository.save(buyer);
                        break;
                    case 3:
                        System.out.println("Enter name of auction");
                        String auctionName = scanner.nextLine();
                        auction = new Auction(auctionName, 100f);
                        if (buyers.size() == 0) {
                            System.out.println("Create buyers");
                            break;
                        }
                        auction.getBuyers().addAll(buyers);
                        if (seller == null) throw new IllegalStateException("seller is not created");
                        seller.getAuctionList().add(auction);
                        break;
                    case 4:
                        System.out.println("start bidding, enter done to stop");
                        while (true) {
                            System.out.println("enter bid"); // input format:  bid user1 19
                            String bidString = scanner.nextLine();
                            if (bidString.equalsIgnoreCase("done")) break;
                            if (isValidBidInput(bidString)) {
                                String[] tokens = bidString.split(" ");
                                auctionService.addBid(auction, tokens[1], Float.parseFloat(tokens[2]));
                            }
                        }
                        Buyer winner = auctionService.findWinner(auction);
                        System.out.println("Winner of auction is: " + winner.getName());
                        System.out.println("profit of auctioner is: " + auction.getProfit());
                        break;
                    default:
                        System.out.println("Wrong choice");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    private static boolean isValidBidInput(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) return false;
        try {
            Float.parseFloat(tokens[2]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
