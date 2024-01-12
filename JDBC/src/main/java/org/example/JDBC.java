package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class JDBC {

    private static final String URL = "jdbc:sqlite:university.db"; //URL to connect to the Database

    // Establish a connection to the database
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Method: addArtStudent(): Add an ArtStudent to the University database
    public void addArtStudent(ArtStudents student) {
        String sql = "INSERT INTO ArtStudents(Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getDepartment());
            pstmt.setString(3, student.getFirstName());
            pstmt.setString(4, student.getLastName());
            pstmt.setInt(5, student.getPassOutYear());
            pstmt.setInt(6, student.getUniversityRank());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A new row has been added.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Method: deleteArtStudent(): Delete an ArtStudent from the University database
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM ArtStudents WHERE Student_ID = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the corresponding param
            pstmt.setInt(1, studentId);
            // Execute the delete statement
            int rowsAffected = pstmt.executeUpdate();

            //Display a message confirming that a row of data was deleted
            if (rowsAffected > 0) {
                System.out.println("Student with ID " + studentId + " was deleted.");
            } else {
                System.out.println("No student found with ID " + studentId);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Method - updateStudentInfo
    public void updateStudentInfo(int studentId) {
        // Define the SQL update query with the RETURNING clause
        String updateSql = "UPDATE ArtStudents SET PassOutYear = 2024, UniversityRank = 4, Department = 'UpdatedDepartment' WHERE Student_ID = ? RETURNING *";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(updateSql)) {

            // Set the corresponding parameters
            pstmt.setInt(1, studentId);

            // Execute the update query and retrieve the updated information
            ResultSet rs = pstmt.executeQuery();

            // Check if the update was successful
            if (rs.next()) {
                System.out.println("Student with ID " + studentId + " was updated." + "\n");

                // Print the updated information
                System.out.println("//Updated Student Information");
                System.out.println("Name: " + rs.getString("First_Name") + " " + rs.getString("Last_Name"));
                System.out.println("Student ID: " + rs.getInt("Student_ID"));
                System.out.println("Department: " + rs.getString("Department"));
                System.out.println("Passout Year: " + rs.getInt("PassOutYear"));
                System.out.println("University Ranking: " + rs.getInt("UniversityRank"));
            } else {
                System.out.println("No student found with ID " + studentId);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Method: convertDatabaseTo2DArrayList()
    public List<List<Object>> convertQueryTo2DArrayList(String sqlQuery) {
        List<List<Object>> tableData = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Adding column headers as the first row
            List<Object> columnNames = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            tableData.add(columnNames);

            // Adding the rows of the query result
            while (rs.next()) {
                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.add(rs.getObject(i));
                }
                tableData.add(rowData);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tableData;
    }

    //Method: convertDatabaseToTable(): Converts data into a Table
    public DefaultTableModel convertDatabaseToDefaultTableModel() {
        String sql = "SELECT * FROM ArtStudents";

        DefaultTableModel tableModel = new DefaultTableModel();

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Adding column headers
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Adding the rows of the query result
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(rowData);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tableModel;
    }

    //Method - printTable(): Prints Data into a Table
    public void printTable(List<List<Object>> tableModel) {
        for (List<Object> row : tableModel) {
            for (Object cell : row) {
                System.out.print(cell + "\t"); // Print each cell separated by a tab
            }
            System.out.println(); // Start a new line at the end of each row
        }
    }

    //Method - printDefaultTableModel()
    public void printDefaultTableModel(DefaultTableModel tableModel) {
        // You can use a JTable to display the DefaultTableModel
        JTable table = new JTable(tableModel);

        // You can add the JTable to a JScrollPane for better visualization
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JFrame to display the table
        JFrame frame = new JFrame();
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    //Method - searchStudents(): Search for a Student
    public List<ArtStudents> searchStudents(String queryCriteria) {
        List<ArtStudents> students = new ArrayList<>();
        String sql = "SELECT * FROM ArtStudents WHERE " + queryCriteria;

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ArtStudents student = new ArtStudents(
                        rs.getInt("Student_ID"),
                        rs.getString("Department"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getInt("PassOutYear"),
                        rs.getInt("UniversityRank")
                );
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }



    // Main method for demonstration purposes
    public static void main(String[] args) {
        JDBC app = new JDBC();

        // Add two new rows to the database
        /* ArtStudents newStudent1 = new ArtStudents(110, "SA", "John", "Relic", 2098, 98);
        ArtStudents newStudent2 = new ArtStudents(112, "FA", "Alice", "Wonderland", 2022, 311);
        app.addArtStudent(newStudent1);
        app.addArtStudent(newStudent2);*/

        // Print the database as a 2D ArrayList
        /* String selectAll = "SELECT * FROM ArtStudents";
        List<List<Object>> allStudents = app.convertQueryTo2DArrayList(selectAll);
        app.printTable(allStudents); */

        // Delete two rows from the database
        /* app.deleteStudent(110);
        app.deleteStudent(112); */

        // Print the database as a Table
        /*String selectAll = "SELECT * FROM ArtStudents";
        List<List<Object>> allStudents = app.convertQueryTo2DArrayList(selectAll);
        app.printTable(allStudents);*/


        // Select a Student + Print their Information
        /*List<ArtStudents> foundStudents = app.searchStudents("Department = 'SA' AND PassOutYear > 2015");
        for (ArtStudents student : foundStudents) {
            System.out.println(student);
        }*/

        // Select a Student + Print their info in a 2D Array List
        /*String searchCriteria = "Department = 'SA' AND PassOutYear > 2015";
        String specificQuery = "SELECT * FROM ArtStudents WHERE " + searchCriteria;
        List<List<Object>> specificStudents = app.convertQueryTo2DArrayList(specificQuery);
        app.printTable(specificStudents);*/

        //Update three values within the table
        /*app.updateStudentInfo(101);*/

        //Print the database as a DefaultTableModel
        DefaultTableModel tableModel = app.convertDatabaseToDefaultTableModel();
        app.printDefaultTableModel(tableModel);

    }
}
