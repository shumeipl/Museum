package com.example.workers.dao;

import com.example.workers.pojo.Bookings;
import com.example.workers.pojo.BookingsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookingsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    long countByExample(BookingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    int deleteByExample(BookingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    int deleteByPrimaryKey(Integer bookingId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    int insert(Bookings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    int insertSelective(Bookings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    List<Bookings> selectByExample(BookingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    Bookings selectByPrimaryKey(Integer bookingId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    int updateByExampleSelective(@Param("record") Bookings record, @Param("example") BookingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    int updateByExample(@Param("record") Bookings record, @Param("example") BookingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    int updateByPrimaryKeySelective(Bookings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bookings
     *
     * @mbg.generated Sat Nov 26 20:24:13 CST 2022
     */
    int updateByPrimaryKey(Bookings record);
}