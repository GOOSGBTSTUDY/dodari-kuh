package com.woowahan.goosgbtstudy.kuh;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class AuctionSniperEndToEndTest {
    private final FakeAuctionServer auction = new FakeAuctionServer("item=54321");
    private final ApplicationRunner application = new ApplicationRunner();

    @Test void sniperJoinsAuctionUntilActionCloses() throws Exception {
        auction.startSellingItem();
        application.startBiddingIn(auction);
        auction.hasReceivedJoinRequestFromSniper();
        auction.announceClosed();
        application.showSniperHasLostAuction();
    }

    @AfterEach void stopAuction() {
        auction.stop();
    }

    @AfterEach void stopApplication(){
        application.stop();
    }
}
