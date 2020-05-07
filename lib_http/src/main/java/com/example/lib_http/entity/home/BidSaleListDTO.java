package com.example.lib_http.entity.home;

import java.util.List;

/**
 * Created by qiubin on 2020-05-05.
 * Describe:参拍页面DTO
 */
public class BidSaleListDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : {"bidResultModelList":[{"id":2,"userId":12,"productId":28,"bidResult":3,"productBidCoin":15,"productIcon":"11.png","productBidNum":6,"productTitle":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待"}]}
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
        private List<BidResultModelListBean> bidResultModelList;

        public List<BidResultModelListBean> getBidResultModelList() {
            return bidResultModelList;
        }

        public void setBidResultModelList(List<BidResultModelListBean> bidResultModelList) {
            this.bidResultModelList = bidResultModelList;
        }

        public static class BidResultModelListBean {
            /**
             * id : 2
             * userId : 12
             * productId : 28
             * bidResult : 3
             * productBidCoin : 15.0
             * productIcon : 11.png
             * productBidNum : 6
             * productTitle : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
             */

            private int id;
            private int userId;
            private int productId;
            private int bidResult;//0竞拍成功 1竞拍失败 2领先 3落后
            private double productBidCoin;
            private String productIcon;
            private int productBidNum;
            private String productTitle;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public int getBidResult() {
                return bidResult;
            }

            public void setBidResult(int bidResult) {
                this.bidResult = bidResult;
            }

            public double getProductBidCoin() {
                return productBidCoin;
            }

            public void setProductBidCoin(double productBidCoin) {
                this.productBidCoin = productBidCoin;
            }

            public String getProductIcon() {
                return productIcon;
            }

            public void setProductIcon(String productIcon) {
                this.productIcon = productIcon;
            }

            public int getProductBidNum() {
                return productBidNum;
            }

            public void setProductBidNum(int productBidNum) {
                this.productBidNum = productBidNum;
            }

            public String getProductTitle() {
                return productTitle;
            }

            public void setProductTitle(String productTitle) {
                this.productTitle = productTitle;
            }
        }
    }
}
