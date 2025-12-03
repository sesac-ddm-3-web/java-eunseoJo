package racing;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    @BeforeEach
    void init(){
        // Given
        car = new Car();
    }
    @Test
    void _4이상이면_자동차가_전진하는지를_테스트한다(){
        // When
        car.move(() -> 4);
        // Then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_4미만일때_정지하는지를_테스트한다(){
        // When
        car.move(() -> 3);

        // Then
        assertThat(car.getPosition()).isEqualTo(0);

    }

}