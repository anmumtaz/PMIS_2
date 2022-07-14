package com.example.pmis_2;

public class ScopeInfo {
    private String projectScope1;
    private String projectScope2;
    private String deliv1;
    private String deliv2;
    private String dod1;
    private String dod2;

    public ScopeInfo() {
    }

    public ScopeInfo(String projectScope1, String projectScope2, String deliv1, String deliv2, String dod1, String dod2) {
        this.projectScope1 = projectScope1;
        this.projectScope2 = projectScope2;
        this.deliv1 = deliv1;
        this.deliv2 = deliv2;
        this.dod1 = dod1;
        this.dod2 = dod2;
    }

    public String getProjectScope1() {
        return projectScope1;
    }

    public void setProjectScope1(String projectScope1) {
        this.projectScope1 = projectScope1;
    }

    public String getProjectScope2() {
        return projectScope2;
    }

    public void setProjectScope2(String projectScope2) {
        this.projectScope2 = projectScope2;
    }

    public String getDeliv1() {
        return deliv1;
    }

    public void setDeliv1(String deliv1) {
        this.deliv1 = deliv1;
    }

    public String getDeliv2() {
        return deliv2;
    }

    public void setDeliv2(String deliv2) {
        this.deliv2 = deliv2;
    }

    public String getDod1() {
        return dod1;
    }

    public void setDod1(String dod1) {
        this.dod1 = dod1;
    }

    public String getDod2() {
        return dod2;
    }

    public void setDod2(String dod2) {
        this.dod2 = dod2;
    }
}
