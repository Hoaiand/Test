package vn.week2_lab2_doanhoaian_20116041.enums;

public enum ProductStatus {
    ACTIVE(1),
    PAUSED(0),
    DISCONTINUED(-1);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
