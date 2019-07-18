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
            boolean active = rs.getBoolean("active");
            Person person = (new PersonDAO()).retrive(rs.getInt("id_person"));
            ArrayList<Zone> zones = retriveZones(id);
            return new Card(id, person, active, zones);
        } catch (SQLException ex) {}
        return null;
    }
    
    public Card retrive(Person person) {
        try {
            String sql = "SELECT * FROM card WHERE id_person=?";
            ResultSet rs = conn.executeQuery(sql, person.getId());
            rs.next();
            int id = rs.getInt("id");
            boolean active = rs.getBoolean("active");
            ArrayList<Zone> zones = retriveZones(id);
            return new Card(id, person, active, zones);
        } catch (SQLException ex) {}
        return null;
    }
    
    public ArrayList<Zone> retriveZones(int id_card) {
        try {
            String sql = "SELECT * FROM permision WHERE id_card=?";
            ResultSet rs = conn.executeQuery(sql, id_card);
            ArrayList<Zone> zones = new ArrayList<>();
            ZoneDAO zDAO = new ZoneDAO();
            while(rs.next()) {
                zones.add(zDAO.retrive(rs.getInt("id_zone")));
            }
            return zones;
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public List<Card> retrive() {
        try {
            String sql = "SELECT * FROM card";
            ResultSet rs = conn.executeQuery(sql);
            List<Card> result =  new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("id");
                Person person = (new PersonDAO()).retrive(rs.getInt("id_person"));
                boolean active = rs.getBoolean("active");
                ArrayList<Zone> zones = retriveZones(id);
                result.add(new Card(id, person, active, zones));
            }
            return result;
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Card update(Card obj) {
        try {
            String sql = "UPDATE card SET id_person=?, active=? WHERE id=?";
            int quantity = conn.executeUpdate(sql, obj.getPerson().getId(), obj.isActive(), obj.getId());
            ArrayList<Zone> zones = retriveZones(obj.getId());
            List<Zone> objzones = obj.getZones();
            for(Zone dbzone : zones) {
                boolean delzone = true;
                for(int i = 0; i < objzones.size(); i++) {    
                    if(dbzone.getId() == objzones.get(i).getId()) {
                        delzone = false;
                        objzones.remove(i);
                    }
                }
                if(delzone) {
                    sql = "DELETE FROM permision WHERE id_card=?";
                    conn.executeUpdate(sql, dbzone.getId());
                }            
            }
            sql = "INSERT INTO permision SET (id_card, id_zone) VALUES (?, ?)";
            for(Zone objzone : objzones) {
                conn.executeUpdate(sql, obj.getId(), objzone.getId());            
            }
            if(quantity == 1) {
                return retrive(obj.getId());
            }
        } catch (SQLException ex) {}
        return null;
    }

    @Override
    public Card delete(Card obj) {
        try {
            String sql = "DELETE FROM permision WHERE id_card=?";
            conn.executeUpdate(sql, obj.getId());
            sql = "DELETE FROM card WHERE id=?";
            int quantity = conn.executeUpdate(sql, obj.getId());
            if(quantity == 1) {
                return obj;
            }
        } catch (SQLException ex) {}
        return null;
    }
    
}
