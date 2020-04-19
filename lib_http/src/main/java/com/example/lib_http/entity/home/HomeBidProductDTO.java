package com.example.lib_http.entity.home;

import java.util.List;

/**
 * Created by qiubin on 2020-03-19.
 * Describe:
 */
public class HomeBidProductDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : {"homeProductDaoList":[{"id":5,"gmtCreate":"2020-03-15T05:00:00.000+0000","gmtModify":"2020-03-15T05:00:00.000+0000","productId":28,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"生活百货","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","marketPrice":649,"patPrice":5,"bidCount":5},{"id":11,"gmtCreate":"2020-03-15T05:00:00.000+0000","gmtModify":"2020-03-15T05:00:00.000+0000","productId":28,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"生活百货","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","marketPrice":200,"patPrice":2,"bidCount":3}]}
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
        private List<HomeProductDaoListBean> homeProductDaoList;

        public List<HomeProductDaoListBean> getHomeProductDaoList() {
            return homeProductDaoList;
        }

        public void setHomeProductDaoList(List<HomeProductDaoListBean> homeProductDaoList) {
            this.homeProductDaoList = homeProductDaoList;
        }

        public static class HomeProductDaoListBean {
            /**
             * id : 5
             * gmtCreate : 2020-03-15T05:00:00.000+0000
             * gmtModify : 2020-03-15T05:00:00.000+0000
             * productId : 28
             * productName : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
             * categoryName : 生活百货
             * pic : http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg
             * marketPrice : 649.0
             * patPrice : 5.0
             * bidCount : 5
             */

            private int id;
            private String gmtCreate;
            private String gmtModify;
            private int productId;
            private String productName;
            private String categoryName;
            private String pic;
            private double marketPrice;
            private double patPrice;
            private int bidCount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGmtCreate() {
                return gmtCreate;
            }

            public void setGmtCreate(String gmtCreate) {
                this.gmtCreate = gmtCreate;
            }

            public String getGmtModify() {
                return gmtModify;
            }

            public void setGmtModify(String gmtModify) {
                this.gmtModify = gmtModify;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public double getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(double marketPrice) {
                this.marketPrice = marketPrice;
            }

            public double getPatPrice() {
                return patPrice;
            }

            public void setPatPrice(double patPrice) {
                this.patPrice = patPrice;
            }

            public int getBidCount() {
                return bidCount;
            }

            public void setBidCount(int bidCount) {
                this.bidCount = bidCount;
            }
        }
    }
}
