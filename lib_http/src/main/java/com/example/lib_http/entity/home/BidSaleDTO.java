package com.example.lib_http.entity.home;

import java.util.List;

/**
 * Created by qiubin on 2020-05-09.
 * Describe:
 */
public class BidSaleDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : {"bidResultList":[{"id":2,"userId":12,"productId":28,"pic":"/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg","bids":6,"bidPrice":15,"bidState":"竞拍失败"}]}
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
        private List<BidResultListBean> bidResultList;

        public List<BidResultListBean> getBidResultList() {
            return bidResultList;
        }

        public void setBidResultList(List<BidResultListBean> bidResultList) {
            this.bidResultList = bidResultList;
        }

        public static class BidResultListBean {
            /**
             * id : 2
             * userId : 12
             * productId : 28
             * pic : /20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg,/20180615/5a9d248cN071f4959.jpg
             * bids : 6
             * bidPrice : 15.0
             * bidState : 竞拍失败
             */

            private int id;
            private int userId;
            private int productId;
            private String title;
            private String pic;
            private int bids;
            private double bidPrice;
            private String bidState;

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getBids() {
                return bids;
            }

            public void setBids(int bids) {
                this.bids = bids;
            }

            public double getBidPrice() {
                return bidPrice;
            }

            public void setBidPrice(double bidPrice) {
                this.bidPrice = bidPrice;
            }

            public String getBidState() {
                return bidState;
            }

            public void setBidState(String bidState) {
                this.bidState = bidState;
            }
        }
    }
}
