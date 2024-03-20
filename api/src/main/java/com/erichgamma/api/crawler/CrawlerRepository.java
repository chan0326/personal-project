package com.erichgamma.api.crawler;
import com.erichgamma.api.common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerRepository extends AbstractRepository {
    private static CrawlerRepository instance = new CrawlerRepository();
    private CrawlerRepository(){
        map = new HashMap<>();
    }
    public static CrawlerRepository getInstance(){return instance;}
    private Map<String,?>map;
    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10 * 1000).get(); //timeout 시간지연\
        Elements elems = doc.select("table.byChart");
        Iterator<Element> title = elems.select("p.title").iterator();
        Iterator<Element> artist = elems.select("p.artist").iterator();
        Iterator<Element> rank = elems.select("strong").iterator();
        Document docMelon = Jsoup.connect("https://www.melon.com/chart/index.htm").timeout(10*1000).get();
        Elements elemsMelon = docMelon.select("tbody");
        Iterator<Element> titleMelon = elemsMelon.select("div.ellipsis.rank01 > span").iterator();
        Iterator<Element> artistMelon = elemsMelon.select("div.ellipsis.rank02 span").iterator();
        Iterator<Element> rankMelon = elemsMelon.select("td span.rank").iterator();
        Map<String, Iterator<Element>> localMap = new HashMap<>();
        localMap.put("key0", title);
        localMap.put("key1", artist);
        localMap.put("key2", rank);
        localMap.put("titleMelon", titleMelon);
        localMap.put("artistMelon", artistMelon);
        localMap.put("rankMelon", rankMelon);
        map = localMap;
        return map;
    }




}
