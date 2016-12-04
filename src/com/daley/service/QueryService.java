package com.daley.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.daley.bean.Command;
import com.daley.bean.CommandContent;
import com.daley.bean.Message;
import com.daley.dao.CommandDAO;
import com.daley.dao.MessageDao;
import com.daley.util.Iconst;

/**
 * @author Daley Date 2016-11-28 project_name MicroMessage
 */
public class QueryService {
	public List<Message> queryMessageList(String command, String description)
			throws ClassNotFoundException, SQLException {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}

	public String queryByCommand(String command) {
		CommandDAO commandDao = new CommandDAO();
		List<Command> commandList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < commandList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("回复【" + commandList.get(i).getName() + "】可以查看"
						+ commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);

		if (commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0)
					.getContentList();
			int i = new Random().nextInt(contentList.size()+1);
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
