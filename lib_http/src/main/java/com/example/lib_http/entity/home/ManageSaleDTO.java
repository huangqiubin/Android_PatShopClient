package com.example.lib_http.entity.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qiubin on 2020/5/13.
 * Describe:
 */
public class ManageSaleDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : {"onProductList":[{"id":null,"gmtCreate":null,"gmtModify":null,"productId":31,"productName":"HLA海澜之家简约动物印花短袖T恤","categoryName":"生活百货","pic":"158933682142913.jpg,158933682142913.jpg,158933682143013.jpg,","marketPrice":399,"patPrice":0,"bidCount":0}],"endProductList":[{"id":null,"gmtCreate":null,"gmtModify":null,"productId":30,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":29,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":28,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":12,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":11,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":10,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":9,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":8,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":7,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":6,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":5,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":4,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":3,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":2,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6},{"id":null,"gmtCreate":null,"gmtModify":null,"productId":1,"productName":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","categoryName":"手机数码","pic":"11.png,11.png,11.png","marketPrice":1999,"patPrice":15,"bidCount":6}]}
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
        @SerializedName("onProductList")
        private List<HomeBidProductDTO.DataBean.HomeProductDaoListBean> onProductList;
        @SerializedName("endProductList")
        private List<HomeBidProductDTO.DataBean.HomeProductDaoListBean> endProductList;

        public List<HomeBidProductDTO.DataBean.HomeProductDaoListBean> getOnProductList() {
            return onProductList;
        }

        public void setOnProductList(List<HomeBidProductDTO.DataBean.HomeProductDaoListBean> onProductList) {
            this.onProductList = onProductList;
        }

        public List<HomeBidProductDTO.DataBean.HomeProductDaoListBean> getEndProductList() {
            return endProductList;
        }

        public void setEndProductList(List<HomeBidProductDTO.DataBean.HomeProductDaoListBean> endProductList) {
            this.endProductList = endProductList;
        }

//        public static class OnProductListBean {
//            /**
//             * id : null
//             * gmtCreate : null
//             * gmtModify : null
//             * productId : 31
//             * productName : HLA海澜之家简约动物印花短袖T恤
//             * categoryName : 生活百货
//             * pic : 158933682142913.jpg,158933682142913.jpg,158933682143013.jpg,
//             * marketPrice : 399.0
//             * patPrice : 0.0
//             * bidCount : 0
//             */
//
//            private int id;
//            private String gmtCreate;
//            private String gmtModify;
//            private int productId;
//            private String productName;
//            private String categoryName;
//            private String pic;
//            private double marketPrice;
//            private double patPrice;
//            private int bidCount;
//
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public String getGmtCreate() {
//                return gmtCreate;
//            }
//
//            public void setGmtCreate(String gmtCreate) {
//                this.gmtCreate = gmtCreate;
//            }
//
//            public String getGmtModify() {
//                return gmtModify;
//            }
//
//            public void setGmtModify(String gmtModify) {
//                this.gmtModify = gmtModify;
//            }
//
//            public int getProductId() {
//                return productId;
//            }
//
//            public void setProductId(int productId) {
//                this.productId = productId;
//            }
//
//            public String getProductName() {
//                return productName;
//            }
//
//            public void setProductName(String productName) {
//                this.productName = productName;
//            }
//
//            public String getCategoryName() {
//                return categoryName;
//            }
//
//            public void setCategoryName(String categoryName) {
//                this.categoryName = categoryName;
//            }
//
//            public String getPic() {
//                return pic;
//            }
//
//            public void setPic(String pic) {
//                this.pic = pic;
//            }
//
//            public double getMarketPrice() {
//                return marketPrice;
//            }
//
//            public void setMarketPrice(double marketPrice) {
//                this.marketPrice = marketPrice;
//            }
//
//            public double getPatPrice() {
//                return patPrice;
//            }
//
//            public void setPatPrice(double patPrice) {
//                this.patPrice = patPrice;
//            }
//
//            public int getBidCount() {
//                return bidCount;
//            }
//
//            public void setBidCount(int bidCount) {
//                this.bidCount = bidCount;
//            }
//        }
//
//        public static class EndProductListBean {
//            /**
//             * id : null
//             * gmtCreate : null
//             * gmtModify : null
//             * productId : 30
//             * productName : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
//             * categoryName : 手机数码
//             * pic : 11.png,11.png,11.png
//             * marketPrice : 1999.0
//             * patPrice : 15.0
//             * bidCount : 6
//             */
//
//            private int id;
//            private String gmtCreate;
//            private String gmtModify;
//            private int productId;
//            private String productName;
//            private String categoryName;
//            private String pic;
//            private double marketPrice;
//            private double patPrice;
//            private int bidCount;
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public String getGmtCreate() {
//                return gmtCreate;
//            }
//
//            public void setGmtCreate(String gmtCreate) {
//                this.gmtCreate = gmtCreate;
//            }
//
//            public String getGmtModify() {
//                return gmtModify;
//            }
//
//            public void setGmtModify(String gmtModify) {
//                this.gmtModify = gmtModify;
//            }
//
//            public int getProductId() {
//                return productId;
//            }
//
//            public void setProductId(int productId) {
//                this.productId = productId;
//            }
//
//            public String getProductName() {
//                return productName;
//            }
//
//            public void setProductName(String productName) {
//                this.productName = productName;
//            }
//
//            public String getCategoryName() {
//                return categoryName;
//            }
//
//            public void setCategoryName(String categoryName) {
//                this.categoryName = categoryName;
//            }
//
//            public String getPic() {
//                return pic;
//            }
//
//            public void setPic(String pic) {
//                this.pic = pic;
//            }
//
//            public double getMarketPrice() {
//                return marketPrice;
//            }
//
//            public void setMarketPrice(double marketPrice) {
//                this.marketPrice = marketPrice;
//            }
//
//            public double getPatPrice() {
//                return patPrice;
//            }
//
//            public void setPatPrice(double patPrice) {
//                this.patPrice = patPrice;
//            }
//
//            public int getBidCount() {
//                return bidCount;
//            }
//
//            public void setBidCount(int bidCount) {
//                this.bidCount = bidCount;
//            }
//        }
    }
}
