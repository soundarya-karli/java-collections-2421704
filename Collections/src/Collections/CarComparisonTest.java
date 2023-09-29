package Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class CarComparisonTest {
    Collection <Car> cars;
    Car honda,tesla,tata;

    @BeforeEach
    public void setUp(TestInfo info) throws Exception{
        System.out.format("%nPerforming %s%n", info.getTestMethod().get().getName());
    }
}
