package logo.module;

public class SiteUrl
{
	private String indexUrl;                              
	private String memberUrl;                          
	private String itemUrl;                               
	
	public String indexUrl()                              
	{
		indexUrl="http://www.aolaigo.com";               
		return indexUrl;
	}
	
	public String memberUrl()                            
	{
		memberUrl="http://member.aolaigo.com/login.aspx"; 
		return memberUrl;
	}
	
	public String itemUrl()                               
	{
		itemUrl="http://item.aolaigo.com";                
		return itemUrl;
	}

}
