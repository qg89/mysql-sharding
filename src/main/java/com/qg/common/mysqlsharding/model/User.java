package com.qg.common.mysqlsharding.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1130162073778897221L;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 数据源工厂名称
     */
    private String sqlSessionFactoryBeanName;
    /**
     * 数据源名称
     */
    private String sqlSessionBeanName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSqlSessionFactoryBeanName() {
        return sqlSessionFactoryBeanName;
    }

    public void setSqlSessionFactoryBeanName(String sqlSessionFactoryBeanName) {
        this.sqlSessionFactoryBeanName = sqlSessionFactoryBeanName;
    }

    public String getSqlSessionBeanName() {
        return sqlSessionBeanName;
    }

    public void setSqlSessionBeanName(String sqlSessionBeanName) {
        this.sqlSessionBeanName = sqlSessionBeanName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return new EqualsBuilder().append(userName, user.userName).append(passWord, user.passWord).append(sqlSessionFactoryBeanName, user.sqlSessionFactoryBeanName).append(sqlSessionBeanName, user.sqlSessionBeanName).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userName", userName)
                .append("passWord", passWord)
                .append("sqlSessionFactoryBeanName", sqlSessionFactoryBeanName)
                .append("sqlSessionBeanName", sqlSessionBeanName)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(userName).append(passWord).append(sqlSessionFactoryBeanName).append(sqlSessionBeanName).toHashCode();
    }

    public static final class UserBuilder {
        private User user;

        private UserBuilder() {
            user = new User();
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder userName(String userName) {
            user.setUserName(userName);
            return this;
        }

        public UserBuilder passWord(String passWord) {
            user.setPassWord(passWord);
            return this;
        }

        public UserBuilder sqlSessionFactoryBeanName(String sqlSessionFactoryBeanName) {
            user.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
            return this;
        }

        public UserBuilder sqlSessionBeanName(String sqlSessionBeanName) {
            user.setSqlSessionBeanName(sqlSessionBeanName);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
