package com.example.lib_http.entity.home;

/**
 * Created by qiubin on 2020-03-21.
 * Describe:
 */
public class ProductDetailDTO {


    /**
     * code : 200
     * message : 操作成功
     * data : {"pmsProductModel":{"id":28,"gmtCreate":"2020-03-21T00:21:38.000+0000","gmtModified":"2020-03-21T00:21:42.000+0000","productCategoryId":2,"name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","deleteStatus":0,"sale":200,"marketPrice":1999,"currentPrice":11.2,"historicalPatCoin":"11.2,12.0,9.23,13.4","subTitle":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","stock":999,"serviceIds":"1,2,3","keywords":"小米手机","albumPics":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","categoryName":"手机数码","bids":25,"onlookers":50,"bidCountdown":"2020-05-04T20:40:10.000+0000","startPrice":0.5,"refundRate":20,"handlingFee":0.5,"markup":0.2,"curPatCoin":"0.2,0.4,0.6,0.8,1.0","curPatUserNickname":"方响,天然呆酱w ,方响,科技报馆,天然呆酱w","curPatUserAvatar":"avatar2,avatar3,avatar2,avatar1,avatar3","curPatTime":"20-04-28 08:31:31,20-04-28 08:32:40,20-04-28 09:10:11,20-04-28 10:23:39,20-04-28 11:01:51,"}}
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
        /**
         * pmsProductModel : {"id":28,"gmtCreate":"2020-03-21T00:21:38.000+0000","gmtModified":"2020-03-21T00:21:42.000+0000","productCategoryId":2,"name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","deleteStatus":0,"sale":200,"marketPrice":1999,"currentPrice":11.2,"historicalPatCoin":"11.2,12.0,9.23,13.4","subTitle":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","stock":999,"serviceIds":"1,2,3","keywords":"小米手机","albumPics":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","categoryName":"手机数码","bids":25,"onlookers":50,"bidCountdown":"2020-05-04T20:40:10.000+0000","startPrice":0.5,"refundRate":20,"handlingFee":0.5,"markup":0.2,"curPatCoin":"0.2,0.4,0.6,0.8,1.0","curPatUserNickname":"方响,天然呆酱w ,方响,科技报馆,天然呆酱w","curPatUserAvatar":"avatar2,avatar3,avatar2,avatar1,avatar3","curPatTime":"20-04-28 08:31:31,20-04-28 08:32:40,20-04-28 09:10:11,20-04-28 10:23:39,20-04-28 11:01:51,"}
         */

        private PmsProductModel pmsProductModel;

        public PmsProductModel getPmsProductModel() {
            return pmsProductModel;
        }

        public void setPmsProductModel(PmsProductModel pmsProductModel) {
            this.pmsProductModel = pmsProductModel;
        }

        public static class PmsProductModel {
            /**
             * id : 28
             * gmtCreate : 2020-03-21T00:21:38.000+0000
             * gmtModified : 2020-03-21T00:21:42.000+0000
             * productCategoryId : 2
             * name : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
             * pic : /20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg
             * deleteStatus : 0
             * sale : 200
             * marketPrice : 1999.0
             * currentPrice : 11.2
             * historicalPatCoin : 11.2,12.0,9.23,13.4
             * subTitle : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
             * stock : 999
             * serviceIds : 1,2,3
             * keywords : 小米手机
             * albumPics : /20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg
             * categoryName : 手机数码
             * bids : 25
             * onlookers : 50
             * bidCountdown : 2020-05-04T20:40:10.000+0000
             * startPrice : 0.5
             * refundRate : 20
             * handlingFee : 0.5
             * markup : 0.2
             * curPatCoin : 0.2,0.4,0.6,0.8,1.0
             * curPatUserNickname : 方响,天然呆酱w ,方响,科技报馆,天然呆酱w
             * curPatUserAvatar : avatar2,avatar3,avatar2,avatar1,avatar3
             * curPatTime : 20-04-28 08:31:31,20-04-28 08:32:40,20-04-28 09:10:11,20-04-28 10:23:39,20-04-28 11:01:51,
             */

            private int id;
            private String gmtCreate;
            private String gmtModified;
            private int productCategoryId;
            private String name;
            private String pic;
            private int deleteStatus;
            private int sale;
            private double marketPrice;
            private double currentPrice;
            private String historicalPatCoin;
            private String subTitle;
            private int stock;
            private String serviceIds;
            private String keywords;
            private String albumPics;
            private String categoryName;
            private int bids;
            private int onlookers;
            private String bidCountdown;
            private double startPrice;
            private int refundRate;
            private double handlingFee;
            private double markup;
            private String curPatCoin;
            private String curPatUserNickname;
            private String curPatUserAvatar;
            private String curPatTime;

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

            public String getGmtModified() {
                return gmtModified;
            }

            public void setGmtModified(String gmtModified) {
                this.gmtModified = gmtModified;
            }

            public int getProductCategoryId() {
                return productCategoryId;
            }

            public void setProductCategoryId(int productCategoryId) {
                this.productCategoryId = productCategoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getDeleteStatus() {
                return deleteStatus;
            }

            public void setDeleteStatus(int deleteStatus) {
                this.deleteStatus = deleteStatus;
            }

            public int getSale() {
                return sale;
            }

            public void setSale(int sale) {
                this.sale = sale;
            }

            public double getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(double marketPrice) {
                this.marketPrice = marketPrice;
            }

            public double getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(double currentPrice) {
                this.currentPrice = currentPrice;
            }

            public String getHistoricalPatCoin() {
                return historicalPatCoin;
            }

            public void setHistoricalPatCoin(String historicalPatCoin) {
                this.historicalPatCoin = historicalPatCoin;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }

            public String getServiceIds() {
                return serviceIds;
            }

            public void setServiceIds(String serviceIds) {
                this.serviceIds = serviceIds;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getAlbumPics() {
                return albumPics;
            }

            public void setAlbumPics(String albumPics) {
                this.albumPics = albumPics;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public int getBids() {
                return bids;
            }

            public void setBids(int bids) {
                this.bids = bids;
            }

            public int getOnlookers() {
                return onlookers;
            }

            public void setOnlookers(int onlookers) {
                this.onlookers = onlookers;
            }

            public String getBidCountdown() {
                return bidCountdown;
            }

            public void setBidCountdown(String bidCountdown) {
                this.bidCountdown = bidCountdown;
            }

            public double getStartPrice() {
                return startPrice;
            }

            public void setStartPrice(double startPrice) {
                this.startPrice = startPrice;
            }

            public int getRefundRate() {
                return refundRate;
            }

            public void setRefundRate(int refundRate) {
                this.refundRate = refundRate;
            }

            public double getHandlingFee() {
                return handlingFee;
            }

            public void setHandlingFee(double handlingFee) {
                this.handlingFee = handlingFee;
            }

            public double getMarkup() {
                return markup;
            }

            public void setMarkup(double markup) {
                this.markup = markup;
            }

            public String getCurPatCoin() {
                return curPatCoin;
            }

            public void setCurPatCoin(String curPatCoin) {
                this.curPatCoin = curPatCoin;
            }

            public String getCurPatUserNickname() {
                return curPatUserNickname;
            }

            public void setCurPatUserNickname(String curPatUserNickname) {
                this.curPatUserNickname = curPatUserNickname;
            }

            public String getCurPatUserAvatar() {
                return curPatUserAvatar;
            }

            public void setCurPatUserAvatar(String curPatUserAvatar) {
                this.curPatUserAvatar = curPatUserAvatar;
            }

            public String getCurPatTime() {
                return curPatTime;
            }

            public void setCurPatTime(String curPatTime) {
                this.curPatTime = curPatTime;
            }
        }
    }
}
