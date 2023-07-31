package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDaolmp;
import web.model.Car;

import java.util.List;


@Service
public class CarServicelmp implements CarService{

    private final CarDaolmp carDaolmp;

    public CarServicelmp(CarDaolmp carDaolmp) {
        this.carDaolmp = carDaolmp;
    }

    @Override
    public List<Car> getCarList(int count){
        List<Car> carList = carDaolmp.getCarList();
        if (count==0 || count>=5){
            return carList;
        }else {
            return carList.subList(0, count);
        }
    }

    public List<Car> clearCarList() {
        List<Car> carList = carDaolmp.getCarList();
        try {
            carList.clear();
            return carList;
        } catch (UnsupportedOperationException ignored){
        }
        return carList;
    }
}