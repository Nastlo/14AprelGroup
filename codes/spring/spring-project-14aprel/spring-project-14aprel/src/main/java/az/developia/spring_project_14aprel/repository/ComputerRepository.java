package az.developia.spring_project_14aprel.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.spring_project_14aprel.entity.Computer;

@Repository
public class ComputerRepository {

    @Autowired
    private DataSource dataSource;

    public List<Computer> getAll() {

        List<Computer> computers = new ArrayList<>();

        try {
            Connection con = dataSource.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM computers");

            while (rs.next()) {
                Computer computer = new Computer(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"));

                computers.add(computer);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return computers;
    }

    public Computer getById(Integer id) {

        try {
            Connection con = dataSource.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM computers WHERE id=" + id);

            if (rs.next()) {
                Computer computer = new Computer(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"));

                con.close();
                return computer;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void add(Computer computer) {

        try {
            Connection con = dataSource.getConnection();
            Statement st = con.createStatement();

            st.executeUpdate(
                    "INSERT INTO computers(brand, model) VALUES('"+ computer.getBrand() + "','"+ computer.getModel() + "')");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {

        try {
            Connection con = dataSource.getConnection();
            Statement st = con.createStatement();

            st.executeUpdate("DELETE FROM computers WHERE id=" + id);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}