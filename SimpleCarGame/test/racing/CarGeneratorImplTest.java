package racing;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.utils.CarGenerator;
import racing.utils.CarGeneratorImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGeneratorImplTest {

    @Test
    void 자동차_생성이_잘_되는지를_테스트한다(){
        // Given
        CarGenerator carGenerator = new CarGeneratorImpl();
        int count = 4;

        // When
        List<Car> cars = carGenerator.createCars(count);

        // Then
        assertThat(cars).hasSize(count);
    }

}
