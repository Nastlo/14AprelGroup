package az.developia.coursemanagementsystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import az.developia.coursemanagementsystem.entity.Teacher;


public class TeacherRepository {

    public void addTeacher(Teacher teacher) {

        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/course_system",
                    "root",
                    "omar2012896363"
            );

            String sql = "INSERT INTO teachers(name, surname) VALUES (?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());

            ps.executeUpdate();

            System.out.println("Teacher added");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
