package com.example.patshopclient.common.event;

/**
 * Description: <RequestCode><br>
 */
public interface KeyCode {
    interface Main {
    }

    interface News {
        String NEWS_TYPE = "newstype";
        String NEWS_ID = "newsid";
    }

    interface Find {
    }

    interface Me {
    }
}
