package com.example.lib_http.entity.home;

/**
 * Created by qiubin on 2020-05-05.
 * Describe:
 */
public class ActivityContentDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : {"signInModel":{"id":2,"username":"18378583473","signDate":1588727169000,"rewardCoin":4}}
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
         * signInModel : {"id":2,"username":"18378583473","signDate":1588727169000,"rewardCoin":4}
         */

        private SignInModelBean signInModel;
        private boolean yesterday;
        private boolean hasTodaySign;

        public SignInModelBean getSignInModel() {
            return signInModel;
        }

        public void setSignInModel(SignInModelBean signInModel) {
            this.signInModel = signInModel;
        }

        public boolean isYesterday() {
            return yesterday;
        }

        public void setYesterday(boolean yesterday) {
            this.yesterday = yesterday;
        }

        public boolean isHasTodaySign() {
            return hasTodaySign;
        }

        public void setHasTodaySign(boolean hasTodaySign) {
            this.hasTodaySign = hasTodaySign;
        }

        public static class SignInModelBean {
            /**
             * id : 2
             * username : 18378583473
             * signDate : 1588727169000
             * rewardCoin : 4
             */

            private int id;
            private String username;
            private long signDate;
            private int rewardCoin;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public long getSignDate() {
                return signDate;
            }

            public void setSignDate(long signDate) {
                this.signDate = signDate;
            }

            public int getRewardCoin() {
                return rewardCoin;
            }

            public void setRewardCoin(int rewardCoin) {
                this.rewardCoin = rewardCoin;
            }
        }
    }
}
