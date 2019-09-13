package com.CollegeManagementSystem.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.NotificationDAO;
import com.CollegeManagementSystem.model.Notification;
import com.CollegeManagementSystem.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationDAO notificationDAO;

	@Override
	public void save(Notification notification) {
		notificationDAO.save(notification);

	}

	@Override
	@Transactional
	public void update(Notification notification) {
		notificationDAO.update(notification);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Notification notification = this.findById(id);
		notificationDAO.delete(notification);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Notification> findByRecipientId(int recipientId) {
		Criterion criterion = Restrictions.eq("recipient.id", recipientId);
		List<Notification> notifications = notificationDAO.findByCriteria(Notification.class, criterion);
		return notifications;
	}

	@Override
	@Transactional
	public Notification findById(int id) {
		return (Notification) notificationDAO.find(Notification.class, id);
	}

}
