package Model.DAO;

import Model.Zone;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZoneDAO implements DAO<Zone, Integer> {

	private DBConnection conn;
    
    public ZoneDAO() {
        try {
            this.conn = DBConnection.get();
        } catch (SQLException ex) {}
    }
    
    @Override
    public Zone create(Zone obj) {
        try {
            String sql = "INSERT INTO zone SET (name) VALUES (?)";
            int quantity = conn.executeUpdate(sql, obj.getName());
            if(quantity == 1) {
                return retrive(obj.getName());
            }
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Zone retrive(Integer id) {
        try {
            String sql = "SELECT * FROM zone WHERE id=?";
            ResultSet rs = conn.executeQuery(sql, id);
            rs.next();
            return new Zone(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException ex) {}
        return null;
    }
    
    public Zone retrive(String name) {
        try {
            String sql = "SELECT * FROM zone WHERE name=?";
            ResultSet rs = conn.executeQuery(sql, name);
            rs.next();
            return new Zone(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public List<Zone> retrive() {
        try {
            String sql = "SELECT * FROM zone";
            ResultSet rs = conn.executeQuery(sql);
            List<Zone> result =  new ArrayList<>();
            while(rs.next()) {
                result.add(new Zone(rs.getInt("id"), rs.getString("name")));
            }
            return result;
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Zone update(Zone obj) {
        try {
            String sql = "UPDATE zone SET name=? WHERE id=?";
            int quantity = conn.executeUpdate(sql, obj.getName(), obj.getId());
            if(quantity == 1) {
                return retrive(obj.getId());
            }
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Zone delete(Zone obj) {
        try {
            String sql = "DELETE FROM zone WHERE id=?";
            int quantity = conn.executeUpdate(sql, obj.getId());
            if(quantity == 1) {
                return obj;
            }
        } catch (SQLException ex) {}
        return null;
    }
    
}
