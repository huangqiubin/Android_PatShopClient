package com.example.lib_http.entity.home;

/**
 * Created by qiubin on 2020-05-04.
 * Describe:
 */
public class MineContentDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : {"memberDao":{"id":12,"memberLevelId":5,"username":"18378583473","password":"123456","nickname":"方响","phone":"18852895349","status":1,"createTime":1587249522000,"icon":"avatar2.jpg","gender":0,"birthday":1587186000000,"city":"杭州","job":"学生","personalizedSignature":"超级马里奥码代码","patCoin":35,"growth":null,"loginStatus":0,"salt":null},"bidNumPOJO":{"bidNum":1,"onLooks":0,"footPrint":0}}
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
         * memberDao : {"id":12,"memberLevelId":5,"username":"18378583473","password":"123456","nickname":"方响","phone":"18852895349","status":1,"createTime":1587249522000,"icon":"avatar2.jpg","gender":0,"birthday":1587186000000,"city":"杭州","job":"学生","personalizedSignature":"超级马里奥码代码","patCoin":35,"growth":null,"loginStatus":0,"salt":null}
         * bidNumPOJO : {"bidNum":1,"onLooks":0,"footPrint":0}
         */

        private MemberDaoBean memberDao;
        private BidNumPOJOBean bidNumPOJO;

        public MemberDaoBean getMemberDao() {
            return memberDao;
        }

        public void setMemberDao(MemberDaoBean memberDao) {
            this.memberDao = memberDao;
        }

        public BidNumPOJOBean getBidNumPOJO() {
            return bidNumPOJO;
        }

        public void setBidNumPOJO(BidNumPOJOBean bidNumPOJO) {
            this.bidNumPOJO = bidNumPOJO;
        }

        public static class MemberDaoBean {
            /**
             * id : 12
             * memberLevelId : 5
             * username : 18378583473
             * password : 123456
             * nickname : 方响
             * phone : 18852895349
             * status : 1
             * createTime : 1587249522000
             * icon : avatar2.jpg
             * gender : 0
             * birthday : 1587186000000
             * city : 杭州
             * job : 学生
             * personalizedSignature : 超级马里奥码代码
             * patCoin : 35
             * growth : null
             * loginStatus : 0
             * salt : null
             */

            private int id;
            private int memberLevelId;
            private String username;
            private String password;
            private String nickname;
            private String phone;
            private int status;
            private long createTime;
            private String icon;
            private int gender;
            private long birthday;
            private String city;
            private String job;
            private String personalizedSignature;
            private int patCoin;
            private String growth;
            private Boolean loginStatus;
            private String salt;
            private int manager;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMemberLevelId() {
                return memberLevelId;
            }

            public void setMemberLevelId(int memberLevelId) {
                this.memberLevelId = memberLevelId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }

            public String getPersonalizedSignature() {
                return personalizedSignature;
            }

            public void setPersonalizedSignature(String personalizedSignature) {
                this.personalizedSignature = personalizedSignature;
            }

            public int getPatCoin() {
                return patCoin;
            }

            public void setPatCoin(int patCoin) {
                this.patCoin = patCoin;
            }

            public Boolean getLoginStatus() {
                return loginStatus;
            }

            public void setLoginStatus(Boolean loginStatus) {
                this.loginStatus = loginStatus;
            }

            public String getGrowth() {
                return growth;
            }

            public void setGrowth(String growth) {
                this.growth = growth;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            public int getManager() {
                return manager;
            }

            public void setManager(int manager) {
                this.manager = manager;
            }
        }

        public static class BidNumPOJOBean {
            /**
             * bidNum : 1
             * onLooks : 0
             * footPrint : 0
             */

            private int bidNum;
            private int onLooks;
            private int footPrint;

            public int getBidNum() {
                return bidNum;
            }

            public void setBidNum(int bidNum) {
                this.bidNum = bidNum;
            }

            public int getOnLooks() {
                return onLooks;
            }

            public void setOnLooks(int onLooks) {
                this.onLooks = onLooks;
            }

            public int getFootPrint() {
                return footPrint;
            }

            public void setFootPrint(int footPrint) {
                this.footPrint = footPrint;
            }
        }
    }
}
