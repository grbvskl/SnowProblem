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
            case 16: return level16();
            case 17: return level17();
            case 18: return level18();
            case 19: return level19();
            case 20: return level20();
            case 21: return level21();
            case 22: return level22();
            case 23: return level23();
            case 24: return level24();
            case 25: return level25();
            case 26: return level26();
            case 27: return level27();
            case 28: return level28();
            case 29: return level29();
            case 30: return level30();
            case 31: return level31();
            case 32: return level32();
            case 33: return level33();
            case 34: return level34();
            case 35: return level35();
            case 36: return level36();
            case 37: return level37();
            case 38: return level38();
            case 39: return level39();
            case 40: return level40();
            case 41: return level41();
            case 42: return level42();
            case 43: return level43();
            case 44: return level44();
            case 45: return level45();
            case 46: return level46();
            case 47: return level47();
            case 48: return level48();
            case 49: return level49();
            case 50: return level50();
            case 51: return level51();
            case 52: return level52();
            case 53: return level53();
            case 54: return level54();
            case 55: return level55();
            case 56: return level56();
            case 57: return level57();
            case 58: return level58();
            case 59: return level59();
            case 60: return level60();
            case 61: return level61();
            case 62: return level62();
            case 63: return level63();
            case 64: return level64();
            case 65: return level65();
            case 66: return level66();
            case 67: return level67();
            case 68: return level68();
            case 69: return level69();
            case 70: return level70();
            case 71: return level71();
            case 72: return level72();
            case 73: return level73();
            case 74: return level74();
            case 75: return level75();
            case 76: return level76();
            case 77: return level77();
            case 78: return level78();
            case 79: return level79();
            case 80: return level80();
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
                new SmallSnowball(0, 3),
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
                new Tree(3, 2)
        };
        return new Level(15, pieces);
    }

    private static Level level16(){
        Piece[] pieces = {
                new Tree(0, 0),
                new Tree(0, 1),
                new SnowmanHead(1, 4),
                new SmallSnowball(2, 0),
                new LargeSnowball(3, 0),
                new Tree(3, 1)
        };
        return new Level(16, pieces);
    }

    private static Level level17(){
        Piece[] pieces = {
                new Tree(0, 1),
                new Tree(1, 4),
                new Tree(2, 0),
                new SmallSnowball(2, 3),
                new SmallSnowball(3, 3),
                new SnowmanHead(3, 3),
                new LargeSnowball(3, 4)
        };
        return new Level(17, pieces);
    }

    private static Level level18(){
        Piece[] pieces = {
                new Tree(0, 2),
                new SmallSnowball(0, 3),
                new LargeSnowball(0, 4),
                new Tree(1, 0),
                new Tree(2, 3),
                new SnowmanHead(3, 1),
        };
        return new Level(18, pieces);
    }

    private static Level level19(){
        Piece[] pieces = {
                new Tree(0, 2),
                new SmallSnowball(0, 4),
                new Tree(1, 0),
                new Tree(1, 4),
                new SnowmanHead(2, 1),
                new LargeSnowball(3, 3)
        };
        return new Level(19, pieces);
    }

    private static Level level20(){
        Piece[] pieces = {
                new Tree(0, 1),
                new SnowmanHead(1, 3),
                new LargeSnowball(2, 0),
                new Tree(3, 2),
                new SmallSnowball(3, 4)
        };
        return new Level(20, pieces);
    }

    private static Level level21(){
        Piece[] pieces = {
                new SnowmanHead(0, 3),
                new Tree(1, 0),
                new Tree(2, 4),
                new SmallSnowball(3, 0),
                new LargeSnowball(3, 2)
        };
        return new Level(21, pieces);
    }

    private static Level level22(){
        Piece[] pieces = {
                new Tree(0, 1),
                new SmallSnowball(0, 3),
                new Tree(1, 0),
                new SnowmanHead(2, 0),
                new Tree(3, 2),
                new LargeSnowball(3, 4)
        };
        return new Level(22, pieces);
    }

    private static Level level23(){
        Piece[] pieces = {
                new Tree(0,2),
                new Tree(1,0),
                new SnowmanHead(1, 4),
                new Tree(2, 1),
                new LargeSnowball(3,0),
                new SmallSnowball(3,4)
        };
        return new Level(23, pieces);
    }

    private static Level level24(){
        Piece[] pieces = {
                new SnowmanHead(0, 2),
                new Tree(1, 0),
                new Tree(1, 4),
                new Tree(2, 1),
                new SmallSnowball(3, 1),
                new LargeSnowball(3, 4)
        };
        return new Level(24, pieces);
    }

    private static Level level25(){
        Piece[] pieces = {
                new Tree(0, 0),
                new Tree(0, 2),
                new SmallSnowball(0, 4),
                new SnowmanHead(2, 3),
                new LargeSnowball(3, 0),
                new Tree(3, 1)
        };
        return new Level(25, pieces);
    }

    private static Level level26(){
        Piece[] pieces = {
                new Tree(0, 0),
                new LargeSnowball(0, 2),
                new Tree(1, 4),
                new Tree(2, 0),
                new SmallSnowball(3, 0),
                new SnowmanHead(3, 3)
        };
        return new Level(26, pieces);
    }

    private static Level level27(){
        Piece[] pieces = {
                new Tree(0, 1),
                new SmallSnowball(0, 4),
                new Tree(1, 4),
                new SnowmanHead(2, 0),
                new Tree(3, 2),
                new LargeSnowball(3, 3)
        };
        return new Level(27, pieces);
    }

    private static Level level28(){
        Piece[] pieces = {
                new Tree(0, 0),
                new Tree(1, 4),
                new SmallSnowball(2, 0),
                new LargeSnowball(3, 0),
                new SnowmanHead(3, 3)
        };
        return new Level(28, pieces);
    }

    private static Level level29(){
        Piece[] pieces = {
                new SnowmanHead(1, 1),
                new SnowmanHead(1, 3),
                new LargeSnowball(2, 0),
                new SmallSnowball(2, 1),
                new SmallSnowball(2, 3),
                new LargeSnowball(2, 4)
        };
        return new Level(29, pieces);
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

    private static Level level31(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SnowmanHead(0, 2),
                new LargeSnowball(0, 4),
                new Tree(1, 0),
                new SnowmanHead(1, 2),
                new SmallSnowball(2, 4),
                new SmallSnowball(3, 2)
        };
        return new Level(31, pieces);
    }

    private static Level level32(){
        Piece[] pieces = {
                new SnowmanHead(0, 2),
                new LargeSnowball(0, 4),
                new Tree(1, 1),
                new SnowmanHead(1, 3),
                new Tree(2, 2),
                new SmallSnowball(3, 0),
                new LargeSnowball(3, 2),
                new SmallSnowball(3, 4)
        };
        return new Level(32, pieces);
    }

    private static Level level33(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SmallSnowball(0, 4),
                new SnowmanHead(1, 0),
                new SnowmanHead(1, 2),
                new SmallSnowball(3, 2),
                new LargeSnowball(3, 4)
        };
        return new Level(33, pieces);
    }

    private static Level level34(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SnowmanHead(0, 2),
                new SmallSnowball(0, 3),
                new LargeSnowball(0, 4),
                new Tree(1, 0),
                new Tree(2, 0),
                new SnowmanHead(2, 3),
                new SmallSnowball(3, 3)
        };
        return new Level(34, pieces);
    }

    private static Level level35(){
        Piece[] pieces = {
                new Tree(0, 0),
                new Tree(0, 2),
                new LargeSnowball(0, 3),
                new SnowmanHead(0, 4),
                new SmallSnowball(2, 4),
                new LargeSnowball(3, 0),
                new SmallSnowball(3, 1),
                new SnowmanHead(3, 3)
        };
        return new Level(35, pieces);
    }

    private static Level level36(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SnowmanHead(0, 2),
                new SmallSnowball(0, 4),
                new SnowmanHead(1, 0),
                new Tree(1, 1),
                new Tree(2, 2),
                new LargeSnowball(3, 0),
                new SmallSnowball(3, 4)
        };
        return new Level(36, pieces);
    }

    private static Level level37(){
        Piece[] pieces = {
                new SnowmanHead(0, 0),
                new LargeSnowball(0, 2),
                new SmallSnowball(0, 4),
                new Tree(1, 1),
                new SnowmanHead(1, 3),
                new Tree(2, 3),
                new LargeSnowball(3, 0),
                new SmallSnowball(3, 2)
        };
        return new Level(37, pieces);
    }

    private static Level level38(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new LargeSnowball(0, 1),
                new SmallSnowball(0, 3),
                new Tree(1, 0),
                new SnowmanHead(1, 1),
                new SnowmanHead(1, 3),
                new Tree(1, 4),
                new SmallSnowball(3, 2)
        };
        return new Level(38, pieces);
    }

    private static Level level39(){
        Piece[] pieces = {
                new SnowmanHead(0, 0),
                new LargeSnowball(0, 3),
                new SmallSnowball(1, 0),
                new Tree(1, 2),
                new SmallSnowball(2, 4),
                new LargeSnowball(3, 0),
                new SnowmanHead(3, 2)
        };
        return new Level(39, pieces);
    }

    private static Level level40(){
        Piece[] pieces = {
                new Tree(0, 0),
                new SnowmanHead(0, 1),
                new LargeSnowball(0 ,3),
                new SmallSnowball(0, 4),
                new SnowmanHead(1, 0),
                new SmallSnowball(1, 2),
                new LargeSnowball(3, 0),
                new Tree(3, 3)
        };
        return new Level(40, pieces);
    }

    private static Level level41(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SmallSnowball(0, 4),
                new SnowmanHead(1, 2),
                new SmallSnowball(2, 0),
                new SnowmanHead(2, 2),
                new LargeSnowball(3, 0)
        };
        return new Level(41, pieces);
    }

    private static Level level42(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SmallSnowball(0, 4),
                new SnowmanHead(1, 1),
                new LargeSnowball(2, 0),
                new SnowmanHead(2, 2),
                new SmallSnowball(2, 4)
        };
        return new Level(42, pieces);
    }

    private static Level level43(){
        Piece[] pieces = {
                new SmallSnowball(0, 0),
                new SnowmanHead(0, 1),
                new Tree(0, 2),
                new SmallSnowball(0, 4),
                new LargeSnowball(3, 0),
                new SnowmanHead(3, 2),
                new LargeSnowball(3, 4)
        };
        return new Level(43, pieces);
    }

    private static Level level44(){
        Piece[] pieces = {
                new LargeSnowball(0, 4),
                new Tree(1, 1),
                new SnowmanHead(1, 2),
                new Tree(1, 3),
                new SnowmanHead(2, 2),
                new SmallSnowball(3, 0),
                new LargeSnowball(3, 3),
                new SmallSnowball(3, 4)
        };
        return new Level(44, pieces);
    }

    private static Level level45(){
        Piece[] pieces = {
                new Tree(0, 1),
                new SmallSnowball(1, 0),
                new SmallSnowball(1, 2),
                new SnowmanHead(1, 4),
                new SnowmanHead(2, 1),
                new Tree(2, 3),
                new LargeSnowball(3, 0),
                new LargeSnowball(3, 4)
        };
        return new Level(45, pieces);
    }

    private static Level level46(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SmallSnowball(0, 1),
                new Tree(0, 2),
                new LargeSnowball(0, 3),
                new SnowmanHead(0, 4),
                new Tree(2, 0),
                new SnowmanHead(2, 1),
                new SmallSnowball(2, 4)
        };
        return new Level(46, pieces);
    }

    private static Level level47(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SnowmanHead(0, 2),
                new SmallSnowball(0, 4),
                new Tree(1, 1),
                new Tree(1, 3),
                new SmallSnowball(1, 4),
                new SnowmanHead(3, 0),
                new LargeSnowball(3, 4)
        };
        return new Level(47, pieces);
    }

    private static Level level48(){
        Piece[] pieces = {
                new Tree(0, 1),
                new LargeSnowball(0, 4),
                new SmallSnowball(1, 1),
                new Tree(1, 4),
                new SnowmanHead(3, 1),
                new SmallSnowball(3, 2),
                new SnowmanHead(3, 3),
                new LargeSnowball(3, 4)
        };
        return new Level(48, pieces);
    }

    private static Level level49(){
        Piece[] pieces = {
                new SmallSnowball(0, 0),
                new SmallSnowball(0, 1),
                new SmallSnowball(0, 2),
                new LargeSnowball(0, 3),
                new Tree(1, 0),
                new SnowmanHead(1, 2),
                new Tree(1, 3),
                new LargeSnowball(2, 1),
                new SnowmanHead(2, 2),
                new SnowmanHead(3, 2),
                new LargeSnowball(3, 4)
        };
        return new Level(49, pieces);
    }

    private static Level level50(){
        Piece[] pieces = {
                new SnowmanHead(0, 0),
                new LargeSnowball(0, 1),
                new SmallSnowball(0, 2),
                new SmallSnowball(0, 4),
                new Tree(1, 2),
                new SnowmanHead(1, 4),
                new LargeSnowball(2, 0),
                new Tree(2, 2),
                new SnowmanHead(3, 1),
                new SmallSnowball(3, 2),
                new LargeSnowball(3, 4)
        };
        return new Level(50, pieces);
    }

    private static Level level51(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new LargeSnowball(0, 1),
                new SnowmanHead(0, 3),
                new Tree(1, 0),
                new SnowmanHead(1, 4),
                new LargeSnowball(2, 0),
                new Tree(2, 2),
                new SmallSnowball(3, 0),
                new SmallSnowball(3, 1),
                new SmallSnowball(3, 2),
                new SnowmanHead(3, 3),
        };
        return new Level(51, pieces);
    }

    private static Level level52(){
        Piece[] pieces = {
                new Tree(0, 0),
                new LargeSnowball(0, 1),
                new LargeSnowball(0, 4),
                new SmallSnowball(1, 3),
                new SnowmanHead(1, 4),
                new SmallSnowball(2, 0),
                new SnowmanHead(2, 3),
                new LargeSnowball(2, 4),
                new SmallSnowball(3, 1),
                new SnowmanHead(3, 2)
        };
        return new Level(52, pieces);
    }

    private static Level level53(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new Tree(0, 2),
                new SnowmanHead(1, 1),
                new SnowmanHead(1, 3),
                new Tree(2, 0),
                new SmallSnowball(3, 0),
                new SmallSnowball(3, 1),
                new LargeSnowball(3, 4)
        };
        return new Level(53, pieces);
    }

    private static Level level54(){
        Piece[] pieces = {
                new LargeSnowball(0, 2),
                new Tree(1, 1),
                new SnowmanHead(1, 4),
                new Tree(2, 1),
                new SnowmanHead(2, 4),
                new SmallSnowball(3, 0),
                new SmallSnowball(3, 1),
                new LargeSnowball(3, 4),
        };
        return new Level(54, pieces);
    }

    private static Level level55(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new Tree(0, 1),
                new SnowmanHead(0, 2),
                new SnowmanHead(0, 3),
                new LargeSnowball(0, 4),
                new SmallSnowball(3, 0),
                new Tree(3, 3),
                new SmallSnowball(3, 4)
        };
        return new Level(55, pieces);
    }

    private static Level level56(){
        Piece[] pieces = {
                new Tree(0, 1),
                new Tree(0, 3),
                new SmallSnowball(0, 4),
                new SmallSnowball(2, 0),
                new SnowmanHead(2, 2),
                new LargeSnowball(2, 4),
                new SnowmanHead(3, 1),
                new LargeSnowball(3, 3)
        };
        return new Level(56, pieces);
    }

    private static Level level57(){
        Piece[] pieces = {
                new Tree(0, 2),
                new Tree(1, 0),
                new SmallSnowball(1, 2),
                new SnowmanHead(1, 3),
                new SmallSnowball(2, 1),
                new SnowmanHead(2, 4),
                new  LargeSnowball(3, 0),
                new LargeSnowball(3, 4)
        };
        return new Level(57, pieces);
    }

    private static Level level58(){
        Piece[] pieces = {
                new Tree(0, 0),
                new SmallSnowball(0, 1),
                new SnowmanHead(1, 4),
                new Tree(2, 0),
                new LargeSnowball(2, 2),
                new LargeSnowball(3, 0),
                new SnowmanHead(3, 3),
                new SmallSnowball(3, 4)
        };
        return new Level(58, pieces);
    }

    private static Level level59(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new LargeSnowball(0, 3),
                new Tree(1, 1),
                new SnowmanHead(1, 4),
                new SnowmanHead(2, 0),
                new Tree(2, 3),
                new SmallSnowball(3, 1),
                new SmallSnowball(3, 4)
        };
        return new Level(59, pieces);
    }

    private static Level level60(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SmallSnowball(0, 1),
                new SnowmanHead(0, 4),
                new Tree(1, 1),
                new Tree(1, 2),
                new SnowmanHead(2, 0),
                new SmallSnowball(3, 1),
                new LargeSnowball(3, 4)
        };
        return new Level(60, pieces);
    }

    private static Level level61(){
        Piece[] pieces = {
                new SnowmanHead(0, 0),
                new SnowmanHead(0, 2),
                new SmallSnowball(0, 4),
                new SnowmanHead(1, 1),
                new LargeSnowball(1, 3),
                new Tree(1, 4),
                new LargeSnowball(2, 0),
                new SmallSnowball(2, 1),
                new SmallSnowball(2, 2),
                new LargeSnowball(3, 3)
        };
        return new Level(61, pieces);
    }

    private static Level level62(){
        Piece[] pieces = {
                new SmallSnowball(0, 0),
                new SmallSnowball(0, 1),
                new SmallSnowball(0, 2),
                new SnowmanHead(0, 3),
                new Tree(1, 1),
                new LargeSnowball(1, 2),
                new LargeSnowball(1, 3),
                new SnowmanHead(1, 4),
                new SnowmanHead(3, 3),
                new LargeSnowball(3, 4)
        };
        return new Level(62, pieces);
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

    private static Level level64(){
        Piece[] pieces = {
                new SmallSnowball(0, 0),
                new SnowmanHead(0, 2),
                new Tree(1, 0),
                new SnowmanHead(1, 1),
                new SnowmanHead(1, 3),
                new LargeSnowball(1, 4),
                new SmallSnowball(2, 3),
                new Tree(2, 4),
                new LargeSnowball(3, 0),
                new LargeSnowball(3, 1),
                new SmallSnowball(3, 4)
        };
        return new Level(64, pieces);
    }

    private static Level level65(){
        Piece[] pieces = {
                new SnowmanHead(0, 1),
                new SnowmanHead(0, 3),
                new Tree(1, 0),
                new SmallSnowball(1, 1),
                new LargeSnowball(1, 2),
                new SmallSnowball(2, 2),
                new Tree(2, 4),
                new LargeSnowball(3, 2)
        };
        return new Level(65, pieces);
    }

    private static Level level66(){
        Piece[] pieces = {
                new SnowmanHead(0, 1),
                new LargeSnowball(0, 4),
                new SmallSnowball(2, 0),
                new SnowmanHead(3, 2),
                new SmallSnowball(3, 3),
                new LargeSnowball(3, 4)
        };
        return new Level(66, pieces);
    }

    private static Level level67(){
        Piece[] pieces = {
                new LargeSnowball(0, 1),
                new LargeSnowball(0, 4),
                new Tree(1, 0),
                new SmallSnowball(1, 4),
                new SnowmanHead(2, 0),
                new SnowmanHead(3, 2),
                new SmallSnowball(3, 3)
        };
        return new Level(67, pieces);
    }

    private static Level level68(){
        Piece[] pieces = {
                new Tree(0, 0),
                new SnowmanHead(0, 2),
                new SmallSnowball(0, 3),
                new SmallSnowball(1, 0),
                new Tree(1, 1),
                new LargeSnowball(2, 4),
                new LargeSnowball(3, 0),
                new SnowmanHead(3, 2)
        };
        return new Level(68, pieces);
    }

    private static Level level69(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SnowmanHead(0, 2),
                new SnowmanHead(0, 3),
                new LargeSnowball(0, 4),
                new SmallSnowball(1, 0),
                new Tree(1, 1),
                new Tree(2, 3),
                new SnowmanHead(2, 4),
                new LargeSnowball(3, 0),
                new SmallSnowball(3, 3),
                new SmallSnowball(3, 4)
        };
        return new Level(69, pieces);
    }

    private static Level level70(){
        Piece[] pieces = {
                new Tree(0, 1),
                new SmallSnowball(0, 2),
                new SmallSnowball(0, 3),
                new Tree(1, 1),
                new SmallSnowball(1, 3),
                new LargeSnowball(1, 4),
                new SnowmanHead(2, 0),
                new LargeSnowball(2, 1),
                new SnowmanHead(3, 0),
                new LargeSnowball(3, 2),
                new SnowmanHead(3, 3)
        };
        return new Level(70, pieces);
    }

    private static Level level71(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new Tree(0, 2),
                new SmallSnowball(0, 4),
                new SnowmanHead(1, 0),
                new Tree(1, 2),
                new SmallSnowball(1, 4),
                new SnowmanHead(2, 0),
                new LargeSnowball(2, 1),
                new SmallSnowball(2, 2),
                new LargeSnowball(3, 0),
                new SnowmanHead(3, 4)
        };
        return new Level(71, pieces);
    }

    private static Level level72(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new LargeSnowball(0, 1),
                new LargeSnowball(0, 3),
                new SmallSnowball(0, 4),
                new Tree(1, 0),
                new SnowmanHead(1, 1),
                new SnowmanHead(2, 0),
                new SnowmanHead(2, 1),
                new SmallSnowball(3, 2),
                new SmallSnowball(3, 4)
        };
        return new Level(72, pieces);
    }

    private static Level level73(){
        Piece[] pieces = {
                new SnowmanHead(0, 1),
                new SmallSnowball(0, 4),
                new LargeSnowball(2, 0),
                new SmallSnowball(2, 4),
                new SnowmanHead(3, 3),
                new LargeSnowball(3, 4)
        };
        return new Level(73, pieces);
    }

    private static Level level74(){
        Piece[] pieces = {
                new Tree(0, 0),
                new LargeSnowball(0, 1),
                new LargeSnowball(0, 2),
                new SmallSnowball(1, 1),
                new SmallSnowball(1, 2),
                new SnowmanHead(1, 4),
                new SnowmanHead(2, 0),
                new Tree(3, 3)
        };
        return new Level(74, pieces);
    }

    private static Level level75(){
        Piece[] pieces = {
                new SmallSnowball(0, 0),
                new Tree(0, 1),
                new SnowmanHead(1, 4),
                new SmallSnowball(2, 0),
                new SnowmanHead(2, 4),
                new LargeSnowball(3, 0),
                new Tree(3, 1),
                new LargeSnowball(3, 4)
        };
        return new Level(75, pieces);
    }

    private static Level level76(){
        Piece[] pieces = {
                new LargeSnowball(0, 0),
                new SnowmanHead(0, 3),
                new SmallSnowball(0, 4),
                new Tree(1, 0),
                new LargeSnowball(1, 2),
                new SnowmanHead(2, 4),
                new SmallSnowball(3, 1)
        };
        return new Level(76, pieces);
    }

    private static Level level77(){
        Piece[] pieces = {
                new Tree(0, 0),
                new SmallSnowball(0, 1),
                new LargeSnowball(0, 3),
                new SnowmanHead(1, 0),
                new SmallSnowball(1, 4),
                new Tree(2, 2),
                new SmallSnowball(2, 3),
                new LargeSnowball(2, 4),
                new SnowmanHead(3, 1),
                new SnowmanHead(3, 3),
                new LargeSnowball(3, 4)
        };
        return new Level(77, pieces);
    }

    private static Level level78(){
        Piece[] pieces = {
                new SnowmanHead(0, 1),
                new SnowmanHead(0, 2),
                new SnowmanHead(0, 3),
                new LargeSnowball(0, 4),
                new SmallSnowball(2, 0),
                new LargeSnowball(2, 4),
                new SmallSnowball(3, 0),
                new SmallSnowball(3, 1),
                new LargeSnowball(3, 2)
        };
        return new Level(78, pieces);
    }

    private static Level level79(){
        Piece[] pieces = {
                new Tree(0, 0),
                new LargeSnowball(0, 2),
                new Tree(0, 4),
                new SnowmanHead(1, 0),
                new SnowmanHead(1, 1),
                new SmallSnowball(1, 2),
                new SnowmanHead(2, 0),
                new LargeSnowball(2, 1),
                new SmallSnowball(2, 2),
                new SmallSnowball(3, 2),
                new LargeSnowball(3, 4)
        };
        return new Level(79, pieces);
    }

    private static Level level80() {
        Piece[] pieces = {
                new SmallSnowball(0, 0),
                new Tree(0, 1),
                new SnowmanHead(0, 3),
                new LargeSnowball(1, 1),
                new LargeSnowball(1, 2),
                new SmallSnowball(1, 3),
                new LargeSnowball(1, 4),
                new Tree(2, 0),
                new SmallSnowball(2, 3),
                new SnowmanHead(3, 3),
                new SnowmanHead(3, 4)
        };
        return new Level(80, pieces);
    }
}