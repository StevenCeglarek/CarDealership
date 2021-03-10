import com.dealership.jdbc.ConnectionSession;
import com.dealership.model.Car;
import com.dealership.model.User;
import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@TestClass
public class TestThisClass {

    @TestMethod(expected = "This is a test")
    public String makeDummyUser() {
        User user = new User("This is a test", "123", "123", "123");
        return user.getUsername();
    }

    @TestMethod(expected = "Acura Integra")
    public String getFirstCarsMake() {
        Car car = null;
        String sql = "SELECT * FROM cars WHERE carId = 2";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                car = new Car();

                car.setMakeAndModel(rs.getString("makeAndModel"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car.getMakeAndModel();

    }
}
