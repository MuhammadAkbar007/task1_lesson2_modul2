package uz.pdp.task1_lesson2_modul2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.task1_lesson2_modul2.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Warehouse extends AbsEntity {
}
