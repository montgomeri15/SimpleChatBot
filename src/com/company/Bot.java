package com.company;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

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
    final Map<String, String> QUESTIONS_PATTERNS = new HashMap<String, String>(){
        {
            //hello
            put("привет", "hello");
            put("хай", "hello");
            put("хелло", "hello");
            //who
            put("кто\\s.*ты", "who");
            put("ты\\s.*кто", "who");
            //name
            put("как\\s.*зовут", "name");
            put("как\\s.*имя", "name");
            put("какое\\s.*имя", "name");
            put("есть\\s.*имя", "name");
            //howeareyou
            put("как\\s.*дела", "howeareyou");
            put("как\\s.*жизнь", "howeareyou");
            //time
            put("который\\s.*час", "time");
            put("сколько\\s.*время", "time");
            put("сколько\\s.*времени", "time");
            //day
            put("какой\\s.*день", "day");
            put("какая\\s.*дата", "day");
            put("какое\\s.*число", "day");
        }
    };
    final Map<String, String> ANSWERS_PATTERNS = new HashMap<String, String>(){
        {
            put("hello", "Привет!");
            put("who", "Я простой чат-бот. Но скоро ты сделаешь меня крутым! :)");
            put("name", "Называй меня Терон.");
            put("howeareyou", "Хорошо. А ты как?");
        }
    };
    Pattern pattern;
    Random random;
    Date date;
    SimpleDateFormat time, day;

    public Bot(){
        random = new Random();
        date = new Date();
        time = new SimpleDateFormat("HH:mm");
        day = new SimpleDateFormat("dd.MM.yyyy");
    }

    public String botTalk(String ourMessage){
        ourMessage = String.join(" ", ourMessage.toLowerCase().split("[ {,|.}?]%"));  //Маленький шрифт (нижний регистр)
        String hisTalking;

        //Этот блок отвечает за рядовые фразы и ответы
        hisTalking = (ourMessage.trim().endsWith("?")) ?
                ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)] :
                COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];

        //В этом блоке перебираем ключ-значение вопросов. Если есть совпадения, меняем hisTalking.
        for (Map.Entry<String, String> o : QUESTIONS_PATTERNS.entrySet()){
            pattern = Pattern.compile(o.getKey());
            if (pattern.matcher(ourMessage).find()){
                if (o.getValue().equals("time")){
                    hisTalking = time.format(date);
                } else if (o.getValue().equals("day")){
                    hisTalking = day.format(date);
                } else {
                    hisTalking = ANSWERS_PATTERNS.get(o.getValue());
                }
            }
        }
        return hisTalking;
    }
}
