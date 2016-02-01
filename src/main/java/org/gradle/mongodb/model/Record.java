package org.gradle.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Record {

	@Id
	private String id;

	private String path;
	private String name;
	private String type;
	private String size;
	private String extension;
	private String owner;
	private String date;
	
	public Record(){}
	
	public Record(String path, String name, String type, String size, String extension, String owner, String date) {
		super();
		this.path = path;
		this.name = name;
		this.type = type;
		this.size = size;
		this.extension = extension;
		this.owner = owner;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		String str = String.format(
                "'File':{\n"
              + "		'Id': %s,\n"
              + "		'Name': '%s',\n"
              + "		'Type': '%s',\n"
              + "		'Extension': '%s',\n"
              + "		'Size': '%s',\n"
              + "		'Owner': '%s',\n"
              + "		'Date': '%s',\n"
              + "		'Path': '%s',\n"
              + "		},\n",
                id, name, type, extension, size, owner, date, path);
		
//		String str = 
//				"File id: " + id +"\n"+
//				"Name: " + name +"\n"+
//				"Type: " + type +"\n"+
//				"Extension: " + extension +"\n"+
//				"Size: " + size +"\n"+
//				"Owner: " + owner +"\n"+
//				"Date: " + date +"\n"+
//				"Path: " + path +"\n";
		
		return str;
	}	
	
}
