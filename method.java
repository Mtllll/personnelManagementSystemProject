package PersonnelManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ttc on 18-1-23.
 */
public class method {
    //增加Insert
    int addNewPer(per a) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT into per (pname,ppassword,pbirthday,pidentity)VALUES(?,?,?,?)");
        preparedStatement.setString(1, a.getPname());
        preparedStatement.setString(2, a.getPpassword());
        Date date = new Date();
        date = a.getPbirthday();
        long time = date.getTime();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
        preparedStatement.setTimestamp(3, timestamp);
        preparedStatement.setString(4, a.getPidentity());

        int row = preparedStatement.executeUpdate();
        JDBCUtils.close(preparedStatement, conn);
        return row;
    }

    //    //添加
//     int insertSort(per a) throws Exception {
//        Connection conn = JDBCUtils.getConnection();
//        PreparedStatement preparedStatement = conn.prepareStatement("INSERT into per (pname,ppassword,pbirthday)VALUES(?,?,?)");
//        preparedStatement.setString(1, a.getPname());
//        preparedStatement.setString(2, a.getPpassword());
//        Date date=new Date();
//                date=a.getPbirthday();
//        long time=date.getTime();
//        java.sql.Timestamp timestamp=new java.sql.Timestamp(time);
//        preparedStatement.setTimestamp(3, timestamp);
//
//        int row = preparedStatement.executeUpdate();
//        JDBCUtils.close(preparedStatement, conn);
//        return row;
//    }
    //删除Delete
    public void deletePer(int id) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE from per where pid=?");
        preparedStatement.setInt(1, id);
        int row = preparedStatement.executeUpdate();
        JDBCUtils.close(preparedStatement, conn);
    }

    //全部查找
    List<per> selectPerAll() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from per ");

        ResultSet resultSet = preparedStatement.executeQuery();
        List<per> listt = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("pid");
            String pidentity = resultSet.getString("pidentity");
            String pname = resultSet.getString("pname");
            String psd = resultSet.getString("ppassword");
            Date pbir = resultSet.getTimestamp("pbirthday");
            per p = new per();
            p.setPid(id);
            p.setPidentity(pidentity);
            p.setPpassword(psd);
            p.setPname(pname);
            p.setPbirthday(pbir);
            listt.add(p);

        }
        return listt;
    }

    //按照姓名和密码查询员工是否存在
    public per selectPer(String a, String b) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from per where pname=? and ppassword=? ");
        preparedStatement.setString(1, a);
        preparedStatement.setString(2, b);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int pid = resultSet.getInt("pid");
            String pname = resultSet.getString("pname");
            String ppassword = resultSet.getString("ppassword");
            String pidentity = resultSet.getString("pidentity");
            Date pbirthday = resultSet.getDate("pbirthday");
            per p = new per();
            p.setPbirthday(pbirthday);
            p.setPid(pid);
            p.setPidentity(pidentity);
            p.setPname(pname);
            p.setPpassword(ppassword);

            return p;
        } else {
            return null;
        }
    }

    //按照id查询员工是否存在
    public per selectPer(int a) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from per where pid=? ");
        preparedStatement.setInt(1, a);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int pid = resultSet.getInt("pid");
            String pname = resultSet.getString("pname");
            String ppassword = resultSet.getString("ppassword");
            String pidentity = resultSet.getString("pidentity");
            Date pbirthday = resultSet.getDate("pbirthday");
            per p2 = new per();
            p2.setPbirthday(pbirthday);
            p2.setPid(pid);
            p2.setPidentity(pidentity);
            p2.setPname(pname);
            p2.setPpassword(ppassword);

            return p2;
        } else {
            return null;
        }
    }

    //按照姓名查找（支持模糊查询）
    public per selectPer(String a) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from per where pname like ?");
        preparedStatement.setString(1, "%"+a+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int pid = resultSet.getInt("pid");
            String pname = resultSet.getString("pname");
            String ppassword = resultSet.getString("ppassword");
            String pidentity = resultSet.getString("pidentity");
            Date pb = resultSet.getDate("pbirthday");
            per p3 = new per();
            p3.setPbirthday(pb);
            p3.setPid(pid);
            p3.setPidentity(pidentity);
            p3.setPname(pname);
            p3.setPpassword(ppassword);

            return p3;
        } else {
            return null;
        }
    }

    //修改
    public void updatePer(per p) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement
                ("update per SET pname=?,ppassword=?,pbirthday=? where pid=? ");
        preparedStatement.setString(1, p.getPname());
        preparedStatement.setString(2, p.getPpassword());

        Date date = p.getPbirthday();
        long time = date.getTime();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
        preparedStatement.setTimestamp(3, timestamp);
        preparedStatement.setInt(4,p.getPid());
        int row = preparedStatement.executeUpdate();
            JDBCUtils.close(preparedStatement, conn);

    }

    //修改带身份的
    public void Per(per p) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement
                ("update per SET pname=?,ppassword=?,pbirthday=?,pidentity=? where pid=?");
        preparedStatement.setString(1, p.getPname());
        preparedStatement.setString(2, p.getPpassword());

        Date date = p.getPbirthday();
        long time = date.getTime();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
        preparedStatement.setTimestamp(3, timestamp);
        preparedStatement.setString(4, p.getPidentity());
        preparedStatement.setInt(5, p.getPid());
        int row = preparedStatement.executeUpdate();

        JDBCUtils.close(preparedStatement, conn);
    }
}


