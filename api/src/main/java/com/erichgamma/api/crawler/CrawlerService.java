package com.erichgamma.api.crawler;

import java.io.IOException;
import java.util.Map;

public interface CrawlerService {
    Map<String,?> findNameFromWeb(Map<String,String>paramMap) throws IOException ;
}

