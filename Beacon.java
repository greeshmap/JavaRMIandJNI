import java.io.Serializable;

public class Beacon implements Serializable {
	public int ID;
	public int StartUpTime;
	public String CmdAgentID;
	private long timestamp;
	
	public Beacon(int ID, int StartUpTime, String CmdAgentID, long timestamp)
	{
		this.ID=ID;
		this.StartUpTime=StartUpTime;
		this.CmdAgentID=CmdAgentID;
		this.timestamp=timestamp;
	}
	public String toString() {
        return ("ID:"+this.getID()+
                    " Startuptime: "+ this.getStartUpTime() +
                    " cmdAgentID: "+ this.getCmdAgentID() +
                    " lastSignalTime : " + this.getLastSignalTime());
   }
	@Override
	public boolean equals(Object o)
	{
			Beacon b=(Beacon) o;
			if((this.getID()==b.getID()))
				return true;
		
			else 
			return false;
	}
	public void setID(int ID)
	{
		this.ID=ID;
	}
	public int getID()
	{
		return ID;
	}
	public void setstartUpTime(int StartUpTime)
	{
		this.StartUpTime=StartUpTime;
	}
	public int getStartUpTime()
	{
		return StartUpTime;
	}
	public void setCmdAgentID(String CmdAgentID)
	{
		this.CmdAgentID=CmdAgentID;
	}
	public String getCmdAgentID()
	{
		return CmdAgentID;
	}
	public void setlastSignaltime(long lastSignalTime)
	{
		this.timestamp=lastSignalTime;
	}
	public long getLastSignalTime()
	{
		return timestamp;
	}

}
