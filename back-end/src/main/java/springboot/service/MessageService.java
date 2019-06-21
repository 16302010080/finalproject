package springboot.service;

import springboot.domain.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {

    List<Message> findAllMessage();

    List<Message> findMessageOfTS(Map<Integer,Integer> map);

    String addMessage(Message message);
}
