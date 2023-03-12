package org.torokrolandjanos.persistence;

public interface RankingsRepository {

    void addRankingItem(int rank, String competitorName, double totalDistance);

    void close();
}

