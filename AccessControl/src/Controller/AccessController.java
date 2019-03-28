package Controller;

import Model.Card;
import Model.Zone;
import Model.DAO.CardDAO;
import Model.DAO.ZoneDAO;
import java.util.List;

public class AccessController {

    private CardDAO daoCard = new CardDAO();
    private ZoneDAO daoZone = new ZoneDAO();
    
    public boolean autorize(int zoneId, int cardId) {
        Card card = daoCard.retrive(cardId);
        Zone zone = daoZone.retrive(zoneId);
        
        List<Zone> zones = card.getZones();
        return zones.contains(zone);
    }
    
}