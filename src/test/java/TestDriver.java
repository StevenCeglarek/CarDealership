import com.dealership.dao.CarDaoImpl;
import com.dealership.model.Employee;
import com.enterprise.model.MetaTestData;
import com.enterprise.util.HashMap;
import com.enterprise.util.TestDiscovery;

import java.lang.reflect.Method;

public class TestDriver {
    public static void main(String[] args) {

        HashMap<Method, MetaTestData> resultmap = null;
        try {
            TestDiscovery td = new TestDiscovery();

            resultmap = new TestDiscovery().runAndStoreTestInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultmap);

        CarDaoImpl cdi = new CarDaoImpl();

        System.out.println(cdi.findCarsByCustomerIdOf1());


    }
}
