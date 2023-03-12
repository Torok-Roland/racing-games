package org.torokrolandjanos.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileRankingRepository implements RankingsRepository {

    private String filePath = "target/rankings_" + System.currentTimeMillis();
    private BufferedWriter bufferedWriter;

    public FileRankingRepository (){
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to open file: " + filePath);
        }
    }

    @Override
    public void addRankingItem(int rank, String competitorName, double totalDistance) {
       String rankingItem = rank + ". " + competitorName + ": " + totalDistance + " km.";
        try {
            bufferedWriter.write(rankingItem);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write content to file");
        }
    }

    public void close(){
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file");
        }
    }

}
