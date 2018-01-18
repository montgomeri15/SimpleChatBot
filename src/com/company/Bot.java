package com.company;

import java.util.*;

public class Bot {

    final String[] COMMON_PHRASES = {  //Общие фразы
            "Хорошо, когда есть с кем поговорить об этом, правда?",
            "Я хороший слушатель. Продолжай.",
            "Я могу назвать наше общение приятным.",
            "Кто ясно мыслит, тот ясно излагает.",
            "Приятно, когда текст написан без ошибок."
    };
    final String[] ELUSIVE_ANSWERS = {  //Уклончивые ответы
            "Мне нужно время, чтобы ответить на такой вопрос.",
            "Дай подумать.",
            "Давай сохраним интригу?)",
            "Вам действительно это интересно?",
            "Скорее всего, вы уже и сами догадались."
    };

    Random random;
    Date date;

    public Bot(){
        random = new Random();
        date = new Date();
    }

    public String botTalk(String message){
        String say = (message.trim().endsWith("?")) ?
                ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)] :
                COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];
        return say;
    }
}
