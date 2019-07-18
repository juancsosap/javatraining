package Model.DAO;

import Model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements DAO<Person, Integer> {

    private DBConnection conn;
    
    public PersonDAO() {
        try {
            this.conn = DBConnection.get();
        } catch (SQLException ex) {}
    }
    
    @Override
    public Person create(Person obj) {
        try {
            String sql = "INSERT INTO person SET (name, role) VALUES (?, ?)";
            int quantity = conn.executeUpdate(sql, obj.getName(), obj.getRole());
            if(quantity == 1) {
                return retrive(obj.getName());
            }
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Person retrive(Integer id) {
        try {
            String sql = "SELECT * FROM person WHERE id=?";
            ResultSet rs = conn.executeQuery(sql, id);
            rs.next();
            return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("role"));
        } catch (SQLException ex) {}
        return null;
    }
    
    public Person retrive(String name) {
        try {
            String sql = "SELECT * FROM person WHERE name=?";
            ResultSet rs = conn.executeQuery(sql, name);
            rs.next();
            return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("role"));
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public List<Person> retrive() {
        try {
            String sql = "SELECT * FROM person";
            ResultSet rs = conn.executeQuery(sql);
            List<Person> result =  new ArrayList<>();
            while(rs.next()) {
                result.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("role")));
            }
            return result;
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Person update(Person obj) {
        try {
            String sql = "UPDATE person SET name=?, role=? WHERE id=?";
            int quantity = conn.executeUpdate(sql, obj.getName(), obj.getRole(), obj.getId());
            if(quantity == 1) {
                return retrive(obj.getId());
            }
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Person delete(Person obj) {
        try {
            String sql = "DELETE FROM person WHERE id=?";
            int quantity = conn.executeUpdate(sql, obj.getId());
            if(quantity == 1) {
                return obj;
            }
        } catch (SQLException ex) {}
        return null;
    }
    
}
