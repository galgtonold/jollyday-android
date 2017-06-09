package de.galgtonold.jollydayandroidexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import de.galgtonold.jollydayandroid.Holiday;
import de.galgtonold.jollydayandroid.HolidayCalendar;
import de.galgtonold.jollydayandroid.HolidayManager;
import de.galgtonold.jollydayandroid.R;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    List<String> listItems=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(de.galgtonold.jollydayandroidexample.R.layout.activity_main);

        ListView holidayList = (ListView) findViewById(de.galgtonold.jollydayandroidexample.R.id.holiday_list);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        holidayList.setAdapter(adapter);

        HolidayManager m = HolidayManager.getInstance(HolidayCalendar.UNITED_STATES);
        Set<Holiday> holidays = m.getHolidays(2010, "ny");
        for (Holiday holiday : holidays) {
            listItems.add(holiday.getDate() + "\t" + holiday.getDescription());
        }

        adapter.notifyDataSetChanged();
    }
}
