package com.Service;

import com.dao.Dao;

import Bean.AddExpense;

public class Service {

	
	public boolean insert(AddExpense add) throws Exception
	{
		Dao d=new Dao();
		boolean b=d.insert(add);
		return b;
	}
	
	public int delete(AddExpense add)throws Exception
	{
		Dao d=new Dao();
	   int n= d.delete(add);
		 if(n>0)
			 return 1;
		 else
			 return 0;
	}
	
}
