package uz.pdp.task1_lesson2_modul2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.task1_lesson2_modul2.entity.Output;
import uz.pdp.task1_lesson2_modul2.entity.OutputProduct;
import uz.pdp.task1_lesson2_modul2.entity.Product;

@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {

    Integer getId();

    Product getProduct();

    Double getAmount();

    Double getPrice();

    Output getOutput();
}
