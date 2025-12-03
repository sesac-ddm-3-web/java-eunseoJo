package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.controller.RaceController;
import racing.domain.Car;
import racing.utils.CarGenerator;
import racing.utils.NumberGenerator;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.mock;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {

    private Car car1;
    private Car car2;
    private List<Car>cars;

    @BeforeEach
    void init(){
        car1 = new Car();
        car2 = new Car();
        cars = List.of(car1, car2);
    }

    @Test
    void 모든자동차가_올바르게_전진했는지를_테스트한다(){
        // Given
        NumberGenerator fake = () -> 5;
        RaceController controller = new RaceController(null, null, fake, null);


        // When
        controller.moveAllCars(cars);

        // Then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    void 모든자동차가_올바르게_전진혹은정지했는지를_테스트한다(){
        // Given
        Iterator<Integer> numbers = List.of(4,1).iterator();

        NumberGenerator fake = () -> numbers.next();
        RaceController controller = new RaceController(null, null, fake, null);

        // When
        controller.moveAllCars(cars);

        // Then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);

    }
}
