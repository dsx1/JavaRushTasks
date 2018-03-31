package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%s";
    //private static final String URL_FORMAT = "https://javarush.ru/testdata/big28data.html";
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        String vacancyQuery = "[data-qa='vacancy-serp__vacancy']";
        String titleQuery = "[data-qa='vacancy-serp__vacancy-title']";
        String compensationQuery = "[data-qa='vacancy-serp__vacancy-compensation']";
        String addressQuery = "[data-qa='vacancy-serp__vacancy-address']";
        String employerQuery = "[data-qa='vacancy-serp__vacancy-employer']";
        List<Vacancy> list = new ArrayList<>();
        int i = 0;
        Vacancy vacancy = new Vacancy();
        try {
            while (true){
                Document document = getDocument(searchString, i);
                Elements vacanciesElements = document.select(vacancyQuery);
                if (!vacanciesElements.isEmpty()){
                    for (Element element: vacanciesElements){
                        vacancy.setTitle(element.select(titleQuery).text());
                        vacancy.setCity(element.select(addressQuery).text());
                        vacancy.setCompanyName(element.select(employerQuery).text());
                        vacancy.setUrl(element.select(titleQuery).attr("href"));
                        vacancy.setSiteName("https://hh.ru");
                        if (!element.select(compensationQuery).isEmpty()){
                            vacancy.setSalary(element.select(compensationQuery).text());
                        } else {
                            vacancy.setSalary("");
                        }
                        list.add(vacancy);
                    }
                } else {
                    break;
                }
                i++;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return list;

    }

    protected Document getDocument(String searchString, int page) throws IOException{
        Document document = Jsoup.connect(String.format(URL_FORMAT,searchString,page))
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36")
                .referrer("google.com")
                .get();
        return document;
    }
}
