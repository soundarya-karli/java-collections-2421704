package Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.*;
import java.util.ArrayList;
import java.util.Arrays;


public class CarComparisonTest {
    Collection <Car> cars;
    Car honda,tesla,tata;

    @BeforeEach
    public void setUp(TestInfo info) throws Exception{
        System.out.format("%nPerforming %s%n", info.getTestMethod().get().getName());
        this.cars=new ArrayList<>();
        this.honda=new Car("Honda","A",40500);
        this.tesla=new Car("Tesla","X",35000);
        this.tata=new Car("TATA","S",25000);
        this.cars.addAll(Arrays.asList(honda,tesla,tata));
    }
    @AfterEach
    public void tearDown() throws Exception{
        System.out.format("%nResults%n");
        this.cars.stream().
                map(c->String.format("%s %s",c.getMake(),c.getModel())).
                forEach(System.out::println);
    }

    @Test
    public void removeTest(){
        this.cars.remove(honda);
        this.cars.remove(new Car("TATA","S",25000));
        assertEquals(1,this.cars.size());
    }
    @Test
    public void containsTest(){
        assertTrue(cars.contains(new Car("Honda","A",40500)));
        assertTrue(cars.contains(tesla));
        assertTrue(cars.contains(tata));
    }
    @Test
    public void removeAllTest(){
        this.cars.removeAll(Arrays.asList(honda,tesla,new Car("TATA","S",25000))) ;
        assertTrue(cars.isEmpty());               
    }
}
