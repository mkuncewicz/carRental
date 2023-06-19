package com.example.carrental.mapper;

import com.example.carrental.domain.CalendarDto;
import com.example.carrental.entity.Calendar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarMapper {

    public Calendar mapToCalendar(final CalendarDto calendarDto){

        return new Calendar(calendarDto.getId(), calendarDto.getDate());
    }

    public CalendarDto mapToCalendarDto(final Calendar calendar){

        return new CalendarDto(calendar.getId(), calendar.getDate());
    }

    public List<CalendarDto> mapToCalendarDtoList(final List<Calendar> list){

        return list.stream().
                map(this::mapToCalendarDto)
                .collect(Collectors.toList());
    }

}
