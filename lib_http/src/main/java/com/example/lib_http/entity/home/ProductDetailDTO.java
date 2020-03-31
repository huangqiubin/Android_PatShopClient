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
            private String gmt_Create;
            private String gmt_Modified;
            private int product_Category_Id;
            private String name;
            private String pic;
            private int delete_Status;
            private int sale;
            private double market_Price;
            private double current_price;
            private String historical_Pat_Coin;
            private String sub_Title;
            private int stock;
            private String service_Ids;
            private String keywords;
            private String album_Pics;
            private String category_Name;
            private int bids;
            private int onlookers;
            private Date bid_Countdown;
            private double start_Price;
            private int refund_Rate;
            private double handling_Fee;
            private double markup;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGmt_Create() {
                return gmt_Create;
            }

            public void setGmt_Create(String gmt_Create) {
                this.gmt_Create = gmt_Create;
            }

            public String getGmt_Modified() {
                return gmt_Modified;
            }

            public void setGmt_Modified(String gmt_Modified) {
                this.gmt_Modified = gmt_Modified;
            }

            public int getProduct_Category_Id() {
                return product_Category_Id;
            }

            public void setProduct_Category_Id(int product_Category_Id) {
                this.product_Category_Id = product_Category_Id;
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

            public int getDelete_Status() {
                return delete_Status;
            }

            public void setDelete_Status(int delete_Status) {
                this.delete_Status = delete_Status;
            }

            public int getSale() {
                return sale;
            }

            public void setSale(int sale) {
                this.sale = sale;
            }

            public double getMarket_Price() {
                return market_Price;
            }

            public void setMarket_Price(double market_Price) {
                this.market_Price = market_Price;
            }

            public String getHistorical_Pat_Coin() {
                return historical_Pat_Coin;
            }

            public void setHistorical_Pat_Coin(String historical_Pat_Coin) {
                this.historical_Pat_Coin = historical_Pat_Coin;
            }

            public String getSub_Title() {
                return sub_Title;
            }

            public void setSub_Title(String sub_Title) {
                this.sub_Title = sub_Title;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }

            public String getService_Ids() {
                return service_Ids;
            }

            public void setService_Ids(String service_Ids) {
                this.service_Ids = service_Ids;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getAlbum_Pics() {
                return album_Pics;
            }

            public void setAlbum_Pics(String album_Pics) {
                this.album_Pics = album_Pics;
            }

            public String getCategory_Name() {
                return category_Name;
            }

            public void setCategory_Name(String category_Name) {
                this.category_Name = category_Name;
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

            public Date getBid_Countdown() {
                return bid_Countdown;
            }

            public void setBid_Countdown(Date bid_Countdown) {
                this.bid_Countdown = bid_Countdown;
            }

            public double getStart_Price() {
                return start_Price;
            }

            public void setStart_Price(double start_Price) {
                this.start_Price = start_Price;
            }

            public int getRefund_Rate() {
                return refund_Rate;
            }

            public void setRefund_Rate(int refund_Rate) {
                this.refund_Rate = refund_Rate;
            }

            public double getHandling_Fee() {
                return handling_Fee;
            }

            public void setHandling_Fee(double handling_Fee) {
                this.handling_Fee = handling_Fee;
            }

            public double getMarkup() {
                return markup;
            }

            public void setMarkup(double markup) {
                this.markup = markup;
            }

            public double getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(double current_price) {
                this.current_price = current_price;
            }
        }
    }
}
