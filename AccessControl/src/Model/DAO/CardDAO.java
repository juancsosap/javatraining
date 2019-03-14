package Model.DAO;

import Model.Card;
import Model.Zone;
import Model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDAO implements DAO<Card, Integer> {

    private DBConnection conn;
    
    public CardDAO() {
        try {
            this.conn = DBConnection.get();
        } catch (SQLException ex) {}
    }
    
    @Override
    public Card create(Card obj) {
        try {
            String sql = "INSERT INTO card SET (id, id_person, active) VALUES (?, ?, ?)";
            int quantity = conn.executeUpdate(sql, obj.getId(), obj.getPerson().getId(), obj.isActive());
            if(quantity == 1) {
                sql = "INSERT INTO permision SET (id_card, id_zone) VALUES (?, ?)";
                for(Zone zone : obj.getZones()) {
                    conn.executeUpdate(sql, obj.getId(), zone.getId());
                }
                return retrive(obj.getPerson());
            }
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Card retrive(Integer id) {
        try {
            String sql = "SELECT * FROM card WHERE id=?";
            ResultSet rs = conn.executeQuery(sql, id);
            rs.next();
            Person person = (new PersonDAO()).retrive(rs.getInt("id_person"));
            sql = "SELECT * FROM permision WHERE id_card=?";
            rs = conn.executeQuery(sql, id);
            ArrayList<Zone> zones = new ArrayList<>();
            ZoneDAO zDAO = new ZoneDAO();
            while(rs.next()) {
                zones.add(zDAO.retrive(rs.getInt("id_zone")));
            }
            return new Card(rs.getInt("id"), person, rs.getBoolean("active"), zones);
        } catch (SQLException ex) {}
        return null;
    }
    
    public Card retrive(Person person) {
        try {
            String sql = "SELECT * FROM zone WHERE name=?";
            ResultSet rs = conn.executeQuery(sql, name);
            rs.next();
            return new Card(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public List<Card> retrive() {
        try {
            String sql = "SELECT * FROM zone";
            ResultSet rs = conn.executeQuery(sql);
            List<Card> result =  new ArrayList<>();
            while(rs.next()) {
                result.add(new Card(rs.getInt("id"), rs.getString("name")));
            }
            return result;
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Card update(Card obj) {
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
    public Card delete(Card obj) {
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
