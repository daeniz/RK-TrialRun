/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dennisschmock
 */
@Entity
@NamedQueries({
@NamedQuery(name = "SamaritCalenderEvent.findByUserName", query = "SELECT w FROM SamaritCalenderEvent AS w WHERE w.samarit.userName = :userName")})
@JsonFilter("myFilter")
public class SamaritCalenderEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Samarit samarit;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Event event;

    private boolean watchSet;
    private boolean isAvailable;
    private boolean allDay;
    
    private String title;
    private String rendering;
    private String color;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WATCHSTART")
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WATCHEND")
    private Date end;
    
    

    public SamaritCalenderEvent() {
    }

    public SamaritCalenderEvent(Samarit samarit, Event event, Date start, Date end, boolean isAvailable) {
        this.samarit = samarit;
        this.event = event;
        this.start = start;
        this.end = end;
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the samarit
     */
    public Samarit getSamarit() {
        return samarit;
    }

    public SamaritCalenderEvent(Samarit samarit, Date start, boolean isAvailable) {
        this.samarit = samarit;
        samarit.addWatch(this);
        this.start = start;
        this.isAvailable = isAvailable;
    }

    public void setSamaritWithWatch(Samarit samarit) {
        this.setSamarit(samarit);
        samarit.getWatches().add(this);
    }

    /**
     * @param samarit the samarit to set
     */
    public void setSamarit(Samarit samarit) {
        this.samarit = samarit;
        samarit.addWatch(this);
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return the isAvailable
     */
    public boolean isIsAvailable() {
        return isAvailable;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * @return the watchSet
     */
    public boolean isWatchSet() {
        return watchSet;
    }

    /**
     * @param watchSet the watchSet to set
     */
    public void setWatchSet(boolean watchSet) {
        this.watchSet = watchSet;
    }

    /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * @return the allDay
     */
    public boolean isAllDay() {
        return allDay;
    }

    /**
     * @param allDay the allDay to set
     */
    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the rendering
     */
    public String getRendering() {
        return rendering;
    }

    /**
     * @param rendering the rendering to set
     */
    public void setRendering(String rendering) {
        this.rendering = rendering;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

}
