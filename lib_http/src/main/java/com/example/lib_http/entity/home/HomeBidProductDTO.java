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
     * data : {"homeProductDaoList":[{"id":5,"gmt_Create":"2020-03-15T05:00:00.000+0000","gmt_Modify":"2020-03-15T05:00:00.000+0000","product_Id":28,"product_Name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","category_Name":"生活百货","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","market_Price":649,"pat_Price":5,"bid_Count":5},{"id":11,"gmt_Create":"2020-03-15T05:00:00.000+0000","gmt_Modify":"2020-03-15T05:00:00.000+0000","product_Id":28,"product_Name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","category_Name":"生活百货","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","market_Price":200,"pat_Price":2,"bid_Count":3}]}
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
             * gmt_Create : 2020-03-15T05:00:00.000+0000
             * gmt_Modify : 2020-03-15T05:00:00.000+0000
             * product_Id : 28
             * product_Name : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
             * category_Name : 生活百货
             * pic : http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg
             * market_Price : 649.0
             * pat_Price : 5.0
             * bid_Count : 5
             */

            private int id;
            private String gmt_Create;
            private String gmt_Modify;
            private int product_Id;
            private String product_Name;
            private String category_Name;
            private String pic;
            private double market_Price;
            private double pat_Price;
            private int bid_Count;

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

            public String getGmt_Modify() {
                return gmt_Modify;
            }

            public void setGmt_Modify(String gmt_Modify) {
                this.gmt_Modify = gmt_Modify;
            }

            public int getProduct_Id() {
                return product_Id;
            }

            public void setProduct_Id(int product_Id) {
                this.product_Id = product_Id;
            }

            public String getProduct_Name() {
                return product_Name;
            }

            public void setProduct_Name(String product_Name) {
                this.product_Name = product_Name;
            }

            public String getCategory_Name() {
                return category_Name;
            }

            public void setCategory_Name(String category_Name) {
                this.category_Name = category_Name;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public double getMarket_Price() {
                return market_Price;
            }

            public void setMarket_Price(double market_Price) {
                this.market_Price = market_Price;
            }

            public double getPat_Price() {
                return pat_Price;
            }

            public void setPat_Price(double pat_Price) {
                this.pat_Price = pat_Price;
            }

            public int getBid_Count() {
                return bid_Count;
            }

            public void setBid_Count(int bid_Count) {
                this.bid_Count = bid_Count;
            }
        }
    }
}
