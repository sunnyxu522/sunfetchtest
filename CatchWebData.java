package cn.tf.sun;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import util.HttpClientUtil;


public class CatchWebData {
	

	public static void main(String[] args) {
		String url ="https://medium.com/_/graphql";
		
		HttpClientUtil httpUtil = new HttpClientUtil();
        // 构建GraphQL查询的请求参数
        JSONObject variables = new JSONObject();
        try {
            variables.put("tagSlug", "software-engineering");
            JSONObject paging = new JSONObject();
            paging.put("from", "0");
            paging.put("to", "11");
            paging.put("limit", 11);
            paging.put("source", "");
            variables.put("paging", paging);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject queryJson = new JSONObject();
        try {
            queryJson.put("operationName", "TagRecommendedFeedQuery");
            queryJson.put("variables", variables);
            queryJson.put("query", "query TagRecommendedFeedQuery($tagSlug: String!, $paging: PagingOptions) {\n  tagFromSlug(tagSlug: $tagSlug) {\n    id\n    viewerEdge {\n      id\n      recommendedPostsFeed(paging: $paging) {\n        items {\n          feedId\n          reason\n          moduleSourceEncoding\n          post {\n            ...StreamPostPreview_post\n            __typename\n          }\n          __typename\n        }\n        pagingInfo {\n          next {\n            from\n            limit\n            source\n            to\n            __typename\n          }\n          __typename\n        }\n        __typename\n      }\n      __typename\n    }\n    __typename\n  }\n}\n\nfragment StreamPostPreview_post on Post {\n  id\n  ...StreamPostPreviewContent_post\n    __typename\n}\n\nfragment StreamPostPreviewContent_post on Post {\n  id\n  title\n        ...PostPreviewFooter_post\n     __typename\n}\n\nfragment PostPreviewFooter_post on Post {\n    ...PostPreviewFooterMenu_post\n  __typename\n  id\n}\n\nfragment MultiVoteCount_post on Post {\n  id\n  __typename\n}\n\nfragment PostPreviewFooterMenu_post on Post {\n    collection {\n    __typename\n    id\n  }\n    ...ExpandablePostCardOverflowButton_post\n  __typename\n  id\n}\n\nfragment ExpandablePostCardOverflowButton_post on Post {\n    ...ExpandablePostCardReaderButton_post\n  __typename\n  id\n}\n\nfragment ExpandablePostCardReaderButton_post on Post {\n  id\n  collection {\n    id\n    __typename\n  }\n  mediumUrl\n  clapCount\n  ...ClapMutation_post\n  __typename\n}\n\nfragment ClapMutation_post on Post {\n  __typename\n  id\n  clapCount\n  ...MultiVoteCount_post\n}\n\n");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(queryJson);
        System.out.println(jsonArray.toString());
        //获取graphql请求返回的json数组
        String jsonReponse = httpUtil.doPostWithParam(url, jsonArray.toString());
        System.out.println(jsonReponse);
        JSONArray jsonArrayRe = new JSONArray(jsonReponse);
        JSONObject data = jsonArray.getJSONObject(0).getJSONObject("data");
        JSONObject tagFromSlug = data.getJSONObject("tagFromSlug");
        JSONArray items = tagFromSlug.getJSONArray("viewerEdge");
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
