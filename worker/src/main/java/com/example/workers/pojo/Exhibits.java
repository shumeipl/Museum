package com.example.workers.pojo;

public class Exhibits {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.exhibit_id
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private Integer exhibitId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.venue_name
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private String venueName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.type
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private String type;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.location
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.open_time
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private String openTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.work_id
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private Integer workId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.phone
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.clink
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private Long clink;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exhibits.capacity
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    private Integer capacity;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.exhibit_id
     *
     * @return the value of exhibits.exhibit_id
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public Integer getExhibitId() {
        return exhibitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.exhibit_id
     *
     * @param exhibitId the value for exhibits.exhibit_id
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setExhibitId(Integer exhibitId) {
        this.exhibitId = exhibitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.venue_name
     *
     * @return the value of exhibits.venue_name
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public String getVenueName() {
        return venueName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.venue_name
     *
     * @param venueName the value for exhibits.venue_name
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName == null ? null : venueName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.type
     *
     * @return the value of exhibits.type
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.type
     *
     * @param type the value for exhibits.type
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.location
     *
     * @return the value of exhibits.location
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.location
     *
     * @param location the value for exhibits.location
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.open_time
     *
     * @return the value of exhibits.open_time
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.open_time
     *
     * @param openTime the value for exhibits.open_time
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.work_id
     *
     * @return the value of exhibits.work_id
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public Integer getWorkId() {
        return workId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.work_id
     *
     * @param workId the value for exhibits.work_id
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.phone
     *
     * @return the value of exhibits.phone
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.phone
     *
     * @param phone the value for exhibits.phone
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.clink
     *
     * @return the value of exhibits.clink
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public Long getClink() {
        return clink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.clink
     *
     * @param clink the value for exhibits.clink
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setClink(Long clink) {
        this.clink = clink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exhibits.capacity
     *
     * @return the value of exhibits.capacity
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exhibits.capacity
     *
     * @param capacity the value for exhibits.capacity
     *
     * @mbg.generated Sat Nov 26 20:35:52 CST 2022
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}