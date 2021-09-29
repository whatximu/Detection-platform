package cn.edu.whatximu.repairs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InformationForm {

    private Integer    id;
    private String     webname;
    private String     airnumer;
    private String     reportdate;
    private String     carbrand;
    private String     carconfig;
    private String     carVIN;
    private String     mileage;
    private String     engineid;
    private String     gearboxid;
    private String     refit;
    private String     maintain;
    private String     desc;
    private String     condition;
    private String     load;
    private String     operating;
    private String     gears;
    private String     minrpm;
    private String     maxrpm;
    private String     minkph;
    private String     maxKph;
    private String     subjective;
    private String     abnormal;
    private String     fileList;

}
