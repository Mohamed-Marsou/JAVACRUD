package ma.mtm.service;

import ma.mtm.DOA.IDoa;
import ma.mtm.DOA.JDBC;
import ma.mtm.classes.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiliereService  implements IDoa<Filiere> {
    Connection conn = JDBC.getConnection();
    @Override
    public boolean create(Filiere o) {
        String SQL = "INSERT INTO filiere(nomFil) VALUES(?)";
        PreparedStatement stmt;
        boolean success = false;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, o.getNomFil());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("filiere add successfully !!");
            }
        } catch (SQLException e) {
            System.out.println("SQL PROBLEM !!!!");
            throw new RuntimeException(e);
        }
        return success;
    }

    @Override
    public boolean delete(int id) {
        String SQL = "Delete From filiere WHERE idFil = ?";
        PreparedStatement stmt;
        boolean success = false;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1,id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("filiere Deleted successfully !!");
            }
        } catch (SQLException e) {
            System.out.println("SQL PROBLEM !!!!");
            throw new RuntimeException(e);
        }
        return success;
    }

    @Override
    public boolean update(Filiere o, int id) {
        String SQL ="UPDATE filiere SET nomFil =? WHERE idFil = ?";
        PreparedStatement stmt;
        boolean success = false;
        try {
            stmt =conn.prepareStatement(SQL);
            stmt.setString(1,o.getNomFil());
            stmt.setInt(2,id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("filiere Updated successfully !!");
            }
        } catch (Exception e) {
            System.out.println("SQL PROBLEM !!!!");
            throw new RuntimeException(e);
        }
        return success;
    }

    @Override
    public Filiere findById(int id) {
        String SQL ="SELECT * FROM filiere WHERE idFil = ?";
        PreparedStatement stm;
        int idFil;
        String nomFil;
        try {
            stm = conn.prepareStatement(SQL);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                idFil = rs.getInt("idFil");
                nomFil = rs.getString("nomFil");
                Filiere f = new Filiere(idFil,nomFil);
                return f;
            }
        } catch (SQLException e) {
            System.out.println("SQL PROBLEM !!!!");
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Filiere> findAll() {
        String SQL = "SELECT * FROM filiere";
        PreparedStatement stm;
        List<Filiere> Arr = new ArrayList<>();
        String nomFil;
        int idFil;
        try {
            stm = conn.prepareStatement(SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                idFil = rs.getInt("idFil");
                nomFil = rs.getString("nomFil");
                Filiere f = new Filiere(idFil,nomFil);
                Arr.add(f);
            }
        } catch (SQLException e) {
            System.out.println("SQL PROBLEM !!!!");
            throw new RuntimeException(e);
        }
        return Arr;
    };
}
