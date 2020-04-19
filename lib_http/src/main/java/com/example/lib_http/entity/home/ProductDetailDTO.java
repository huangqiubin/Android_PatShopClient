package com.example.lib_http.entity.home;

import java.util.Date;

/**
 * Created by qiubin on 2020-03-21.
 * Describe:
 */
public class ProductDetailDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : {"pmsProduct1Dao":{"id":28,"gmt_Create":"2020-03-21T00:21:38.000+0000","gmt_Modified":"2020-03-21T00:21:42.000+0000","product_Category_Id":2,"name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","delete_Status":0,"sale":200,"market_Price":1999,"historical_Pat_Coin":"11.2,12.0,9.23,13.4","sub_Title":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","stock":999,"service_Ids":"1,2,3","keywords":"小米手机","album_Pics":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","category_Name":"手机数码","bids":25,"onlookers":50,"bid_Countdown":"2020-03-31T00:59:57.000+0000","start_Price":0.5,"refund_Rate":20,"handling_Fee":2,"markup":0.02}}
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
         * pmsProduct1Dao : {"id":28,"gmt_Create":"2020-03-21T00:21:38.000+0000","gmt_Modified":"2020-03-21T00:21:42.000+0000","product_Category_Id":2,"name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","delete_Status":0,"sale":200,"market_Price":1999,"historical_Pat_Coin":"11.2,12.0,9.23,13.4","sub_Title":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","stock":999,"service_Ids":"1,2,3","keywords":"小米手机","album_Pics":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","category_Name":"手机数码","bids":25,"onlookers":50,"bid_Countdown":"2020-03-31T00:59:57.000+0000","start_Price":0.5,"refund_Rate":20,"handling_Fee":2,"markup":0.02}
         */

        private PmsProduct1DaoBean pmsProduct1Dao;

        public PmsProduct1DaoBean getPmsProduct1Dao() {
            return pmsProduct1Dao;
        }

        public void setPmsProduct1Dao(PmsProduct1DaoBean pmsProduct1Dao) {
            this.pmsProduct1Dao = pmsProduct1Dao;
        }

        public static class PmsProduct1DaoBean {
            /**
             * id : 28
             * gmt_Create : 2020-03-21T00:21:38.000+0000
             * gmt_Modified : 2020-03-21T00:21:42.000+0000
             * product_Category_Id : 2
             * name : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
             * pic : /20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg
             * delete_Status : 0
             * sale : 200
             * market_Price : 1999.0
             * historical_Pat_Coin : 11.2,12.0,9.23,13.4
             * sub_Title : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
             * stock : 999
             * service_Ids : 1,2,3
             * keywords : 小米手机
             * album_Pics : /20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg
             * category_Name : 手机数码
             * bids : 25
             * onlookers : 50
             * bid_Countdown : 2020-03-31T00:59:57.000+0000
             * start_Price : 0.5
             * refund_Rate : 20
             * handling_Fee : 2.0
             * markup : 0.02
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
            private double currentprice;
            private String historicalPatCoin;
            private String subTitle;
            private int stock;
            private String serviceIds;
            private String keywords;
            private String albumPics;
            private String categoryName;
            private int bids;
            private int onlookers;
            private Date bidCountdown;
            private double startPrice;
            private int refundRate;
            private double handlingFee;
            private double markup;

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

            public double getCurrentprice() {
                return currentprice;
            }

            public void setCurrentprice(double currentprice) {
                this.currentprice = currentprice;
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

            public Date getBidCountdown() {
                return bidCountdown;
            }

            public void setBidCountdown(Date bidCountdown) {
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
        }
    }
}
