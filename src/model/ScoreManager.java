package model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ScoreManager {
    private static final String FILE_PATH = "scores.txt";
    private Map<Integer, Integer> bestScores;

    public ScoreManager() {
        bestScores = new HashMap<>();
        load();
    }

    public void submitScore(int level, int moves) {
        if (!bestScores.containsKey(level) || moves < bestScores.get(level)) {
            bestScores.put(level, moves);
            save();
        }
    }

    public int getBestScore(int level) {
        return bestScores.getOrDefault(level, -1);
    }

    private void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                bestScores.put(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
        }
    }

    private void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<Integer, Integer> entry : bestScores.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Could not save scores: " + e.getMessage());
        }
    }
}