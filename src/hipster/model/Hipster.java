package hipster.model;
/**
 * creates the Hipster object.
 * @author itho1735
 *@version 1.3 11/20/2013 Added getter/setters. overloaded constructor for additional hipsters.
 */
public class Hipster
{
	private String name;
	private String hipsterType;
	private String hipsterPhrase;
	private String [] hipsterBooks;
	
	public Hipster()
	{
		hipsterBooks = new String[5];
		name = "Belra";
		hipsterType = "studentHipster";
		hipsterPhrase = "sharkbait ooh ah ah";
				
		fillTheBooks();
	}
	/**
	 * 	
	 * @param name
	 * @param hipsterType
	 * @param hipsterPhrase
	 * @param hipsterBooks
	 */
	public Hipster(String name, String hipsterType, String hipsterPhrase, String [] hipsterBooks)
	{
		this.name = name;
		this.hipsterType = hipsterType;
		this.hipsterPhrase = hipsterPhrase;
		this.hipsterBooks = hipsterBooks;
	}

	public String getName()
	{
		return name;
	}

	public String getHipsterType()
	{
		return hipsterType;
	}

	public String getHipsterPhrase()
	{
		return hipsterPhrase;
	}

	public String[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setHipsterType(String hipsterType)
	{
		this.hipsterType = hipsterType;
	}

	public void setHipsterPhrase(String hipsterPhrase)
	{
		this.hipsterPhrase = hipsterPhrase;
	}

	public void setHipsterBooks(String[] hipsterBooks)
	{
		this.hipsterBooks =  hipsterBooks;
	}
	/**
	 * fills the book arrayList.	
	 */
	private void fillTheBooks()
	{
		hipsterBooks[0] = "Harry Potter";
		hipsterBooks[1] = "The Hourglass Door";
		hipsterBooks[2] = "Fablehaven";
		hipsterBooks[3] = "Digital Fortress";
		hipsterBooks[4] = "Percy Jackson";
	}
}
