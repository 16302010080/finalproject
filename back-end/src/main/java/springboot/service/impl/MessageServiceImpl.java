package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.dao.MessageDao;
import springboot.domain.Message;
import springboot.service.MessageService;

import java.util.List;
import java.util.Map;

public class MessageServiceImpl implements MessageService {

    @Autowired
    public MessageDao messageDao;
    @Override
    public List<Message> findAllMessage() {
        return messageDao.findAllMessage();
    }

    @Override
    public List<Message> findMessageOfTS(Map<Integer, Integer> map) {
        return messageDao.findMessageOfTS(map);
    }

    @Override
    public String addMessage(Message message) {
        return messageDao.addMessage(message);
    }
}
