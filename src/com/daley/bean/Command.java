package com.daley.bean;

import java.util.List;

/**
 * @author Daley Date 2016-12-3 project_name MicroMessage
 */
public class Command {
	private String id;
	private String name;
	private String description;
	private List<CommandContent> contentList;

	public Command() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CommandContent> getContentList() {
		return contentList;
	}

	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}

}
