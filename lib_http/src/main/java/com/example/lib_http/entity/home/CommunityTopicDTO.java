package com.example.lib_http.entity.home;

import java.util.List;

/**
 * Created by qiubin on 2020-04-16.
 * Describe:
 */
public class CommunityTopicDTO {


    /**
     * code : 200
     * message : 操作成功
     * data : {"topicList":[{"id":1,"topicType":0,"topicContent":"刚收到货，手机好漂亮，未拆封，未激活，原装正品，官网旗舰店值得信赖，一直纠结手机颜色，这个颜色好喜欢，客服好有耐心，谢谢了！必须给5星，下次介绍朋友来买，物流速度飞快，上午下单，下午18.30就收到了，未发现什么缺点，要是送个无线充电器就好了！哈哈！👍👍👍👍👍👍","topicImage":"1.","userId":11,"userNickName":null,"createTime":"2020-04-16T00:26:51.000+0000","topicCategory":"数码","topicTitle":null,"smsSecTopic":{"id":1,"secTopicName":"我买过的惊喜好物"},"hotTopic":1}]}
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
        private List<TopicListBean> topicList;

        public List<TopicListBean> getTopicList() {
            return topicList;
        }

        public void setTopicList(List<TopicListBean> topicList) {
            this.topicList = topicList;
        }

        public static class TopicListBean {
            /**
             * id : 1
             * topicType : 0
             * topicContent : 刚收到货，手机好漂亮，未拆封，未激活，原装正品，官网旗舰店值得信赖，一直纠结手机颜色，这个颜色好喜欢，客服好有耐心，谢谢了！必须给5星，下次介绍朋友来买，物流速度飞快，上午下单，下午18.30就收到了，未发现什么缺点，要是送个无线充电器就好了！哈哈！👍👍👍👍👍👍
             * topicImage : 1.
             * userId : 11
             * userNickName : null
             * createTime : 2020-04-16T00:26:51.000+0000
             * topicCategory : 数码
             * topicTitle : null
             * smsSecTopic : {"id":1,"secTopicName":"我买过的惊喜好物"}
             * hotTopic : 1
             */

            private int id;
            private int topicType;
            private String topicContent;
            private String topicImage;
            private int userId;
            private String userNickName;
            private String userAvatar;
            private String createTime;
            private String topicCategory;
            private String topicTitle;
            private SmsSecTopicBean smsSecTopic;
            private int hotTopic;
            private float topicHotValue;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTopicType() {
                return topicType;
            }

            public void setTopicType(int topicType) {
                this.topicType = topicType;
            }

            public String getTopicContent() {
                return topicContent;
            }

            public void setTopicContent(String topicContent) {
                this.topicContent = topicContent;
            }

            public String getTopicImage() {
                return topicImage;
            }

            public void setTopicImage(String topicImage) {
                this.topicImage = topicImage;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getTopicCategory() {
                return topicCategory;
            }

            public void setTopicCategory(String topicCategory) {
                this.topicCategory = topicCategory;
            }

            public SmsSecTopicBean getSmsSecTopic() {
                return smsSecTopic;
            }

            public void setSmsSecTopic(SmsSecTopicBean smsSecTopic) {
                this.smsSecTopic = smsSecTopic;
            }

            public int getHotTopic() {
                return hotTopic;
            }

            public void setHotTopic(int hotTopic) {
                this.hotTopic = hotTopic;
            }

            public String getUserNickName() {
                return userNickName;
            }

            public void setUserNickName(String userNickName) {
                this.userNickName = userNickName;
            }

            public String getTopicTitle() {
                return topicTitle;
            }

            public void setTopicTitle(String topicTitle) {
                this.topicTitle = topicTitle;
            }

            public float getTopicHotValue() {
                return topicHotValue;
            }

            public void setTopicHotValue(float topicHotValue) {
                this.topicHotValue = topicHotValue;
            }

            public String getUserAvatar() {
                return userAvatar;
            }

            public void setUserAvatar(String userAvatar) {
                this.userAvatar = userAvatar;
            }

            public static class SmsSecTopicBean {
                /**
                 * id : 1
                 * secTopicName : 我买过的惊喜好物
                 */

                private int id;
                private String secTopicName;

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
            }
        }
    }
}