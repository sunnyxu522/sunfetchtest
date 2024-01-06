package cn.tf.sun;

//使用java语言编程实现从medium网站获取最受欢迎的10篇文章
//要实现从Medium网站获取最受欢迎的10篇文章，可以使用Java语言结合网络请求库来实现。

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CatchMediumByJsoup {
//1、如何获取top10文章：获取所有文章的名称、作者、文章链接url以及点赞数，然后初始化10个排序空间，交换比较每次保留大的一个，直到最后；
//2、实现单个文章的抓取和对应中文生成pdf	
    public static void main(String[] args) {
    	System.out.println("start main:");
        String mediumUrl = "https://medium.com/";
        System.out.println("start main1:");
        try {
            Document doc = Jsoup.connect(mediumUrl).get();

            Elements articles = doc.select("div.js-postListHandle > div > div > div > a");

            int count = 0;
            for (Element article : articles) {
                if (count >= 10) {
                    break;
                }
                String articleTitle = article.text();
                String articleUrl = article.absUrl("href");

                System.out.println("Title: " + articleTitle);
                System.out.println("URL: " + articleUrl);
                System.out.println();

                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}