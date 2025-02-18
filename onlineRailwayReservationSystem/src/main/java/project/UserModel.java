package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserModel {
	public static boolean registerUser(String name, String email, String mobileNumber, String sequrityQuestion, String answer, String password) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (name, email, mobileNumber, sequrityQuestion, answer, password) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, mobileNumber);
            ps.setString(4, sequrityQuestion);
            ps.setString(5, answer);
            ps.setString(6, password);
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
	
	public static boolean validateUser(String email, String password) {
        boolean isValid = false;
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "'");
            isValid = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isValid;
    }
	
	public static boolean changePassword(String email, String mobileNumber, String sequrityQuestion, String answer, String newPassword) {
        boolean isPasswordChanged = false;
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND mobileNumber=? AND sequrityQuestion=? AND answer=?");
            ps.setString(1, email);
            ps.setString(2, mobileNumber);
            ps.setString(3, sequrityQuestion);
            ps.setString(4, answer);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PreparedStatement updatePs = con.prepareStatement("UPDATE users SET password=? WHERE email=?");
                updatePs.setString(1, newPassword);
                updatePs.setString(2, email);
                updatePs.executeUpdate();
                isPasswordChanged = true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isPasswordChanged;
    }
	//
	public static boolean addNewPayment(String id, String name, String category, String amount, String valid) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO payment VALUES(?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setString(4, amount);
            ps.setString(5, valid);
            int rowsAffected = ps.executeUpdate();
            con.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
	
	public static boolean editPayment(String id, String name, String category, String amount, String valid) {
        try {
        	Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			int rowsAffected=st.executeUpdate("update payment set name='"+name+"',catagory='"+category+"',amount='"+amount+"',valid='"+valid+"' where id='"+id+"'");
			con.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
	
	public static boolean deletePayment(String id, String name, String category, String amount, String valid) {
        try {
        	Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			int rowsAffected=st.executeUpdate("delete from payment where id='"+id+"'");
			con.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
	
	

}
