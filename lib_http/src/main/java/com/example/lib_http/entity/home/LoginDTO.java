package com.example.lib_http.entity.home;

/**
 * Created by qiubin on 2020-05-03.
 * Describe:
 */
public class LoginDTO {


    /**
     * code : 200
     * message : 登陆成功
     * data : {"umsMemberDao":{"id":12,"memberLevelId":5,"username":"18378583473","password":"123456","nickname":"方响","phone":"18852895349","status":1,"createTime":1587202722000,"icon":"avatar2.jpg","gender":0,"birthday":1587139200000,"city":"杭州","job":"学生","personalizedSignature":"超级马里奥码代码","patCoin":35,"growth":null,"loginStatus":false,"salt":null,"manager":1},"serializable":"37FCD001A3BCAB7622F2A64B598004F4"}
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
         * umsMemberDao : {"id":12,"memberLevelId":5,"username":"18378583473","password":"123456","nickname":"方响","phone":"18852895349","status":1,"createTime":1587202722000,"icon":"avatar2.jpg","gender":0,"birthday":1587139200000,"city":"杭州","job":"学生","personalizedSignature":"超级马里奥码代码","patCoin":35,"growth":null,"loginStatus":false,"salt":null,"manager":1}
         * serializable : 37FCD001A3BCAB7622F2A64B598004F4
         */

        private UmsMemberDaoBean umsMemberDao;
        private String serializable;

        public UmsMemberDaoBean getUmsMemberDao() {
            return umsMemberDao;
        }

        public void setUmsMemberDao(UmsMemberDaoBean umsMemberDao) {
            this.umsMemberDao = umsMemberDao;
        }

        public String getSerializable() {
            return serializable;
        }

        public void setSerializable(String serializable) {
            this.serializable = serializable;
        }

        public static class UmsMemberDaoBean {
            /**
             * id : 12
             * memberLevelId : 5
             * username : 18378583473
             * password : 123456
             * nickname : 方响
             * phone : 18852895349
             * status : 1
             * createTime : 1587202722000
             * icon : avatar2.jpg
             * gender : 0
             * birthday : 1587139200000
             * city : 杭州
             * job : 学生
             * personalizedSignature : 超级马里奥码代码
             * patCoin : 35
             * growth : null
             * loginStatus : false
             * salt : null
             * manager : 1
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
            private Object growth;
            private boolean loginStatus;
            private Object salt;
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

            public Object getGrowth() {
                return growth;
            }

            public void setGrowth(Object growth) {
                this.growth = growth;
            }

            public boolean isLoginStatus() {
                return loginStatus;
            }

            public void setLoginStatus(boolean loginStatus) {
                this.loginStatus = loginStatus;
            }

            public Object getSalt() {
                return salt;
            }

            public void setSalt(Object salt) {
                this.salt = salt;
            }

            public int getManager() {
                return manager;
            }

            public void setManager(int manager) {
                this.manager = manager;
            }
        }
    }
}
