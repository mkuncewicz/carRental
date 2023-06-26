package com.example.carrental.nazwadozmiany;

import com.example.carrental.database.DbCar;
import com.example.carrental.entity.BodyType;
import com.example.carrental.entity.Car;
import com.example.carrental.entity.Fuel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


@SpringBootTest
@Transactional
public class CarFacadeTestSuite {


    @Test
    public void findBrandName(){
        //Given
        DbCar dbCar = mock(DbCar.class);
        CarFacade carFacade = new CarFacade(dbCar);
        given(dbCar.getAllCars()).willReturn(getTestDbCar());
        //When
        List<Car> mercedesList = carFacade.showCarWithBrandname("Mercedes");
        List<Car> audiList = carFacade.showCarWithBrandname("Audi");
        List<Car> bmwList = carFacade.showCarWithBrandname("BMW");
        //Then
        assertEquals(4,mercedesList.size());
        assertEquals(2,audiList.size());
        assertEquals(4,bmwList.size());
    }

    @Test
    public void findCarByPrice(){
        //Given
        DbCar dbCar = mock(DbCar.class);
        CarFacade carFacade = new CarFacade(dbCar);
        given(dbCar.getAllCars()).willReturn(getTestDbCar());
        //When
        List<Car> zeroArgs = carFacade.showCarWithPrice(0,0);
        List<Car> minArg = carFacade.showCarWithPrice(200.5f,0);
        List<Car> maxArg = carFacade.showCarWithPrice(0,300.f);
        List<Car> bothArgs = carFacade.showCarWithPrice(250,503);
        List<Car> badArgs = carFacade.showCarWithPrice(400,200);
        //Then
        assertEquals(10,zeroArgs.size());
        assertEquals(6,minArg.size());
        assertEquals(6,maxArg.size());
        assertEquals(3,bothArgs.size());
        assertEquals(0,badArgs.size());
    }

    private List<Car> getTestDbCar(){
        BodyType bodyType1 = new BodyType(1L,"Sedan",new ArrayList<>());
        BodyType bodyType2 = new BodyType(2L,"SUV",new ArrayList<>());
        BodyType bodyType3 = new BodyType(3L,"Coupe",new ArrayList<>());
        Fuel fuel = new Fuel(1L,"Gasoline",6.50f);
        Car car1 = new Car(1L,"Mercedes","CLA",bodyType1,fuel,42.0f,5,150,200.0f,"Wroclaw");
        Car car2 = new Car(2L,"BMW","M2",bodyType1,fuel,42.0f,5,210,250.0f,"Poznan");
        Car car3 = new Car(3L,"Mercedes","AMG GT",bodyType1,fuel,42.0f,5,137,175.0f,"Warszawa");
        Car car4 = new Car(4L,"Mercedes","Klasa G ",bodyType2,fuel,42.0f,5,571,525.0f,"Warszawa");
        Car car5 = new Car(5L,"BMW","M5",bodyType3,fuel,42.0f,5,510,430.0f,"Wroclaw");
        Car car6 = new Car(6L,"Audi","A7 ",bodyType1,fuel,42.0f,5,265,225.0f,"Lodz");
        Car car7 = new Car(7L,"Audi","S5",bodyType3,fuel,42.0f,5,333,155.0f,"Poznan");
        Car car8 = new Car(8L,"BMW","i7",bodyType1,fuel,42.0f,5,544,505.0f,"Warszawa");
        Car car9 = new Car(9L,"BMW","M4",bodyType3,fuel,42.0f,5,510,502.0f,"Lodz");
        Car car10 = new Car(10L,"Mercedes","CLS",bodyType3,fuel,42.0f,5,557,185.0f,"Gdansk");
        List<Car> listCars = List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);

        return listCars;
    }
}
