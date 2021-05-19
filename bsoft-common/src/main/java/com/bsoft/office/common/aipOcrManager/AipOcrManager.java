package com.bsoft.office.common.aipOcrManager;

import com.baidu.aip.ocr.AipOcr;

public class AipOcrManager {
    private static final String APP_ID = "19738701";
    private static final String API_KEY = "Dh0hKdH8R5ICHffPVYR1eABF";
    private static final String SECRET_KEY = "1O3obO4nG7ofWy3i2AirZqtA44V0pSwA";
    private static volatile AipOcr client;

    public AipOcrManager(){

    }

    public static AipOcr getInstance(){
        if (client == null){
            synchronized (AipOcrManager.class){
                if (client == null){
                    System.out.println("初始化 百度AipOcr Client");
                    client = new AipOcr(APP_ID,API_KEY,SECRET_KEY);
                }
            }
        }
        return client;
    }
}
