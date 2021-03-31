package uz.pdp.task1_lesson2_modul2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.task1_lesson2_modul2.entity.Attachment;
import uz.pdp.task1_lesson2_modul2.entity.Category;
import uz.pdp.task1_lesson2_modul2.entity.Measurement;
import uz.pdp.task1_lesson2_modul2.entity.Product;

@Projection(types = Product.class)
public interface CustomProduct {

    Integer getId();

    String getName();

    boolean getActive();

    Category getCategory();

    Attachment getPhoto();

    String getCode();

    Measurement getMeasurement();
}
