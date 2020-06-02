# AuctionSystem
A java based auction system developed using design patterns and SOLID principle

Problem statement was to design an auction system Foobar where there’ll be sellers who can create auction for item they want to sell. They’ll be specifying lowest and highest bid that can be placed and there will be a participation charge applicable on buyers who’ll be bidding for this auction. System should be able to handle multiple auctions at a time. Seller’s profit/loss will be calculated as : WinningBid + 20% of totalParticipationCostByBuyers – averageOfLowestAndHighestBid. Remaining 80% of participation cost goes to foobar as commission. Winning bid will be highest unique bid. If for a particular auction these are the bids – buyer1 19, buyer2 19, buyer3 17, buyer4 17, buyer5 10 : then buyer5 will be the winner

It is currently implemented as commandLine application but since concerns are separated and the app is extendible it can easily be integrated as an API using Spring Boot.
