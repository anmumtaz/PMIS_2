package com.example.pmis_2;

import android.os.Parcel;
import android.os.Parcelable;

public class ProjectListData implements Parcelable {
    private String id;
    private String project_name;
    private String customer;
    private String project_manager;
    private String start_date;
    private String finish_date;
    private String projectScope1;
    private String projectScope2;
    private String deliv1;
    private String deliv2;
    private String dod1;
    private String dod2;
    private String Task1;
    private String Task2;
    private String Task3;
    private String Task4;
    private String Task5;
    private String PIC1;
    private String PIC2;
    private String PIC3;
    private String PIC4;
    private String PIC5;
    private String Urg1;
    private String Urg2;
    private String Urg3;
    private String Urg4;
    private String Urg5;
    private String Stat1;
    private String Stat2;
    private String Stat3;
    private String Stat4;
    private String Stat5;
    private String TL1;
    private String TL2;
    private String TL3;
    private String TL4;
    private String TL5;

    public ProjectListData() {}

    public ProjectListData(String key, String project_name, String customer, String project_manager, String start_date, String finish_date, String projectScope1, String projectScope2, String deliv1, String deliv2, String dod1, String dod2, String task1, String task2, String task3, String task4, String task5, String PIC1, String PIC2, String PIC3, String PIC4, String PIC5, String urg1, String urg2, String urg3, String urg4, String urg5, String stat1, String stat2, String stat3, String stat4, String stat5, String tl1, String tl2, String tl3, String tl4, String tl5) {
        this.id = key;
        this.project_name = project_name;
        this.customer = customer;
        this.project_manager = project_manager;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.projectScope1 = projectScope1;
        this.projectScope2 = projectScope2;
        this.deliv1 = deliv1;
        this.deliv2 = deliv2;
        this.dod1 = dod1;
        this.dod2 = dod2;
        Task1 = task1;
        Task2 = task2;
        Task3 = task3;
        Task4 = task4;
        Task5 = task5;
        this.PIC1 = PIC1;
        this.PIC2 = PIC2;
        this.PIC3 = PIC3;
        this.PIC4 = PIC4;
        this.PIC5 = PIC5;
        Urg1 = urg1;
        Urg2 = urg2;
        Urg3 = urg3;
        Urg4 = urg4;
        Urg5 = urg5;
        Stat1 = stat1;
        Stat2 = stat2;
        Stat3 = stat3;
        Stat4 = stat4;
        Stat5 = stat5;
        TL1 = tl1;
        TL2 = tl2;
        TL3 = tl3;
        TL4 = tl4;
        TL5 = tl5;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProject_manager() {
        return project_manager;
    }

    public void setProject_manager(String project_manager) {
        this.project_manager = project_manager;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(String finish_date) {
        this.finish_date = finish_date;
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

    public String getTask1() {
        return Task1;
    }

    public void setTask1(String task1) {
        Task1 = task1;
    }

    public String getTask2() {
        return Task2;
    }

    public void setTask2(String task2) {
        Task2 = task2;
    }

    public String getTask3() {
        return Task3;
    }

    public void setTask3(String task3) {
        Task3 = task3;
    }

    public String getTask4() {
        return Task4;
    }

    public void setTask4(String task4) {
        Task4 = task4;
    }

    public String getTask5() {
        return Task5;
    }

    public void setTask5(String task5) {
        Task5 = task5;
    }

    public String getPIC1() {
        return PIC1;
    }

    public void setPIC1(String PIC1) {
        this.PIC1 = PIC1;
    }

    public String getPIC2() {
        return PIC2;
    }

    public void setPIC2(String PIC2) {
        this.PIC2 = PIC2;
    }

    public String getPIC3() {
        return PIC3;
    }

    public void setPIC3(String PIC3) {
        this.PIC3 = PIC3;
    }

    public String getPIC4() {
        return PIC4;
    }

    public void setPIC4(String PIC4) {
        this.PIC4 = PIC4;
    }

    public String getPIC5() {
        return PIC5;
    }

    public void setPIC5(String PIC5) {
        this.PIC5 = PIC5;
    }

    public String getUrg1() {
        return Urg1;
    }

    public void setUrg1(String urg1) {
        Urg1 = urg1;
    }

    public String getUrg2() {
        return Urg2;
    }

    public void setUrg2(String urg2) {
        Urg2 = urg2;
    }

    public String getUrg3() {
        return Urg3;
    }

    public void setUrg3(String urg3) {
        Urg3 = urg3;
    }

    public String getUrg4() {
        return Urg4;
    }

    public void setUrg4(String urg4) {
        Urg4 = urg4;
    }

    public String getUrg5() {
        return Urg5;
    }

    public void setUrg5(String urg5) {
        Urg5 = urg5;
    }

    public String getStat1() {
        return Stat1;
    }

    public void setStat1(String stat1) {
        Stat1 = stat1;
    }

    public String getStat2() {
        return Stat2;
    }

    public void setStat2(String stat2) {
        Stat2 = stat2;
    }

    public String getStat3() {
        return Stat3;
    }

    public void setStat3(String stat3) {
        Stat3 = stat3;
    }

    public String getStat4() {
        return Stat4;
    }

    public void setStat4(String stat4) {
        Stat4 = stat4;
    }

    public String getStat5() {
        return Stat5;
    }

    public void setStat5(String stat5) {
        Stat5 = stat5;
    }

    public String getTL1() {
        return TL1;
    }

    public void setTL1(String TL1) {
        this.TL1 = TL1;
    }

    public String getTL2() {
        return TL2;
    }

    public void setTL2(String TL2) {
        this.TL2 = TL2;
    }

    public String getTL3() {
        return TL3;
    }

    public void setTL3(String TL3) {
        this.TL3 = TL3;
    }

    public String getTL4() {
        return TL4;
    }

    public void setTL4(String TL4) {
        this.TL4 = TL4;
    }

    public String getTL5() {
        return TL5;
    }

    public void setTL5(String TL5) {
        this.TL5 = TL5;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.project_name);
        dest.writeString(this.customer);
        dest.writeString(this.project_manager);
        dest.writeString(this.start_date);
        dest.writeString(this.finish_date);
        dest.writeString(this.projectScope1);
        dest.writeString(this.projectScope2);
        dest.writeString(this.deliv1);
        dest.writeString(this.deliv2);
        dest.writeString(this.dod1);
        dest.writeString(this.dod2);
        dest.writeString(this.Task1);
        dest.writeString(this.Task2);
        dest.writeString(this.Task3);
        dest.writeString(this.Task4);
        dest.writeString(this.Task5);
        dest.writeString(this.PIC1);
        dest.writeString(this.PIC2);
        dest.writeString(this.PIC3);
        dest.writeString(this.PIC4);
        dest.writeString(this.PIC5);
        dest.writeString(this.Urg1);
        dest.writeString(this.Urg2);
        dest.writeString(this.Urg3);
        dest.writeString(this.Urg4);
        dest.writeString(this.Urg5);
        dest.writeString(this.Stat1);
        dest.writeString(this.Stat2);
        dest.writeString(this.Stat3);
        dest.writeString(this.Stat4);
        dest.writeString(this.Stat5);
        dest.writeString(this.TL1);
        dest.writeString(this.TL2);
        dest.writeString(this.TL3);
        dest.writeString(this.TL4);
        dest.writeString(this.TL5);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readString();
        this.project_name = source.readString();
        this.customer = source.readString();
        this.project_manager = source.readString();
        this.start_date = source.readString();
        this.finish_date = source.readString();
        this.projectScope1 = source.readString();
        this.projectScope2 = source.readString();
        this.deliv1 = source.readString();
        this.deliv2 = source.readString();
        this.dod1 = source.readString();
        this.dod2 = source.readString();
        this.Task1 = source.readString();
        this.Task2 = source.readString();
        this.Task3 = source.readString();
        this.Task4 = source.readString();
        this.Task5 = source.readString();
        this.PIC1 = source.readString();
        this.PIC2 = source.readString();
        this.PIC3 = source.readString();
        this.PIC4 = source.readString();
        this.PIC5 = source.readString();
        this.Urg1 = source.readString();
        this.Urg2 = source.readString();
        this.Urg3 = source.readString();
        this.Urg4 = source.readString();
        this.Urg5 = source.readString();
        this.Stat1 = source.readString();
        this.Stat2 = source.readString();
        this.Stat3 = source.readString();
        this.Stat4 = source.readString();
        this.Stat5 = source.readString();
        this.TL1 = source.readString();
        this.TL2 = source.readString();
        this.TL3 = source.readString();
        this.TL4 = source.readString();
        this.TL5 = source.readString();
    }

    protected ProjectListData(Parcel in) {
        this.id = in.readString();
        this.project_name = in.readString();
        this.customer = in.readString();
        this.project_manager = in.readString();
        this.start_date = in.readString();
        this.finish_date = in.readString();
        this.projectScope1 = in.readString();
        this.projectScope2 = in.readString();
        this.deliv1 = in.readString();
        this.deliv2 = in.readString();
        this.dod1 = in.readString();
        this.dod2 = in.readString();
        this.Task1 = in.readString();
        this.Task2 = in.readString();
        this.Task3 = in.readString();
        this.Task4 = in.readString();
        this.Task5 = in.readString();
        this.PIC1 = in.readString();
        this.PIC2 = in.readString();
        this.PIC3 = in.readString();
        this.PIC4 = in.readString();
        this.PIC5 = in.readString();
        this.Urg1 = in.readString();
        this.Urg2 = in.readString();
        this.Urg3 = in.readString();
        this.Urg4 = in.readString();
        this.Urg5 = in.readString();
        this.Stat1 = in.readString();
        this.Stat2 = in.readString();
        this.Stat3 = in.readString();
        this.Stat4 = in.readString();
        this.Stat5 = in.readString();
        this.TL1 = in.readString();
        this.TL2 = in.readString();
        this.TL3 = in.readString();
        this.TL4 = in.readString();
        this.TL5 = in.readString();
    }

    public static final Parcelable.Creator<ProjectListData> CREATOR = new Parcelable.Creator<ProjectListData>() {
        @Override
        public ProjectListData createFromParcel(Parcel source) {
            return new ProjectListData(source);
        }

        @Override
        public ProjectListData[] newArray(int size) {
            return new ProjectListData[size];
        }
    };
}

