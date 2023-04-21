package ma.mtm.service;

import ma.mtm.DOA.IDoa;
import ma.mtm.DOA.JDBC;
import ma.mtm.classes.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IDoa<Student> {
    Connection conn = JDBC.getConnection();
    @Override
    public boolean create(Student o) {
        String SQL = "INSERT INTO student(nom,prenom,sexe,Filiere) VALUES(?,?,?,?)";
        PreparedStatement stmt;
        boolean success = false;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, o.getNom());
            stmt.setString(2, o.getPrenom());
            stmt.setString(3, o.getSexe());
            stmt.setString(4, o.getFiliere());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("Student add successfully !!");
            }
        } catch (SQLException e) {
            System.out.println("SQL PROBLEM !!!!");
            throw new RuntimeException(e);
        }
        return success;
    }

    @Override
    public boolean delete(int id) {
        String SQL = "Delete From student WHERE idEtu = ?";
        PreparedStatement stmt;
        boolean success = false;
        try {
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(1,id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("Student Deleted successfully !!");
            }
        } catch (SQLException e) {
            System.out.println("SQL PROBLEM !!!!"+ e);
            throw new RuntimeException(e);
        }
        return success;
    }

    @Override
    public boolean update(Student o, int id) {
        String SQL ="UPDATE student SET nom =?,prenom=?,sexe=?,Filiere=? WHERE idEtu = ?";
        PreparedStatement stmt;
        boolean success = false;
        try {
            stmt =conn.prepareStatement(SQL);
            stmt.setString(1,o.getNom());
            stmt.setString(2,o.getPrenom());
            stmt.setString(3,o.getSexe());
            stmt.setString(4,o.getFiliere());
            stmt.setInt(5,id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                System.out.println("Student Updated successfully !!");
            }
        } catch (Exception e) {
            System.out.println("SQL PROBLEM !!!!");
            throw new RuntimeException(e);
        }
        return success;
    }

    @Override
    public Student findById(int id) {
        String SQL ="SELECT * FROM student WHERE idEtu = ?";
        PreparedStatement stm= null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            stm = conn.prepareStatement(SQL);
            stm.setInt(1,id);
            resultSet = stm.executeQuery();
            if(resultSet.next()) {
                student = new Student(resultSet.getInt("idEtu"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("sexe"),
                        resultSet.getString("Filiere")
                        );
            }
        } catch (SQLException e) {
            System.out.println("SQL PROBLEM !!!!");
            throw new RuntimeException(e);
        }
        // Return the student object
        return student;
    }

    @Override
    public List<Student> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            // Create a statement object to execute the query
            statement = conn.createStatement();
            // Execute the query and get the result set
            resultSet = statement.executeQuery("SELECT * FROM student");
            // Loop through the result set and create a Student object for each row
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("idEtu"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("sexe"),
                        resultSet.getString("Filiere")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the result set and statement
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Return the list of students
        return students;
    }
}
