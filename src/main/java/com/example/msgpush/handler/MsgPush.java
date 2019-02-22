package com.example.msgpush.handler;

import com.example.msgpush.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class MsgPush {

    protected static final Logger log = LoggerFactory.getLogger(MsgPush.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 每秒向所有在线客户端发送数据
     * @return
     */
    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/greeting")
    public void msgPush(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Message message = new Message();
        message.setId(new Date().getTime()+"");
        message.setContent("你好！"+df.format(new Date()));
        message.setTheme("数据流通中断，告警");
        message.setLevel(1);
        message.setType("告警");
        messagingTemplate.convertAndSend("/topic/greetings", message);
    }

}
