package cn.edu.whatximu.repairs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarUser {
    private String username;
    private String Userpwd;
    private String name;
    private Integer identity;

}
