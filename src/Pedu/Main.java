/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pedu;

import Pedu.ConnectionFactory;
import java.sql.*;

/**
 *
 * @author 1886519
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Connection con = null;

        try {
            con = new ConnectionFactory().getConnection();
            System.out.println("Connection OK!");

            // ********** CRUD ********** 
                  // Inserir cliente
            String insertSQL = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date) VALUES (?, ?, ?, ?, ?, ?, NOW())";
            try (PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
                pstmt.setInt(1, 1);
                pstmt.setString(2, "Alcemy");
                pstmt.setString(3, "Severino");
                pstmt.setString(4, "charles.silva@example.com");
                pstmt.setInt(5, 10);
                pstmt.setInt(6, 1);
                pstmt.executeUpdate();
                System.out.println("Cliente inserido com sucesso!");
                
            }
            
            String sql = "";

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
            System.out.println("Connection closed!");
        }

    }

}
