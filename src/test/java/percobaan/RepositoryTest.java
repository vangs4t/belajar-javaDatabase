package percobaan;

import enitiy.Perpus;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.PerpusRepositoryImpl;
import repository.PerpusRepostiroy;

public class RepositoryTest {
    private PerpusRepostiroy perpusRepostiroy;

    @BeforeEach
    void setUp() {
        perpusRepostiroy = new PerpusRepositoryImpl();
    }

    @Test
    void testSave() {
        Perpus perpus =  new Perpus(6,"askaraLayerFarm@gmail.com","Cara mempacking telur","Bagaimana Cara mempacking telur?");
        perpusRepostiroy.save(perpus);
        assertNotNull(perpus.getId());
        System.out.println(perpus.getId());
    }

    @Test
    void testFindByTitle() {
        Perpus perpus = perpusRepostiroy.searchByTitle("Belajar Komputer By Jhon");
        assertNotNull(perpus);
        System.out.println(perpus.getTitle());
        System.out.println(perpus.getId());
    }
}
