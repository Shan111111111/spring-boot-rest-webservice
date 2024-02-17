package com.shantesh.springbootrestwebservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean  someBean = new SomeBean("value1", "value2", "value3");

        return getMappingJacksonValue("field2", "field3", new MappingJacksonValue(someBean));
    }

    private static MappingJacksonValue getMappingJacksonValue(String fieldA, String fieldB, MappingJacksonValue someBean) {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldA, fieldB);

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = someBean;
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-for-list-of-objects")
    public MappingJacksonValue retrieveListSomeBean(){
        List list = Arrays.asList( new SomeBean("value1", "value2", "value3"), new SomeBean("value11", "value22", "value33"));
        return getMappingJacksonValue("field1", "field2", new MappingJacksonValue(list));
    }
}
