package com.daley.service;

import java.util.ArrayList;
import java.util.List;
import com.daley.dao.MessageDao;

/**
 * @author Daley Date 2016-11-30 project_name MicroMessage
 */
// 维护相关的业务
public class MaintainService {
	// 单条删除
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}

	public void deleteBatch(String[] ids) {
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		try {
			for (String id : ids) {
				idList.add(Integer.valueOf(id));
			}
			messageDao.deleteBatch(idList);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
