package com.example.lib_http.entity.home;

import java.util.List;

/**
 * Created by qiubin on 2020-04-19.
 * Describe:热门话题排行榜
 */
public class TopicListDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : {"hotTopicList":[{"id":1,"secTopicName":"我买过的惊喜好物","isHot":0},{"id":2,"secTopicName":"颜值给你带来的影响","isHot":0},{"id":3,"secTopicName":"穿出来的女团风","isHot":1},{"id":4,"secTopicName":"减龄穿搭怎么选","isHot":1},{"id":5,"secTopicName":"装点你的美好生活","isHot":0},{"id":6,"secTopicName":"荣耀30手机抢先买","isHot":1},{"id":7,"secTopicName":"我买过的惊喜好物","isHot":0},{"id":8,"secTopicName":"颜值给你带来的影响","isHot":1},{"id":9,"secTopicName":"穿出来的女团风","isHot":0},{"id":10,"secTopicName":"减龄穿搭怎么选","isHot":0},{"id":11,"secTopicName":"装点你的美好生活","isHot":0},{"id":12,"secTopicName":"荣耀30手机抢先买","isHot":0},{"id":13,"secTopicName":"我买过的惊喜好物","isHot":1},{"id":14,"secTopicName":"颜值给你带来的影响","isHot":0},{"id":15,"secTopicName":"穿出来的女团风","isHot":1},{"id":16,"secTopicName":"减龄穿搭怎么选","isHot":0},{"id":17,"secTopicName":"装点你的美好生活","isHot":0},{"id":18,"secTopicName":"荣耀30手机抢先买","isHot":0},{"id":19,"secTopicName":"我买过的惊喜好物","isHot":0},{"id":20,"secTopicName":"颜值给你带来的影响","isHot":0}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<HotTopicListBean> hotTopicList;

        public List<HotTopicListBean> getHotTopicList() {
            return hotTopicList;
        }

        public void setHotTopicList(List<HotTopicListBean> hotTopicList) {
            this.hotTopicList = hotTopicList;
        }

        public static class HotTopicListBean {
            /**
             * id : 1
             * secTopicName : 我买过的惊喜好物
             * isHot : 0
             */

            private int id;
            private String secTopicName;
            private int isHot;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSecTopicName() {
                return secTopicName;
            }

            public void setSecTopicName(String secTopicName) {
                this.secTopicName = secTopicName;
            }

            public int getIsHot() {
                return isHot;
            }

            public void setIsHot(int isHot) {
                this.isHot = isHot;
            }
        }
    }
}
