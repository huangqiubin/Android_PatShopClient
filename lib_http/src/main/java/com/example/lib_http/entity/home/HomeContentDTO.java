package com.example.lib_http.entity.home;

import java.util.List;

/**
 * Created by qiubin on 2020-03-10.
 * Describe:
 */
public class HomeContentDTO {


    /**
     * code : 200
     * message : 操作成功
     * data : {"homeAdvertiseList":[{"id":9,"name":"电影推荐广告","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/movie_ad.jpg","status":1,"click_Count":0,"order_Count":0,"url":"www.baidu.com","note":"电影推荐广告","sort":100},{"id":10,"name":"汽车促销广告","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/car_ad.jpg","status":1,"click_Count":0,"order_Count":0,"url":"xxx","note":null,"sort":99},{"id":11,"name":"汽车推荐广告","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/car_ad2.jpg","status":1,"click_Count":0,"order_Count":0,"url":"xxx","note":null,"sort":98}],"homeHotList":[{"id":1,"gmt_Create":"2020-03-15T17:10:14.000+0000","gmt_Modified":"2020-03-15T17:10:22.000+0000","product_Id":28,"product_Name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","market_Price":649,"pat_Price":5,"bid_Count":5},{"id":2,"gmt_Create":"2020-03-16T00:47:55.000+0000","gmt_Modified":"2020-03-16T00:47:59.000+0000","product_Id":28,"product_Name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","market_Price":500,"pat_Price":8,"bid_Count":6},{"id":3,"gmt_Create":"2020-03-16T00:48:41.000+0000","gmt_Modified":"2020-03-16T00:48:43.000+0000","product_Id":28,"product_Name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","market_Price":200,"pat_Price":2,"bid_Count":3},{"id":4,"gmt_Create":"2020-03-16T00:49:08.000+0000","gmt_Modified":"2020-03-16T00:49:10.000+0000","product_Id":28,"product_Name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","market_Price":900,"pat_Price":7,"bid_Count":6}],"productCategoryDaoList":[{"id":1,"gmt_Create":"2020-03-19T05:00:00.000+0000","gmt_Modified":"2020-03-19T14:43:10.000+0000","category_Name":"生活充值","level":0,"parent_Id":null,"product_Unit":"件","nav_Status":1,"show_Status":1,"icon":null,"keywords":"生活充值"},{"id":2,"gmt_Create":"2020-03-19T05:00:00.000+0000","gmt_Modified":"2020-03-19T14:44:31.000+0000","category_Name":"手机数码","level":0,"parent_Id":null,"product_Unit":"件","nav_Status":1,"show_Status":1,"icon":null,"keywords":"手机数码"},{"id":3,"gmt_Create":"2020-03-19T05:00:00.000+0000","gmt_Modified":"2020-03-19T14:45:37.000+0000","category_Name":"手办模型","level":0,"parent_Id":null,"product_Unit":"件","nav_Status":1,"show_Status":1,"icon":null,"keywords":"手办模型"},{"id":4,"gmt_Create":"2020-03-19T05:00:00.000+0000","gmt_Modified":"2020-03-19T14:46:27.000+0000","category_Name":"美妆好物","level":0,"parent_Id":null,"product_Unit":"件","nav_Status":1,"show_Status":1,"icon":null,"keywords":"美妆好物"},{"id":5,"gmt_Create":"2020-03-19T05:00:00.000+0000","gmt_Modified":"2020-03-19T14:46:59.000+0000","category_Name":"生活百货","level":0,"parent_Id":null,"product_Unit":"件","nav_Status":1,"show_Status":1,"icon":null,"keywords":"生活百货"},{"id":6,"gmt_Create":"2020-03-19T05:00:00.000+0000","gmt_Modified":"2020-03-19T14:52:00.000+0000","category_Name":"游戏点劵","level":0,"parent_Id":null,"product_Unit":"件","nav_Status":1,"show_Status":1,"icon":null,"keywords":"游戏点劵"}]}
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
        private List<HomeAdvertiseListBean> homeAdvertiseList;
        private List<ProductCategoryDaoListBean> productCategoryDaoList;

        public List<HomeAdvertiseListBean> getHomeAdvertiseList() {
            return homeAdvertiseList;
        }

        public void setHomeAdvertiseList(List<HomeAdvertiseListBean> homeAdvertiseList) {
            this.homeAdvertiseList = homeAdvertiseList;
        }

        public List<ProductCategoryDaoListBean> getProductCategoryDaoList() {
            return productCategoryDaoList;
        }

        public void setProductCategoryDaoList(List<ProductCategoryDaoListBean> productCategoryDaoList) {
            this.productCategoryDaoList = productCategoryDaoList;
        }

        public static class HomeAdvertiseListBean {
            /**
             * id : 9
             * name : 电影推荐广告
             * pic : http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/movie_ad.jpg
             * status : 1
             * click_Count : 0
             * order_Count : 0
             * url : www.baidu.com
             * note : 电影推荐广告
             * sort : 100
             */

            private int id;
            private String name;
            private String pic;
            private int status;
            private int click_Count;
            private int order_Count;
            private String url;
            private String note;
            private int sort;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getClick_Count() {
                return click_Count;
            }

            public void setClick_Count(int click_Count) {
                this.click_Count = click_Count;
            }

            public int getOrder_Count() {
                return order_Count;
            }

            public void setOrder_Count(int order_Count) {
                this.order_Count = order_Count;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }
        }

        public static class HomeHotListBean {
            /**
             * id : 1
             * gmt_Create : 2020-03-15T17:10:14.000+0000
             * gmt_Modified : 2020-03-15T17:10:22.000+0000
             * product_Id : 28
             * product_Name : 小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待
             * pic : http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg
             * market_Price : 649.0
             * pat_Price : 5.0
             * bid_Count : 5
             */

            private int id;
            private String gmt_Create;
            private String gmt_Modified;
            private int product_Id;
            private String product_Name;
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

            public String getGmt_Modified() {
                return gmt_Modified;
            }

            public void setGmt_Modified(String gmt_Modified) {
                this.gmt_Modified = gmt_Modified;
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

        public static class ProductCategoryDaoListBean {
            /**
             * id : 1
             * gmt_Create : 2020-03-19T05:00:00.000+0000
             * gmt_Modified : 2020-03-19T14:43:10.000+0000
             * category_Name : 生活充值
             * level : 0
             * parent_Id : null
             * product_Unit : 件
             * nav_Status : 1
             * show_Status : 1
             * icon : null
             * keywords : 生活充值
             */

            private int id;
            private String gmtCreate;
            private String gmtModified;
            private String categoryName;
            private int level;
            private Object parentId;
            private String productUnit;
            private int navStatus;
            private int showStatus;
            private Object icon;
            private String keywords;

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

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public Object getParentId() {
                return parentId;
            }

            public void setParentId(Object parentId) {
                this.parentId = parentId;
            }

            public String getProductUnit() {
                return productUnit;
            }

            public void setProductUnit(String productUnit) {
                this.productUnit = productUnit;
            }

            public int getNavStatus() {
                return navStatus;
            }

            public void setNavStatus(int navStatus) {
                this.navStatus = navStatus;
            }

            public int getShowStatus() {
                return showStatus;
            }

            public void setShowStatus(int showStatus) {
                this.showStatus = showStatus;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }
        }
    }
}
