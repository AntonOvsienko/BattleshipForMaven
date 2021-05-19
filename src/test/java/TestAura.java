import org.junit.Test;
import ua.com.finaly.ShipClass;
import ua.com.finaly.Vizualization;

public class TestAura {

    @Test
    public void AuraTest(){
        ShipClass ship1=new ShipClass(2,3);
        ShipClass ship3=new ShipClass(0,1,0,0,0,2);

//
//
        System.out.println(ship1.getAura());
//        System.out.println(ship3.getAura());
    }
}
