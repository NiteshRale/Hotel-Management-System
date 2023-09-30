package com.pojo;

public class Food 
{
	private int foodId;
	private String fName;
	private String fType;
	private int fQuantity;
	private float fPrice;
	
	public Food()
	{
		super();
	}

	public Food(int foodId, String fName, String fType, int fQuantity, float fPrice) 
	{
		super();
		this.foodId = foodId;
		this.fName = fName;
		this.fType = fType;
		this.fQuantity = fQuantity;
		this.fPrice = fPrice;
	}

	public int getFoodId() 
	{
		return foodId;
	}

	public void setFoodId(int foodId) 
	{
		this.foodId = foodId;
	}

	public String getfName() 
	{
		return fName;
	}

	public void setfName(String fName) 
	{
		this.fName = fName;
	}

	public String getfType() 
	{
		return fType;
	}

	public void setfType(String fType) 
	{
		this.fType = fType;
	}

	public int getfQuantity() 
	{
		return fQuantity;
	}

	public void setfQuantity(int fQuantity) 
	{
		this.fQuantity = fQuantity;
	}

	public float getfPrice() 
	{
		return fPrice;
	}

	public void setfPrice(float fPrice) 
	{
		this.fPrice = fPrice;
	}

	@Override
	public String toString() 
	{
		return "Food [foodId=" + foodId + ", fName=" + fName + ", fType=" + fType + ", fQuantity=" + fQuantity
				+ ", fPrice=" + fPrice + "]";
	}

}
