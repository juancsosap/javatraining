package Units;

import Communications.IObserver;
import Cosmos.ICostable;
import Cosmos.ILevelable;
import Cosmos.IRangeable;
import Location.IPoint;

public interface IUnit extends IObserver, IAttackable, IRangeable, ILevelable, ICostable {
	
	public String getName();
    public void setName(String value);

    public IPoint getPossition();
	public void setPossition(IPoint possition);
	
	public UnitType getType();
	public void setType(UnitType type);

}
