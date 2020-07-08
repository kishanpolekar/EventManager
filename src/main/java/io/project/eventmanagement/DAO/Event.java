package io.project.eventmanagement.DAO;

import jdk.nashorn.internal.runtime.ParserException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.text.html.parser.Parser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String startDate;
    private String endDate;
    private int duration;

    private boolean checkDate(String d) {

            try {
                new SimpleDateFormat("MM-dd-yyyy").parse(d);
            } catch (ParseException e) {

                throw new ParserException("\n\nInvalid date format!\nUse: MM-dd-yyyy\n");
            }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {

        if (checkDate(startDate))
                this.startDate = startDate;
            else
                this.startDate = "";
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {

        if (checkDate(endDate))
                this.endDate = endDate;
            else
                this.endDate = "";
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
