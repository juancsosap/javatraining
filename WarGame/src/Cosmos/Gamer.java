package Cosmos;

import java.util.ArrayList;

import Commands.ICommand;
import Communications.IInformation;
import Communications.IObserver;
import Communications.ISubject;
import Elements.BasicTroopMediator;
import Elements.UnitType;
import Factory.AirUnitFactory;
import Factory.GroundUnitFactory;
import Factory.IUnitFactory;
import Factory.MarineUnitFactory;
import Weapons.IWeapon;

public class Gamer implements ISubject {

	private String name;
    private long money;
    private ArrayList<IWeapon> stock;

    private ArrayList<IObserver> troops = new ArrayList<IObserver>();

    public Gamer(String name) {
        this.setName(name);
        this.setMoney(1000);
    }

    public void addUnit(BasicTroopMediator troop, UnitType type, String name, ArrayList<IWeapon> weapons) {
        IUnitFactory factory = null;

        if (type.equals(UnitType.AIR))
            factory = new AirUnitFactory();
        if (type.equals(UnitType.MARINE))
            factory = new MarineUnitFactory();
        if (type.equals(UnitType.GROUND))
            factory = new GroundUnitFactory();

        factory.make(troop, name, weapons);
    }
    
    public void addTroop(String name) {
    	this.register(new BasicTroopMediator(this, name));
    }

    public void update(IObserver ob, IInformation info) { }

    public void notifyAll(ICommand command) {
        for(IObserver ob : troops)
            ob.update(command);
    }

    public void notifyOne(IObserver ob, ICommand command) {
        ob.update(command);
    }

    public void register(IObserver ob) {
        if (!troops.contains(ob))
            troops.add(ob);
    }

    public void unregister(IObserver ob) {
        if (troops.contains(ob))
            troops.remove(ob);
    }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public long getMoney() { return money; }
	public void setMoney(long money) { this.money = money; }

	public ArrayList<IWeapon> getStock() { return stock; }
	public void setStock(ArrayList<IWeapon> stock) { this.stock = stock; }
	
}
