package com.daley.bean;
/**
 * @author Daley
 * Date 2016-12-3
 * project_name MicroMessage
 */
public class CommandContent {
	private String id;
	private String content;
	private String commandId;
	public CommandContent(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommandId() {
		return commandId;
	}
	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}
	
}
