public class PokerCompare {
    public static String CheckWinner(String Black, String White) {
        //判断输赢，先得到牌的类型然后比较牌的大小，再比较同样类型牌的大小
        int black = PokerCheck.CheckPokerType(Black), white = PokerCheck.CheckPokerType(White);
        if (black > white)
            return "Black wins";
        else if (black < white)
            return "White wins";
            //以下判断牌是同一种类型的时候的大小对比
        else {
            return PokerCheck.SamePoker(black,white,Black,White);
        }
    }
}
