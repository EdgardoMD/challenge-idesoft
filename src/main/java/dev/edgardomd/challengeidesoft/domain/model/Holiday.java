package dev.edgardomd.challengeidesoft.domain.model;

import java.time.LocalDate;

public class Holiday {
    private LocalDate date;
    private String title;
    private String type;
    private boolean inalienable;
    private String extra;

    public static Holiday.HolidayBuilder builder() {
        return new Holiday.HolidayBuilder();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isInalienable() {
        return inalienable;
    }

    public void setInalienable(boolean inalienable) {
        this.inalienable = inalienable;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public static final class HolidayBuilder {
        private LocalDate date;
        private String title;
        private String type;
        private boolean inalienable;
        private String extra;

        private HolidayBuilder() {}

        public Holiday.HolidayBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Holiday.HolidayBuilder withTiTle(String title) {
            this.title = title;
            return this;
        }

        public Holiday.HolidayBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public Holiday.HolidayBuilder withInalienable(boolean inalienable) {
            this.inalienable = inalienable;
            return this;
        }

        public Holiday.HolidayBuilder withExtra(String extra) {
            this.extra = extra;
            return this;
        }

        public Holiday build() {
            Holiday holiday = new Holiday();
            holiday.setDate(this.date);
            holiday.setTitle(this.title);
            holiday.setType(this.type);
            holiday.setInalienable(this.inalienable);
            holiday.setExtra(this.extra);
            return holiday;
        }

    }
}
