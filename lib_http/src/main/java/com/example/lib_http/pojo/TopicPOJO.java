package com.example.lib_http.pojo;

/**
 * Created by qiubin on 2020-04-26.
 * Describe:发布帖子 DTO
 */
public class TopicPOJO {

    private String topicType;
    private String topicSecType;
    private String topicContent;

    public TopicPOJO() {
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getTopicSecType() {
        return topicSecType;
    }

    public void setTopicSecType(String topicSecType) {
        this.topicSecType = topicSecType;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    @Override
    public String toString() {
        return "TopicPOJO{" +
                "topicType='" + topicType + '\'' +
                ", topicSecType='" + topicSecType + '\'' +
                ", topicContent='" + topicContent + '\'' +
                '}';
    }
}
