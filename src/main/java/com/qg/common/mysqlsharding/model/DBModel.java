package com.qg.common.mysqlsharding.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DBModel implements Serializable {


    private String beanName;
    private String driver;
    private String url;
    private String username;
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof DBModel)) {
            return false;
        }

        DBModel dbModel = (DBModel) o;

        return new EqualsBuilder().append(beanName, dbModel.beanName).append(driver, dbModel.driver).append(url, dbModel.url).append(username, dbModel.username).append(password, dbModel.password).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(beanName).append(driver).append(url).append(username).append(password).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("beanName", beanName)
                .append("driver", driver)
                .append("url", url)
                .append("username", username)
                .append("password", password)
                .toString();
    }
}
