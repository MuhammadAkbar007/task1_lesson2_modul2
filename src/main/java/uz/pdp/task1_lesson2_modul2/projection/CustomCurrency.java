package uz.pdp.task1_lesson2_modul2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.task1_lesson2_modul2.entity.Currency;

@Projection(types = Currency.class)
public interface CustomCurrency {

    Integer getId();

    String getName();

    boolean getActive();
}
