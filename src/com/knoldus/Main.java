package com.knoldus;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/PRODUCT";
        String uname = "root";
        String pass = "";
        int userdata;
        String query = "SELECT SUM(cart.qty*product.price) as TOTALPRICE FROM cart,product WHERE product.pid=cart.Pid";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        ResultSet rs =  st.executeQuery(query);
        rs.next();
        userdata = rs.getInt(1);
        System.out.println(userdata);
        st.close();
        con.close();
    }
}
