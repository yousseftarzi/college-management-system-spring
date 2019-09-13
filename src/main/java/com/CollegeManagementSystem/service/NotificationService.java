package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Notification;

public interface NotificationService {

	void save(Notification notification);

	void update(Notification notification);

	void delete(int id);

	List<Notification> findByRecipientId(int recipientId);

	Notification findById(int id);
}
