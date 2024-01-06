package cn.tf.sun;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsing {
    public static void main(String[] args) {
        String jsonStr = "[\r\n" + 
        		"    {\r\n" + 
        		"        \"data\": {\r\n" + 
        		"            \"staffPicksFeed\": {\r\n" + 
        		"                \"items\": [\r\n" + 
        		"                    {\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"Living Color: Designing through synesthesia\",\r\n" + 
        		"                            \"mediumUrl\": \"https://medium.com/microsoft-design/living-color-designing-through-synesthesia-0dc273cffed3\",\r\n" + 
        		"                            \"clapCount\": 4338\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"                    {\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"How The New York Times Cooking Team Makes Personalized Recipe Recommendations\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 330\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		" 	{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations1111\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 5673\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"	{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations2222\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 3452\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"	{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations3333\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 12311\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"	{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations444\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 3421\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"	{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations5555\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 890\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"	{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations66666\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 906\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"	{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations7777\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 6532\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"	{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations8888\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 88\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"{\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"title  Recommendations99999\",\r\n" + 
        		"                            \"mediumUrl\": \"https://open.nytimes.com/how-the-new-york-times-cooking-team-makes-personalized-recipe-recommendations-7b86df9b22ec\",\r\n" + 
        		"                            \"visibility\": \"PUBLIC\",\r\n" + 
        		"                            \"isPublished\": true,\r\n" + 
        		"                            \"clapCount\": 99\r\n" + 
        		"                        }\r\n" + 
        		"                    },\r\n" + 
        		"                    {\r\n" + 
        		"                        \"__typename\": \"HomeFeedItem\",\r\n" + 
        		"                        \"post\": {\r\n" + 
        		"                            \"title\": \"Building Bridges, Not Barriers: Humanizing the Israeli-Palestine Conflict\",\r\n" + 
        		"                            \"mediumUrl\": \"https://medium.com/moments-of-passion/building-bridges-not-barriers-humanizing-the-israeli-palestine-conflict-b8b6fd5a9cea\",\r\n" + 
        		"                            \"clapCount\": 3934\r\n" + 
        		"                        }\r\n" + 
        		"                    }                  \r\n" + 
        		"                ],\r\n" + 
        		"                \"pagingInfo\": {\r\n" + 
        		"                    \"next\": {\r\n" + 
        		"                        \"page\": 0,\r\n" + 
        		"                        \"limit\": 10,\r\n" + 
        		"                        \"from\": \"90\",\r\n" + 
        		"                        \"__typename\": \"PageParams\"\r\n" + 
        		"                    },\r\n" + 
        		"                    \"__typename\": \"Paging\"\r\n" + 
        		"                },\r\n" + 
        		"                \"__typename\": \"StaffPicksFeedResult\"\r\n" + 
        		"            }\r\n" + 
        		"        }\r\n" + 
        		"    }\r\n" + 
        		"]";

        JSONArray jsonArray = new JSONArray(jsonStr);
        JSONObject data = jsonArray.getJSONObject(0).getJSONObject("data");
        JSONObject staffPicksFeed = data.getJSONObject("staffPicksFeed");
        JSONArray items = staffPicksFeed.getJSONArray("items");
        //使用优先序列结构，初始化10个大小，保留点赞数top10
        TopArticlesStorage  Articles = new TopArticlesStorage();
        System.out.println("1、解析文章列表的标题、文章链接URL和点赞数ClapCount");
        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            JSONObject post = item.getJSONObject("post");
            String title = post.getString("title");
            String mediumUrl = post.getString("mediumUrl");
            int clapCount = post.getInt("clapCount");
            
            System.out.println("Clap Count: " + clapCount + ", Medium URL: " + mediumUrl + ", title: " + title);
            Articles.addArticle(title, mediumUrl, clapCount);
        }
        //获取Articles的top10
        System.out.println("2、文章列表按照点赞数算法top10");
        Articles.printTopArticles();
    }
}

