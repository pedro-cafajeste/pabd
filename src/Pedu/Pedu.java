
package Pedu;

/* @author 20221074010027 */
import java.sql.*;

public class Pedu {

    public static void main(String[] args) throws SQLException {

        Connection con = null;

        try {
            con = new ConnectionFactory().getConnection();
            System.out.println("Connection closed");

            String insertSQL = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
                pstmt.setInt(1, 1);
                pstmt.setString(2, "Alcemy");
                pstmt.setString(3, "Severino");
                pstmt.setString(4, "alcemy@gmail.com");
                pstmt.setInt(5, 10);
                pstmt.setInt(6, 1);
                pstmt.executeUpdate();
                System.out.println("Cliente inserido com sucesso!");
            }

            String updateSQL = "UPDATE customer SET store_id = ?, address_id = ? WHERE first_name = ? AND last_name = ?";
            try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
                pstmt.setInt(1, 2);
                pstmt.setInt(2, 5);
                pstmt.setString(3, "Alcemy");
                pstmt.setString(4, "Severino");
                pstmt.executeUpdate();
                System.out.println("Cliente atualizado com sucesso!");
            }

            String deleteSQL = "DELETE FROM customer WHERE first_name = ? AND last_name = ?";
            try (PreparedStatement pstmt = con.prepareStatement(deleteSQL)) {
                pstmt.setString(1, "Alcemy");
                pstmt.setString(2, "Severino");
                pstmt.executeUpdate();
                System.out.println("Cliente removido com sucesso!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                con.close();
                System.out.println("Connection closed!");
            }
        }
    }
