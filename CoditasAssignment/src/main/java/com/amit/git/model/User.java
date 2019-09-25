package com.amit.git.model;

public class User {
	
	long Id;
	String name;
	String login;
	String Source;
	public User(String name, long id) {
		super();
	
		Id = id;
		this.name = name;
	}



	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		if(name==null)
			return login;
			else
			return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	User()
	{
		
	}



	public String getLogin() {
		if(login==null)
		return name;
		else
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSource() {
		return Source;
	}



	public void setSource(String Source) {
		this.Source = Source;
	}


}
