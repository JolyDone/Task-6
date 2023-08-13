package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {

    private CarServiceImp carServiceImp;

    @Autowired
    public CarController(CarServiceImp carServiceImp){
        this.carServiceImp = carServiceImp;
    }


    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "0") int count, ModelMap model) {
        List<Car> cars = carServiceImp.getCarList(count);
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping(value = "/clearcars")
    public String getCars(ModelMap model) {
        List<Car> cars = carServiceImp.clearCarList();
        model.addAttribute("cars", cars);
        return "cars";
    }


}
