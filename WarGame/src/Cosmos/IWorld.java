package Cosmos;

import Communications.ISubject;

public interface IWorld extends ISubject {

	public default String getURL() { return String.format("%s", this.getName()); }
	
}
