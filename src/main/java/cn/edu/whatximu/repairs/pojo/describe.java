package cn.edu.whatximu.repairs.pojo;

/**
 * @author what_ximu
 * @date 2021/5/13 16:12
 */
public class describe {
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String state;
    private String info;

    @Override
    public String toString() {
        return "describe{" +
                "state='" + state + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
