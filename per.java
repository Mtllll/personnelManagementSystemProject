package PersonnelManagementSystem;

import java.util.Date;

/**
 * Created by ttc on 18-1-23.
 */
//数据库表对相应的类
public class per {
    private int pid;
    private String pname;
    private String ppassword;
    private Date pbirthday;
    private String pidentity;

    @Override
    public String toString() {
        return "per{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", ppassword='" + ppassword + '\'' +
                ", pbirthday=" + pbirthday +
                ", pidentity='" + pidentity + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }

    public Date getPbirthday() {
        return pbirthday;
    }

    public void setPbirthday(Date pbirthday) {
        this.pbirthday = pbirthday;
    }

    public String getPidentity() {
        return pidentity;
    }

    public void setPidentity(String pidentity) {
        this.pidentity = pidentity;
    }
}
