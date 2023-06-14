package com.example.carrental.vadin;

//import com.example.carrental.database.DbCar;
//import com.example.carrental.entity.Car;
//import com.example.carrental.repository.CarRepository;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//@Route
//@Component
//public class MainView extends VerticalLayout {
//
//    private Grid<Car> grid = new Grid<>(Car.class);
//
//    @Autowired
//    private CarRepository carRepository;
//
//    public MainView() {
//        grid.setColumns("brandName","enPower","pricePerDay");
//        add(grid);
//        setSizeFull();
//        refresh();
//    }
//
//    public void refresh(){
//        grid.setItems(carRepository.findAll());
//    }
//
//}
