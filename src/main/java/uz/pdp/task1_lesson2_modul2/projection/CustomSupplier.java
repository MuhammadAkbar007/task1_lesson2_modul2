package uz.pdp.task1_lesson2_modul2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.task1_lesson2_modul2.entity.Supplier;

@Projection(types = Supplier.class)
public interface CustomSupplier {

    Integer getId();

    String getName();

    boolean getActive();

    String getPhoneNumber();
}
