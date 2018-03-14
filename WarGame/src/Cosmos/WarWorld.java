package Cosmos;

import java.util.ArrayList;

import Elements.IUnit;

public class WarWorld implements IWorld {

	private String name;
	
	private ArrayList<IUnit> units = new ArrayList<IUnit>();

	public void setName(String value) { this.name = value; }
	public String getName() { return name; }
	
}
