package Cosmos;

import Communications.ISubject;

public interface IGamer extends ISubject, ILevelable {

	public IWorld getWorld();
	
	public default String getURL() { return String.format("%s/%s", this.getWorld().getURL(), this.getName()); }
	
}
