
public class GetVersion {

	int version;
	public GetVersion(int version)
	{
		this.version=version;
	}
	public void setVersion(int version)
	{
		this.version=version;
	}
	public int getVersion()
	{
		return this.version;
	}
	public String toString() {
        return ("Version:"+this.getVersion());
   }
}
