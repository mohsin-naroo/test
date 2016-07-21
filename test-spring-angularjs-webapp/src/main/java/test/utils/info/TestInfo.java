package test.utils.info;

import java.math.BigDecimal;
import java.util.Date;

public class TestInfo {

    private long id;
    private String name;
    private Date date;
    private BigDecimal value;

    public TestInfo() {

    }

    public TestInfo(long id, String name, Date date, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
