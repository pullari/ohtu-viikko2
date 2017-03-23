/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pullis
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(sem);
            players.add(lem);
            players.add(kur);
            players.add(yze);
            players.add(gre);
 
            return players;
        }
    };
    
    Statistics stats;
    Player lem = new Player("Lemieux", "PIT", 45, 54);
    Player kur = new Player("Kurri",   "EDM", 37, 53);
    Player yze = new Player("Yzerman", "DET", 42, 56);
    Player sem = new Player("Semenko", "EDM", 4, 12);
    Player gre = new Player("Gretzky", "EDM", 35, 89);
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        Player player = stats.search("Lemieux");
        Assert.assertTrue(player.getName().equals("Lemieux"));
        Assert.assertTrue(player.getGoals() == 45);
        Assert.assertTrue(player.getAssists() == 54);
    }
    
    @Test
    public void testSearchWithWrongName() {
        Player player = stats.search("Lemiux");
        Assert.assertTrue(player == null);
    }


    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {

        List<Player> players = stats.team("EDM");
        Assert.assertTrue(players.contains(kur));
        Assert.assertTrue(players.contains(sem));
        Assert.assertTrue(players.contains(gre));
        Assert.assertTrue(players.size() == 3);
    }

    @Test
    public void testTopScorers() {
        
        List<Player> players = stats.topScorers(2);
        Assert.assertTrue(players.contains(lem));
        Assert.assertTrue(players.contains(gre));
        Assert.assertTrue(players.contains(yze));
        Assert.assertTrue(players.size() == 3);
    }
    
}
