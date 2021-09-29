package cn.edu.whatximu.repairs.pojo;

/**
 * @author what_ximu
 * @date 2021/5/14 10:35
 */
public class llist {
    private String id;
    private String way;
    private String carbrand;
    private String carVIN;
    private String  reportdate;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportdate() {
        return reportdate;
    }

    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }



    public String getWay() {
        return way;

    }

    public void setWay(String way) {
        this.way = way;
    }



    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public void setCarVIN(String carVIN) {
        this.carVIN = carVIN;
    }

    public String getCarconfig() {
        return carconfig;
    }

    public void setCarconfig(String carconfig) {
        this.carconfig = carconfig;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    private String carconfig;
    private String webname;



}
