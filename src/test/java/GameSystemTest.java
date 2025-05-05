import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import com.example.game.*;

public class GameSystemTest {
    @Test
    public void isAliveWorking() {
        Enemy e1 = new Enemy(1); e1.setHp(0);
        assertFalse(e1.isAlive());
    }

    @Test
    public void testEnemiesDead() {
        EnemyManager enemyManager = new EnemyManager();
        ArrayList<Enemy> enemies = new ArrayList<>();
        Enemy e1 = new Enemy(1); e1.setHp(0);
        Enemy e2 = new Enemy(1); e2.setHp(2);
        enemies.add(e1);
        enemies.add(e2);
        assertEquals(2,enemies.size());
        assertFalse(enemyManager.areEnemiesDead(enemies));
    }

    @Test
    public void test() {
        assertTrue(true);
    }
}
