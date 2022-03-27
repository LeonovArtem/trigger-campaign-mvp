package com.mostbet.triggerCampaign.entity;

public enum CouponStatus {
    UNDEFINED(0),
    NEW(1),
    OPEN(100),
    CANCEL(200),
    LOSE(210),
    WIN(220),
    REJECTED(240),
    DECLINED(260);

    private final Integer value;

    private CouponStatus(Integer value) {
        this.value = value;
    }

    public boolean isClosed() {
        return this.equals(WIN) || this.equals(LOSE) || this.equals(CANCEL) || this.equals(REJECTED);
    }

    public boolean isWin() {
        return this.equals(WIN);
    }

    public boolean isCancel() {
        return this.equals(CANCEL) || this.equals(REJECTED);
    }

    public boolean isTerminalStatus() {
        return this.equals(LOSE) || this.equals(WIN) || this.equals(CANCEL) || this.equals(REJECTED);
    }
}
