package statics;

public enum TeacherLevel {

    GS_TS("GS - TS"),
    PGS_TS("PGS - TS"),
    GIANG_VIEN_CHINH("Giảng viên chính"),
    THAC_SY("Thạc sỹ");

    public String name;

    TeacherLevel(String name) {
        this.name = name;
    }

}
