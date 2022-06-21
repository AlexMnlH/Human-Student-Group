package net.ukr.ahavrykin;

public enum Sex {
    MALE ("M"), FEMALE ("F");
    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    Sex() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
