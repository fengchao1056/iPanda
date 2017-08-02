package com.example.a123.pandatv.model.entity;

import java.io.Serializable;

/**
 * Created by lizhuofang on 2017/7/23.
 */

public class UpDateLoading implements Serializable{

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * versionsName : 1.5.0
         * versionsNum : 150
         * versionsMin : 120
         * versionsinfo : 1.修复已知Bug。
         * applyName : 1426217325
         * versionsUrl : http://download.cntv.cn/app/ipanda/PandaTV_V1.5.0_2017-01-18.apk
         * state : 1
         * typeName : 3
         * versionsUpdate : 1
         */

        private String versionsName;
        private String versionsNum;
        private String versionsMin;
        private String versionsinfo;
        private String applyName;
        private String versionsUrl;
        private String state;
        private String typeName;
        private String versionsUpdate;

        public String getVersionsName() {
            return versionsName;
        }

        public void setVersionsName(String versionsName) {
            this.versionsName = versionsName;
        }

        public String getVersionsNum() {
            return versionsNum;
        }

        public void setVersionsNum(String versionsNum) {
            this.versionsNum = versionsNum;
        }

        public String getVersionsMin() {
            return versionsMin;
        }

        public void setVersionsMin(String versionsMin) {
            this.versionsMin = versionsMin;
        }

        public String getVersionsinfo() {
            return versionsinfo;
        }

        public void setVersionsinfo(String versionsinfo) {
            this.versionsinfo = versionsinfo;
        }

        public String getApplyName() {
            return applyName;
        }

        public void setApplyName(String applyName) {
            this.applyName = applyName;
        }

        public String getVersionsUrl() {
            return versionsUrl;
        }

        public void setVersionsUrl(String versionsUrl) {
            this.versionsUrl = versionsUrl;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getVersionsUpdate() {
            return versionsUpdate;
        }

        public void setVersionsUpdate(String versionsUpdate) {
            this.versionsUpdate = versionsUpdate;
        }
    }
}
