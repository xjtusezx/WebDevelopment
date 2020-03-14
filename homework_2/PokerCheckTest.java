import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
class PokerTest {
    private static PokerCompare pk = new PokerCompare();
    @BeforeEach
    void setUp() {
        System.out.println("测试开始");
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试结束");
    }

    @Test
    void checkWinner() {
        assertEquals("White wins", PokerCompare.CheckWinner("2H 3D 5S 9C KD", "2C 3H 4S 8C AH"));
        assertEquals("Black wins", PokerCompare.CheckWinner("2H 4S 4C 2D 4H", "2S 8S AS QS 3S"));
        assertEquals("Black wins", PokerCompare.CheckWinner("2H 3D 5S 9C KD", "2C 3H 4S 8C KH"));
        assertEquals("Tie", PokerCompare.CheckWinner("2H 3D 5S 9C KD", "2D 3H 5C 9S KH"));
        assertEquals("Tie", PokerCompare.CheckWinner("5H 6D 7S 8C 9D", "5D 6H 7C 8S 9H"));
    }
}
class PokerCheckTest {
    PokerCheck check = new PokerCheck();
    @BeforeEach
    void setUp() {
        System.out.println("测试开始");
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试结束");
    }
    @Test
    void checkPokerType() {
        assertEquals(0, PokerCheck.CheckPokerType("2H 3D 5S 9C KD"));
        assertEquals(1, PokerCheck.CheckPokerType("2H 2D 5S 9C KD"));
        assertEquals(2, PokerCheck.CheckPokerType("2H 2D 5S 9C 5D"));
        assertEquals(3, PokerCheck.CheckPokerType("2H 2D 2S 9C KD"));
        assertEquals(4, PokerCheck.CheckPokerType("2H 3D 5S 6C 4D"));
        assertEquals(5, PokerCheck.CheckPokerType("2D 3D 5D 9D KD"));
        assertEquals(6, PokerCheck.CheckPokerType("2H 3D 2S 3C 3D"));
        assertEquals(7, PokerCheck.CheckPokerType("2H 2D 2S 2C KD"));
        assertEquals(8, PokerCheck.CheckPokerType("2D 3D 5D 4D 6D"));
    }

    @Test
    void samePoker() {
        assertEquals("Black wins", PokerCheck.SamePoker(0,0,"2C 3S 5H 4K 6D","3C 4S 5C 4S 6K"));
        assertEquals("Black wins", PokerCheck.SamePoker(1,0,"2C 3S 5H 4K 6D","3C 4S 5C 4S 6K"));
        assertEquals("White wins", PokerCheck.SamePoker(2,0,"3C 3S 3H 3K 3D","4C 5S 6C 7S 8K"));
        assertEquals("White wins", PokerCheck.SamePoker(3,0,"2C 3C 5C 4C 6C","JC KS AC QS 6K"));
        assertEquals("Black wins", PokerCheck.SamePoker(4,0,"2S 3S 5S 4S 6C","3C 4S 5C 4S 6K"));
    }
    @Test//利用反射来测试私有方法连子
    public void testCheckStraight() throws Exception
    {
        Class<PokerCheck> class1 = PokerCheck.class;
        Object instance = class1.newInstance();
        Method method = class1.getDeclaredMethod("CheckStraight", new Class[]{String.class});
        method.setAccessible(true);
        Object test1 = method.invoke(instance, new Object[]{"3D 4H 5C 6S 7D"});
        Object test2 = method.invoke(instance, new Object[]{"4S 5D 6C 7S 8D"});
        Object test3 = method.invoke(instance, new Object[]{"7D 9H TC JS QD"});
        Object test4 = method.invoke(instance, new Object[]{"9D JH QC KS AD"});
        assertEquals(true,test1);
        assertEquals(true,test2);
        assertEquals(false,test3);
        assertEquals(false,test4);
    }
    @Test//利用反射来测试私有方法顺子
    public void testFlush() throws Exception
    {
        Class<PokerCheck> class1 = PokerCheck.class;
        Object instance = class1.newInstance();
        Method method = class1.getDeclaredMethod("CheckFlush", new Class[]{String.class});
        method.setAccessible(true);
        Object test1 = method.invoke(instance, new Object[]{"3D 4H 5C 6S 7D"});
        Object test2 = method.invoke(instance, new Object[]{"4S 5D 6C 7S 8D"});
        Object test3 = method.invoke(instance, new Object[]{"7D 9D TD JD QD"});
        Object test4 = method.invoke(instance, new Object[]{"9H JH QH KH AH"});
        assertEquals(false,test1);
        assertEquals(false,test2);
        assertEquals(true,test3);
        assertEquals(true,test4);
    }
    @Test//利用反射来测试私有方法相同点数
    public void testCheckKinds() throws Exception
    {
        Class<PokerCheck> class1 = PokerCheck.class;
        Object instance = class1.newInstance();
        Method method = class1.getDeclaredMethod("CheckKinds", new Class[]{String.class});
        method.setAccessible(true);
        Object test1 = method.invoke(instance, new Object[]{"3D 3H 3C 4S 5D"});
        Object test2 = method.invoke(instance, new Object[]{"5S 5D 6C 7S 8D"});
        Object test3 = method.invoke(instance, new Object[]{"7D 9D TD JD QD"});
        Object test4 = method.invoke(instance, new Object[]{"9H JH QH KH AH"});
        assertEquals(3,test1);
        assertEquals(2,test2);
        assertEquals(0,test3);
        assertEquals(0,test4);
    }
    @Test//利用反射来测试私有方法对子数
    public void testCheckPairs() throws Exception
    {
        Class<PokerCheck> class1 = PokerCheck.class;
        Object instance = class1.newInstance();
        Method method = class1.getDeclaredMethod("CheckPairs", new Class[]{String.class});
        method.setAccessible(true);
        Object test1 = method.invoke(instance, new Object[]{"3D 3H 3C 3S 5D"});
        Object test2 = method.invoke(instance, new Object[]{"5S 5D 6C 7S 8D"});
        Object test3 = method.invoke(instance, new Object[]{"7D 9D TD JD QD"});
        Object test4 = method.invoke(instance, new Object[]{"9H JH QH KH AH"});
        assertEquals(2,test1);
        assertEquals(1,test2);
        assertEquals(0,test3);
        assertEquals(0,test4);
    }
}