package com.dacas;

import com.dacas.dao.BoundDao;
import com.dacas.dao.CardDao;
import com.dacas.data.Bound;
import com.dacas.data.Card;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        /*****����bound��Ϣ*****/
        BoundDao boundDao = (BoundDao)context.getBean("boundDao");
        Bound bound = boundDao.getBoundById(4);
        System.out.println(bound);

        /****����card��Ϣ*****/
        CardDao cardDao = (CardDao)context.getBean("cardDao");
        Card card = cardDao.getCardById(20);
        System.out.println(card);
    }
}
