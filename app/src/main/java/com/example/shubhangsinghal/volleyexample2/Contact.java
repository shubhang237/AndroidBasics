package com.example.shubhangsinghal.volleyexample2;

class Contact {
  String mobile;
  String home;
  String office;

    public Contact(String mobile, String home, String office) {
        this.mobile = mobile;
        this.home = home;
        this.office = office;
    }

    public String getMobile() {
        return mobile;
    }

    public String getHome() {
        return home;
    }

    public String getOffice() {
        return office;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
