package controller;

import model.*;

public class LevelManager {

    public static Level getLevel(int levelNumber) {
        switch (levelNumber) {
            case 1: return level1();
            case 2: return level2();
            case 3: return level3();
            case 4: return level4();
            case 5: return level5();
            case 6: return level6();
            case 7: return level7();
            case 8: return level8();
            case 9: return level9();
            case 10: return level10();
            case 11: return level11();
            case 12: return level12();
            case 13: return level13();
            case 14: return level14();
            case 15: return level15();

            case 30: return level30();
            case 63: return level63();
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
                new SmallSnowball(0, 1),
                new SnowmanHead(3, 0),
                new LargeSnowball(3, 4)
        };
        return new Level(1, pieces);
    }

    // Level 2:
    //  .  .  .  .  .
    // LS  .  . HS  .
    //  . TR  .  . SS
    //  .  .  .  .  .

    private static Level level2() {
        Piece[] pieces = {
                new LargeSnowball(1, 0),
                new SnowmanHead(1, 3),
                new Tree(2, 1),
                new SmallSnowball(2, 4)
        };
        return new Level(2, pieces);
    }

    // Level 3:
    // TR  .  . LS  .
    //  .  .  . SS  .
    //  .  .  .  . SH
    //  . TR  .  .  .

    private static Level level3() {
        Piece[] pieces = {
                new Tree(0, 0),
                new LargeSnowball(0, 3),
                new SmallSnowball(1, 3),
                new SnowmanHead(2, 4),
                new Tree(3, 1)
        };
        return new Level(3, pieces);
    }

    private static Level level4() {
        Piece[] pieces = {
                new Tree(0, 0),
                new SmallSnowball(0, 4),
                new SnowmanHead(3, 0),
                new LargeSnowball(3, 4)
        };
        return new Level(4, pieces);
    }

    private static Level level5(){
        Piece[] pieces = {
                new Tree(0, 0),
                new Tree(0, 2),
                new Tree(0, 4),
                new SnowmanHead(1, 2),
                new SmallSnowball(3, 0),
                new LargeSnowball(3, 4)
        };
        return new Level(5, pieces);
    }

    private static Level level6(){
        Piece[] pieces = {
                new Tree(0, 2),
                new SnowmanHead(1, 0),
                new SmallSnowball(1, 1),
                new LargeSnowball(1, 3),
                new Tree(3, 2)
        };
        return new Level(6, pieces);
    }

    private static Level level7(){
        Piece[] pieces = {
                new Tree(1, 1),
                new Tree(1, 2),
                new SnowmanHead(2, 4),
                new SmallSnowball(3, 0),
                new LargeSnowball(3, 2)
        };
        return new Level(7, pieces);
    }

    private static Level level8(){
        Piece[] pieces = {
                new Tree(0, 1),
                new SmallSnowball(0, 2),
                new LargeSnowball(0, 4),
                new Tree(2, 4),
                new SnowmanHead(3, 2),
        };
        return new Level(8, pieces);
    }

    private static Level level9(){
        Piece[] pieces = {
                new Tree(0, 0),
                new SmallSnowball(0, 2),
                new SnowmanHead(1, 3),
                new LargeSnowball(3, 1),
                new Tree(3, 4)
        };
        return new Level(9, pieces);
    }

    private static Level level10(){
        Piece[] pieces = {
                new Tree(0, 0),
                new Tree(0, 2),
                new Tree(1, 1),
                new SnowmanHead(2, 3),
                new SmallSnowball(3, 1),
                new LargeSnowball(3, 4),
        };
        return new Level(10, pieces);
    }

    private static Level level11(){
        Piece[] pieces = {
                new Tree(0, 0),
                new Tree(0, 1),
                new SnowmanHead(0, 3),
                new SmallSnowball(2, 0),
                new Tree(2, 4),
                new LargeSnowball(3, 0),
        };
        return new Level(11, pieces);
    }

    private static Level level12(){
        Piece[] pieces = {
                new Tree(0, 0),
                new LargeSnowball(0, 1),
                new Tree(0, 4),
                new SnowmanHead(2, 1),
                new SmallSnowball(2, 3),
        };
        return new Level(12, pieces);
    }

    private static Level level13(){
        Piece[] pieces = {
                new Tree(0, 0),
                new SmallSnowball(0, 2),
                new SnowmanHead(1, 4),
                new Tree(2, 1),
                new LargeSnowball(3, 4),
        };
        return new Level(13, pieces);
    }

    private static Level level14(){
        Piece[] pieces = {
                new Tree(0, 1),
                new Tree(1, 3),
                new SmallSnowball(2, 0),
                new SnowmanHead(3, 2),
                new LargeSnowball(3, 4)
        };
        return new Level(14, pieces);
    }

    private static Level level15(){
        Piece[] pieces = {
                new Tree(0, 0),
                new Tree(0, 1),
                new SmallSnowball(0, 4),
                new SnowmanHead(1, 4),
                new LargeSnowball(2, 0),
                new Tree(3, 3)
        };
        return new Level(15, pieces);
    }

    // Level 30:
    // SH  . TR  . SS
    // LS  .  .  .  .
    //  .  .  . SS  .
    // SH LS TR  .  .

    private static Level level30() {
        Piece[] pieces = {
                new SnowmanHead(0, 0),
                new Tree(0, 2),
                new SmallSnowball(0, 4),
                new LargeSnowball(1, 0),
                new SmallSnowball(2, 3),
                new SnowmanHead(3, 0),
                new LargeSnowball(3, 1),
                new Tree(3, 2)
        };
        return new Level(30, pieces);
    }

    // Level 63:
    //  .  . LS  . SS
    //  .  . TR  . SS
    // SH  . SH  . SH
    // SS  . LS  . LS

    private static Level level63() {
        Piece[] pieces = {
                new LargeSnowball(0, 2),
                new SmallSnowball(0, 4),
                new Tree(1, 2),
                new SmallSnowball(1, 4),
                new SnowmanHead(2, 0),
                new SnowmanHead(2, 2),
                new SnowmanHead(2, 4),
                new SmallSnowball(3, 0),
                new LargeSnowball(3, 2),
                new LargeSnowball(3, 4)
        };
        return new Level(63, pieces);
    }
}