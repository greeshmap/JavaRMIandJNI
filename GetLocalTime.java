
public class GetLocalTime {

	int time;
	char valid;
	public GetLocalTime(int time,char valid)
	{
		this.time=time;
		this.valid=valid;
	}
	public String toString() {
        return ("Time:"+this.getTime()+
                    " Valid: "+ this.getvalid() );
   }
	public void setTime(int time)
	{
		this.time=time;
	}
	public int getTime()
	{
		return this.time;
	}
	public void setValid(char valid)
	{
		this.valid=valid;
	}
	public char getvalid()
	{
		return this.valid;
	}

}
