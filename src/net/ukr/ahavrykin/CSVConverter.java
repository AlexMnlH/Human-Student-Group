package net.ukr.ahavrykin;

public interface CSVConverter {

    public String toCSVString();

    public Student fromCSVString(String str);
}

