package uz.pdp.task1_lesson2_modul2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.task1_lesson2_modul2.entity.Input;
import uz.pdp.task1_lesson2_modul2.entity.InputProduct;
import uz.pdp.task1_lesson2_modul2.entity.Product;

import java.util.Date;

@Projection(types = InputProduct.class)
public interface CustomInputProduct {

    Integer getId();

    Product getProduct();

    Double getAmount();

    Double getPrice();

    Date getExpireDate();

    Input getInput();
}
