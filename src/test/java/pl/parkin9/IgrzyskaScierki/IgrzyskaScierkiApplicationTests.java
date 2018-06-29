package pl.parkin9.IgrzyskaScierki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.parkin9.IgrzyskaScierki.controller.GameController;
import pl.parkin9.IgrzyskaScierki.controller.HomeController;
import pl.parkin9.IgrzyskaScierki.controller.PanelController;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IgrzyskaScierkiApplicationTests {

    @Autowired
    GameController gameController;
    @Autowired
    HomeController homeController;
    @Autowired
    PanelController panelController;

/////////////////////////////////////////////////////////////////////////

	@Test
	public void contextLoads() {

		assertNotNull(gameController);
        assertNotNull(homeController);
        assertNotNull(panelController);
	}
}
