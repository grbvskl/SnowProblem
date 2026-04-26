package controller;

import model.*;

public class LevelManager {

    public static Level getLevel(int levelNumber) {
        switch (levelNumber) {
            case 1: return level1();
            default: return null;
        }
    }

    // Level 1:
    // SS  .  .  .  .
    //  .  .  .  .  .
    //  .  .  .  .  .
    // SH  .  .  . LS

    private static Level level1() {
        Piece[] pieces = {
            new SmallSnowball(0, 0),
            new SnowmanHead(3, 0),
            new LargeSnowball(3, 4)
        };
        return new Level(1, pieces);
    }
}