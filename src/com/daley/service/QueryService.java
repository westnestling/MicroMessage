package com.daley.service;

import java.sql.SQLException;
import java.util.List;

import com.daley.bean.Message;
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
		MessageDao messageDao = new MessageDao();
		List<Message> messageList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			messageList = messageDao.queryMessageList(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < messageList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("回复【" + messageList.get(i).getCommand() + "】可以查看"
						+ messageList.get(i).getDescription());
			}
			return result.toString();
		}
		messageList = messageDao.queryMessageList(command, null);

		if (messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
