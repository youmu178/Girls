package com.itbox.youzh.girls.util;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youzh on 2014/12/28.
 */
public class JsoupData {

    static ArrayList<String> mImgList;

    public static ArrayList<String> getUrl(String html) {
        mImgList = new ArrayList<>();

        Document document = Jsoup.parse(html);

        Element body = document.body();
        List<Node> nodeList = body.childNodes();
        getNode(nodeList);

        Log.d("youzh", body.text());
        return mImgList;

    }

    public static void getNode(List<Node> nodesList) {
        if (nodesList != null && nodesList.size() > 0) {
            for (Node node : nodesList) {
                List<Node> list = node.childNodes();
                getNode(list);
            }
        }
    }
}
