package com.example.carrental.mapper;

import com.example.carrental.domain.TimetableDto;
import com.example.carrental.entity.Timetable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimetableMapper {

    public Timetable mapToCalendar(final TimetableDto calendarDto){

        return new Timetable(calendarDto.getId(), calendarDto.getDate());
    }

    public TimetableDto mapToCalendarDto(final Timetable calendar){

        return new TimetableDto(calendar.getId(), calendar.getDate());
    }

    public List<TimetableDto> mapToCalendarDtoList(final List<Timetable> list){

        return list.stream().
                map(this::mapToCalendarDto)
                .collect(Collectors.toList());
    }

}
