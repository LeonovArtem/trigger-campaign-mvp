package com.mostbet.triggerCampaign.Replacer;

import com.github.database.rider.core.replacers.Replacer;
import org.dbunit.dataset.ReplacementDataSet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateTimeReplacer implements Replacer {
    @Override
    public void addReplacements(ReplacementDataSet dataSet) {
        final Date future = getDate(2);
        final Date past = getDate(-2);
        final Date now = getDate(0);

        dataSet.addReplacementSubstring(
                "[FUTURE_DATE]", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(future)
        );
        dataSet.addReplacementSubstring(
                "[PAST_DATE]", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(past)
        );
        dataSet.addReplacementSubstring(
                "[NOW]", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

    private Date getDate(int days) {
        final Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, days);

        return c.getTime();
    }
}
