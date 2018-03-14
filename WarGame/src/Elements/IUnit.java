package Elements;

import Location.IPoint;

public interface IUnit {
	
	public String getName();
    public void setName(String value);

    public IPoint getPossition();
	public void setPossition(IPoint possition);
	
	public UnitType getType();
	public void setType(UnitType type);

}
