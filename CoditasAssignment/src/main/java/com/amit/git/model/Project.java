package com.amit.git.model;

public class Project {

	String Name;
	long Id;
	String Source;
	String self;
	String html_url;

	public Project(String name, long id,String source) {
		//super();
		Name = name;
		Id = id;
		Source=source;
		
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	
	public Project()
	{
		
	}

	public String gethtml_url() {
		if(html_url==null)
			return self;
		else
		return html_url;
	}

	public void sethtml_url(String url) {
		this.html_url = url;
	}

	public String getSelf() {
	
		if(self==null)
			return html_url;
		else
			return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

}
