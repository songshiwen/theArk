package org.mytuc.dstruc.group12;

public class Animal {
	
	public String species;
	public String name;
	public String gender;
	public int feedQuantity;
	public int shitQuantity;
	
	public Animal (String species, String name, String gender, int feedQuantity, int shitQuantity)
	{
		this.species = species;
		this.name = name;
		this.gender = gender;
		this.feedQuantity = feedQuantity;
		this.shitQuantity = shitQuantity;
	}
	
	public String getSpecies()
	{
		return this.species;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public Boolean isMale()
	{
		String gender = this.getGender();
		if (gender == "m") return true;
		return false;		
	}
	
	public int getFeed()
	{
		return this.feedQuantity;
	}
	
	public int getShit()
	{
		return this.shitQuantity;
	}

}
