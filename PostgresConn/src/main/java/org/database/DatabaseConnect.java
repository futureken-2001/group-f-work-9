package org.database;
import java.sql.*;

public class DatabaseConnect {
 static String emailValue,passwordValue,address,phoneNumber,BirthYear,name;

    public static String getEmailValue() {
        return emailValue;
    }

    public static String getPasswordValue() {
        return passwordValue;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getBirthYear() {
        return BirthYear;
    }

    public static String getAddress() {
        return address;
    }

    public static String getName() {
        return name;
    }

    public static void setEmailValue(String emailValue) {
        DatabaseConnect.emailValue = emailValue;
    }

    public static void setAddress(String address) {
        DatabaseConnect.address = address;
    }

    public static void setPhoneNumber(String phoneNumber) {
        DatabaseConnect.phoneNumber = phoneNumber;
    }

    public static void setName(String name) {
        DatabaseConnect.name = name;
    }

    public static void setBirthYear(String birthYear) {
        BirthYear = birthYear;
    }

    public  static Connection dbConn(String dbName, String userName, String password){

        Connection conn=null;
        try{

            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbName,userName,password);

        if(conn!=null)
        {

            System.out.println("CONNECTED TO POSTGRES DATABASE!");
        }else
        {
            System.out.println("CONNECTION FAILED");
        }

        } catch (Exception e) {

            System.out.println("Not Connected!!");
        }
        return conn;
    }


    public  static void createTable(Connection conn,String tableName){
        Statement statement;
        try{

            String query="create table "+tableName+" (userId SERIAL primary key,name varchar(100),yearOfBirth varchar(5) ,address varchar(200),phoneNumber varchar(20),email varchar(200) unique,password varchar(20) not null);";


            statement= conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table "+tableName +" created in The target databases");


        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public static void insert_Data(Connection conn,String tablename,String name,String yearOfBirth,String address,String phonenumber,String email,String password){
        try{
            Statement statement;
            String query=String.format("insert into %s(name,yearOfBirth,address,phoneNumber,email,password) values('%s','%s','%s','%s','%s','%s');",tablename,name,yearOfBirth,address,phonenumber,email,password);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("1 row effected");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void update_data(Connection conn,String tableName,String oldvalue,String newValue){
        Statement statement;
        try{
            String query=String.format("update %s set userName='%s' where userName='%s';",tableName,newValue,oldvalue);
            statement= conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void read_data(Connection conn,String tableName,String email){
        Statement statement;
        ResultSet res=null;
        try{
            String query=String.format("select * from %s where email='%s';",tableName,email);
            statement= conn.createStatement();
            res=statement.executeQuery(query);


            while(res.next()){
                setName(res.getString("name"));
                setAddress(res.getString("Address"));
                setEmailValue(res.getString("email"));
                setPhoneNumber(res.getString("phoneNumber"));


            }


        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void search_by(Connection conn,String tableName,String field){
        Statement statement;
        ResultSet res;

        try{
            String query=String.format("select * from %s where email='%s';",tableName,field);
            statement=conn.createStatement();
            res=statement.executeQuery(query);
            while (res.next()){
                //address,phoneNumber,BirthYear
                emailValue= res.getString("email");
                passwordValue=res.getString("password");
                address=res.getString("address");
                phoneNumber=res.getString("phoneNumber");
                BirthYear=res.getString("yearOfBirth");
                name=res.getString("name");

                          }

        }
        catch (SQLException e) {
            System.out.println(e);
        }

    }

public static void deleteUser(Connection conn,String tableName,String value){
        try {
            Statement statement;
            String query=String.format("delete from %s where userName='%s';",tableName,value);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("USER DELETED!");

        }
        catch (SQLException e){
            System.out.println(e);
        }
}


}
