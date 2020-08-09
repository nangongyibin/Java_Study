package com.ngyb.study.test.other;

import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 10:08
 */
public class Result {
    private String resultCode = "";
    private String resultMessage = "";
    private String page;
    private String size;
    private String total_result;
    private String total_pages;
    private String start_time;
    private String end_time;
    private List<PersonInfo> staff;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotal_result() {
        return total_result;
    }

    public void setTotal_result(String total_result) {
        this.total_result = total_result;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public List<PersonInfo> getStaff() {
        return staff;
    }

    public void setStaff(List<PersonInfo> staff) {
        this.staff = staff;
    }
}
