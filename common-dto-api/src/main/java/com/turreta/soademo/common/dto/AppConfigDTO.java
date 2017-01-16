package com.turreta.soademo.common.dto;

/**
 * Created by SANG018 on 1/16/2017.
 */
public class AppConfigDTO {

    private String applicationName;
    private String version;
    private Boolean isEnabled;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean enabled) {
        this.isEnabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppConfigDTO that = (AppConfigDTO) o;

        if (!applicationName.equals(that.applicationName)) return false;
        if (!version.equals(that.version)) return false;
        return isEnabled.equals(that.isEnabled);
    }

    @Override
    public int hashCode() {
        int result = applicationName.hashCode();
        result = 31 * result + version.hashCode();
        result = 31 * result + isEnabled.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AppConfigDTO{" +
                "applicationName='" + applicationName + '\'' +
                ", version='" + version + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
