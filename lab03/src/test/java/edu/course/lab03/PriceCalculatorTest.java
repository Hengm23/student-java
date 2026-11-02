package edu.course.lab03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceCalculatorTest {

    @Test
    @DisplayName("NoDiscount возвращает исходную цену")
    void shouldReturnOriginalPriceForNoDiscount() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calculator.calculate(100.0), 1e-9);
    }

    @Test
    @DisplayName("PercentDiscount корректно рассчитывает скидку 20% от 100")
    void shouldApplyPercentDiscountCorrectly() {
        PriceCalculator calculator = new PriceCalculator(new PercentDiscount(20.0));
        assertEquals(80.0, calculator.calculate(100.0), 1e-9);
    }

    @Test
    @DisplayName("Демонстрация полиморфизма: замена политики скидок")
    void shouldSupportPolicyReplacement() {
        DiscountPolicy noDiscount = new NoDiscount();
        DiscountPolicy halfDiscount = new PercentDiscount(50.0);

        PriceCalculator calc1 = new PriceCalculator(noDiscount);
        PriceCalculator calc2 = new PriceCalculator(halfDiscount);

        assertEquals(200.0, calc1.calculate(200.0), 1e-9);
        assertEquals(100.0, calc2.calculate(200.0), 1e-9);
    }

    @Test
    @DisplayName("Запрет отрицательной цены и некорректного процента")
    void shouldThrowOnInvalidArguments() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(-10.0));

        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-5.0));
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(105.0));
    }
}